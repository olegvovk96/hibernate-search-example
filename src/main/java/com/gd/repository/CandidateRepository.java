package com.gd.repository;

import com.gd.model.entity.Candidate;
import lombok.RequiredArgsConstructor;
import org.hibernate.graph.GraphSemantic;
import org.hibernate.search.engine.search.common.ValueConvert;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CandidateRepository {

    private final EntityManager entityManager;

    @Transactional
    public List<Candidate> findCandidatesByKeyWord(String keyWord) {
        SearchSession searchSession = Search.session(entityManager);

        EntityGraph<Candidate> graph = entityManager.createEntityGraph(Candidate.class);
        graph.addAttributeNodes("availabilities");
        graph.addAttributeNodes("hobbies");

        SearchResult<Candidate> candidateSearchResult = searchSession.search(Candidate.class)
                .where(f -> f.bool()
                        .should(f.match()
                                .fields("firstName", "lastName", "zipCode", "hobbies.name")
                                .matching(keyWord))
                        .should(f.match()
                                .field("education")
                                .matching(keyWord, ValueConvert.NO))
                        .should(f.match()
                                .field("availabilities")
                                .matching(keyWord, ValueConvert.NO))
                )
                .loading(o -> o.graph(graph, GraphSemantic.FETCH))
                .fetchAll();

        return candidateSearchResult.hits();
    }
}
