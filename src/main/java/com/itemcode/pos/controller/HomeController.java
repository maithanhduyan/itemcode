package com.itemcode.pos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		long start = System.currentTimeMillis();
		model.addAttribute("message", "Welcome ItemCode");

		LOG.info("Take: " + (System.currentTimeMillis() - start) + " ms");
		return "index";
	}
}
