package com.itemcode.pos.api;

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

import com.itemcode.pos.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1/pos")
public class PosApiRestController {
	private static final Logger LOG = LoggerFactory.getLogger(PosApiRestController.class);

	private String requestKey;
	@Autowired
	ProductService productService;

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
}
