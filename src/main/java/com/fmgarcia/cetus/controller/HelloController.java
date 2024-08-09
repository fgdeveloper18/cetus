package com.fmgarcia.cetus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {

	@GetMapping("/hello")
	public ResponseEntity<String> getHello() {
		log.info("get Hello method");
		return ResponseEntity.ok().body("Hello Spring Cetus");
	}

	@GetMapping("/hola")
	public String hola(Model modelo) {

		modelo.addAttribute("mensaje", "hola desde thymeleaf");
		return "hola";
	}
}
