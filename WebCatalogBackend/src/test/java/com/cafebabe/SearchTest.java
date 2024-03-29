package com.cafebabe;

import com.cafebabe.entity.ShopItem;
import com.cafebabe.entity.User;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class SearchTest {

    @Autowired
    protected EntityManager entityManager;

    @Test
    @Transactional
    public void testSearch() {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(ShopItem.class).get();
        Query query = queryBuilder.keyword().fuzzy().onField("name").matching("POCO X3").createQuery();
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, ShopItem.class);
        List resultList = fullTextQuery.getResultList();
    }

    @Test
    @Transactional
    public void findShopAdminByNameAndSurname() {

    }

    @Test
    @Transactional
    public void findShopAdminByEmail() {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager
                .getSearchFactory()
                .buildQueryBuilder()
                .forEntity(User.class).get();
        Query query = queryBuilder.keyword().fuzzy().onField("email").matching("admin").createQuery();
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, User.class);
        List resultList = fullTextQuery.getResultList();
    }
}
