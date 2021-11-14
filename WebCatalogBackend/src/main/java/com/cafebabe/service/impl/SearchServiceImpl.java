package com.cafebabe.service.impl;

import com.cafebabe.entity.ShopItem;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class SearchServiceImpl {

    @Autowired
    protected EntityManager entityManager;

    public List<ShopItem> findByName(String name) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(ShopItem.class).get();
        Query query = queryBuilder.keyword().fuzzy().onField("name").matching(name).createQuery();
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, ShopItem.class);
        return fullTextQuery.getResultList();
    }
}
