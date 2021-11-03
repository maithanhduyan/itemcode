package com.itemcode.pos.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itemcode.pos.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
	
	@Cacheable(cacheNames = "products")
	@Query("SELECT p FROM Product p WHERE p.active =1")
	public List<Product> findAll(@Param("shopId") String shopId);
	
	@Query("SELECT p FROM Product p WHERE p.code =:code")
	Product fetchByCode(@Param("code")  String code);

}
