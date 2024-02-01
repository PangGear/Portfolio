package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StartController {

	StartController(){
		System.out.println("StartController CHECK");
	}
	
	@GetMapping("/index.do")
	String index()	{
		
		return "index";
	}
}
