package com.example.jdbc_dao.service;

import com.example.jdbc_dao.repository.DaoRepository;
import org.springframework.stereotype.Service;

@Service
public class DaoService {

    private final DaoRepository daoRepository;

    public DaoService(DaoRepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    public String getProductName(String name) {
        return daoRepository.getProductName(name);
    }
}
