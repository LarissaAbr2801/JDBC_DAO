package com.example.jdbc_dao.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DaoRepository {
    private static final String NAMED_PARAM = "name";

    @PersistenceContext
    private EntityManager entityManager;

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getProductName(String name) {
        return entityManager.createQuery("select o.product_name from Order o " +
                "join Customer c ON o.customer.id = c.id where c.name like :name")
                .setParameter(NAMED_PARAM, name).getResultList();

    }
}
