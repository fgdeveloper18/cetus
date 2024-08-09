package com.fmgarcia.cetus.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import lombok.extern.slf4j.Slf4j;

@WebMvcTest(controllers = HelloController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
@Slf4j
public class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		log.info("Init setUp ...");
	}

//	@BeforeAll
//	public void init() {
//		log.info("BeforeAll init method called");
//	}

	@Test
	void shouldGetHello() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().string("Hello Spring Cetus")).andReturn();

		assertEquals(HttpStatus.OK, mvcResult.getResponse().getStatus());
		// assertSame(mockResponse,mvcResult.getResponse());
	}
}
