package com.example.jdbc_dao.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DaoRepository {

    private static final String SCRIPT_FILE_NAME = "script.sql";
    private static final String NAMED_PARAM = "name";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DaoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {
        return namedParameterJdbcTemplate.query(read(SCRIPT_FILE_NAME),
                Map.of(NAMED_PARAM, name), new SingleColumnRowMapper<>(String.class)).toString();
    }
}
