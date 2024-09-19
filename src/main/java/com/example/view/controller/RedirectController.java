package com.example.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
	@GetMapping("/")
	public String homePage() {
		return "homePage";
	}
	
	@GetMapping("/index")
	public String indexPage() {
	return "index";
	}
	@GetMapping("/error-page")
	public String errorPage() {
	return "error-page";
	}
	
	
	
	
}
