package com.fet.estore.api;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestApiController {

	
	
	@RequestMapping("/alex")
	public String helloThymeleaf(Model model){
		model.addAttribute("hello","hello Thymeleaf！");
		
		System.out.println("sssss");
		return "index";
	}
	
	@RequestMapping("/alex2")
	public String helloThymeleaf2(Model model){
		model.addAttribute("hello","hello Thymeleaf！");
		
		System.out.println("aaa");
		return "thymeleaf_base_layout/base";
	}
	
	
	 
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("AAAAAAAAA");
		return "index";
	}
	
	
	
	
	

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	@ResponseBody
	public String createProduct() {
//		{"rtnCode":"00000","rtnMsg":"SUCCESS","restData":{"rtnCode":"00000","rtnMsg":"SUCCESS"}}
		
		JSONObject json2 = new JSONObject();
		json2.put("rtnCode", "00000");
		json2.put("rtnMsg", "SUCCESS");
		
		
		JSONObject json = new JSONObject();
		json.put("rtnCode", "00000");
		json.put("rtnMsg", "SUCCESS");
		json.put("restData", json2);
		
		return json.toString();
	}
}
