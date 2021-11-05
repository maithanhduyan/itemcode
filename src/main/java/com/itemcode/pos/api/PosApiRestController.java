package com.itemcode.pos.api;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.itemcode.pos.domain.user.entity.User;
import com.itemcode.pos.domain.user.service.UserService;
import com.itemcode.pos.entity.Product;
import com.itemcode.pos.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1/pos")
public class PosApiRestController {

	/**
	 * Log
	 */
	private static final Logger LOG = LoggerFactory.getLogger(PosApiRestController.class);

	private String requestKey;
	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	public PosApiRestController() {
		LOG.info("Start POS API.");
	}

	@RequestMapping(value = "/fetchByCode", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, String> fetchByCode(@RequestParam Map<String, String> data, HttpSession session) {
		Map<String, String> response = new HashMap<String, String>();
		String currentRequestKey = "";
		try {
			//
			if (session != null) {
				// currentRequestKey = session.getAttribute("RequestKey").toString();
			} else {
				currentRequestKey = "FirstKey";
			}
			//User newUser = userService.createNewUser("admin", "admin");
			//LOG.info(newUser.getUsername());
			LOG.info("RequestParam" + data.toString());
			String code = data.get("Code");
			LOG.info("Code" + code);
			LOG.info("currentRequestKey: " + currentRequestKey);
			requestKey = UUID.randomUUID().toString();
			LOG.info(requestKey);
			String sessionId = session.getId();
			LOG.info("SessionID:" + sessionId);

			// New RequestKey
			session.setAttribute("New RequestKey", requestKey);
			response.put("key", requestKey);

			LOG.info(requestKey);

			LOG.info("" + productService.fetchByCode(code));
		} catch (Exception ex) {
			LOG.info(ex.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/createNewProduct", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, String> createNewProduct(String productName, String code, int price, String description) {
		LOG.info(productName);
		Product product = null;
		try {
			//product.setName(productName);
			//product.setCode(code);
			//product.setCostPrice(price);
			//product.setActive(1);
			//product.setCreatedDate(new Date());
			//product.setDescription(description);
			//productService.save();
		}catch(Exception ex) {
			LOG.error(ex.getMessage());
		}
		return null;
	}

}
