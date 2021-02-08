package com.gd;

import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class HibernateSearchDemoApplication {

	@PersistenceContext
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(HibernateSearchDemoApplication.class, args);
	}

	@Transactional
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		SearchSession searchSession = Search.session(entityManager);

		try {
			searchSession.massIndexer()
					.threadsToLoadObjects(5)
					.startAndWait();
		} catch (InterruptedException e) {
			System.out.println("Error occurred trying to build Hibernate Search indexes " + e.toString());
		}
	}
}
