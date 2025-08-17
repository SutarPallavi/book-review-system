package com.springboot.bookreviewsystem.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteController {

	@GetMapping("/get/bookreviewsystem/index.html")
	public String getIndex() {
		return "forward:/index.html";
	}

	@GetMapping("/register")
	public String getRegister() {
		return "forward:/register.html";
	}
}
