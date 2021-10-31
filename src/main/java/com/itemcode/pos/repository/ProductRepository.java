package com.itemcode.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itemcode.pos.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
