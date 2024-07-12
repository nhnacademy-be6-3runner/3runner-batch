package com.nhnacademy.batch;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class LogTest {

	@Test
	public void test() {
		log.info("Log info");
		log.debug("Log debug");
		log.warn("Log warn");
		log.error("Log error");
		log.trace("Log trace");
	}
}
