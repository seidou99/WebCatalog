package com.cafebabe;

import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@SpringBootApplication
public class WebCatalogBackendApplication implements ApplicationRunner {

    @Autowired
    protected EntityManager entityManager;


    public static void main(String[] args) {
        SpringApplication.run(WebCatalogBackendApplication.class, args);
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Indexing started");
        Search.getFullTextEntityManager(this.entityManager).createIndexer().startAndWait();
        System.out.println("All entities indexed");
    }
}
