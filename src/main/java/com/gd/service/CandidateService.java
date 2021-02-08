package com.gd.service;

import com.gd.model.entity.Candidate;
import com.gd.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public List<Candidate> findCandidates(String keyWord) {
        return candidateRepository.findCandidatesByKeyWord(keyWord);
    }
}
