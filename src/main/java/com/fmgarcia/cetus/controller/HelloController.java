package com.fmgarcia.cetus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fmgarcia.cetus.core.domain.Test;
import com.fmgarcia.cetus.core.service.TestService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {

	@Autowired
	private TestService testService;

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

	@GetMapping("/test")
	public ResponseEntity<List<Test>> findAll() {

		return new ResponseEntity<List<Test>>(testService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/test")
	public ResponseEntity<?> addTest(@RequestBody Test test) {
		Test newTest = testService.create(test);

		// Set the headers for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newTest.getId()).toUri());

		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}
}
