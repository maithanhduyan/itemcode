package com.itemcode.pos.service;

import java.util.List;

import com.itemcode.pos.entity.Product;

public interface ProductService {
	long count();

	List<Product> findAll(String shopId);

	Product fetchByCode(String code);
}
