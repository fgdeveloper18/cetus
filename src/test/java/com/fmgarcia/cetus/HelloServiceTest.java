package com.fmgarcia.cetus;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import lombok.extern.slf4j.Slf4j;

@DisplayName("<= HelloService Specifition =>")
@Slf4j
public class HelloServiceTest {

	private HelloServiceTest(TestInfo testInfo) {
		log.info("Working on test " + testInfo.getDisplayName());
	}

	private List<String> books;

	@BeforeAll
	static void init() {
		log.info("init method");
	}

	@AfterAll
	static void end() {
		log.info("end method...");
	}

	@BeforeEach
	void forEachMethod() {
		log.info("forEach method...");
		books = new ArrayList<String>();
		Collections.unmodifiableList(books);
	}

	@AfterEach
	void forAfterMethod() {
		log.info("forAfterMethod method...");
	}

	@Test
	// @DisplayName("is empty when no book is added to it")
	void ShouldEvaluateTrue() {
		assertTrue(books.isEmpty(), () -> "HelloService should be empty");
	}

	@Test
	void shelfToStringShouldPrintBookCountAndTitles() throws Exception {

		books.add("Uno");
		books.add("Dos");

		String book = books.toString();

		assertAll(() -> assertTrue(book.contains("Uno"), "1st item missing"),
				() -> assertTrue(book.contains("Dos"), "2nd book missing"));
	}

	@Test
	public void bookshelfContainsTwoBooksWhenTwoBooksAdded() {

		books.add("Uno");
		books.add("Dos");

		assertEquals(2, books.size(), () -> "Books should have two books");
	}

	@Disabled("Needs to implement Comparator")
	void shouldFail() throws Exception {
		try {
			fail(() -> "Should be fail");
		} catch (Exception e) {
			assertTrue(e instanceof UnsupportedOperationException, () -> "Should throw UnsupportedOperationException");
		}
	}

	@RepeatedTest(2)
	void i_am_a_repeated_test() {
		assertTrue(true);
	}

}
