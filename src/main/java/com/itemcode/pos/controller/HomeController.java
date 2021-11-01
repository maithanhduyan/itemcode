package com.itemcode.pos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itemcode.pos.service.ProductService;

@Controller
public class HomeController {
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	ProductService productService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		long start = System.currentTimeMillis();
		long count = productService.count();
		model.addAttribute("message", "Welcome " + count + " ItemCode ");
		LOG.info("Take: " + (System.currentTimeMillis() - start) + " ms");
		return "index";
	}
	
	@RequestMapping("/addNewItem")
	public String addNewItem(Model model) {
		
		return "index";
	}
}
