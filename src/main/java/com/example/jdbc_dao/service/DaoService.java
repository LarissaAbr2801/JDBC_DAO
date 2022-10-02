package com.example.jdbc_dao.service;

import com.example.jdbc_dao.repository.DaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaoService {

    private final DaoRepository daoRepository;

    public DaoService(DaoRepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    public List<String> getProductName(String name) {
        return daoRepository.getProductName(name);
    }
}
