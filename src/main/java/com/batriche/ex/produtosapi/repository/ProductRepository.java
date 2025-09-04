package com.batriche.ex.produtosapi.repository;

import com.batriche.ex.produtosapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, String> {
}
