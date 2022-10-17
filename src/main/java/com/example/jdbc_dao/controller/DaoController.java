package com.example.jdbc_dao.controller;

import com.example.jdbc_dao.service.DaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class DaoController {

    private final DaoService daoService;

    public DaoController(DaoService daoService) {
        this.daoService = daoService;
    }

    @GetMapping("products/fetch-product")
    public List<String> getProductName(@RequestParam String name) {
        return daoService.getProductName(name);
    }
}
