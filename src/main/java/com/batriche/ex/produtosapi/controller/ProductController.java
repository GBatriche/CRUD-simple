package com.batriche.ex.produtosapi.controller;


import com.batriche.ex.produtosapi.model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProductController {

    @PostMapping
    public void save(@RequestBody Product product){
        System.out.println("Produto recebido" + product);
    }
}
