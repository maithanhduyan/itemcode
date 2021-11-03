package com.itemcode.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.itemcode.pos.entity.Product;
import com.itemcode.pos.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public long count() {
		return productRepository.count();
	}

	@Override
	public List<Product> findAll(String shopId) {
		return productRepository.findAll();
	}

	@Override
	public Product fetchByCode(String code) {
		return productRepository.fetchByCode(code);
	}

}
