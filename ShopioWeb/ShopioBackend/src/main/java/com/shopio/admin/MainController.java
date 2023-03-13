package com.shopio.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// spring mvc controller
@Controller
public class MainController {

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
}
