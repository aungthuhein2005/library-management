package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/setting")
public class SettingController {

	@GetMapping
	public String setting(Model model) {
		model.addAttribute("content","fragments/setting.html");
		return "layout";
	}
	
}