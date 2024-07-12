package com.nhnacademy.batch.book.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nhnacademy.batch.book.book.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookTask {
	private final BookService bookService;
	private static boolean allBookPlaying = false;

	@Scheduled(cron = "0 0 2 * * ?")
	public void allBookElasticSearchFromDB() throws Exception {
		allBookPlaying = true;
		bookService.allBookToElasticSearchFromDB();
		allBookPlaying = false;
	}

	@Scheduled(fixedDelay = 10000)
	public void bookElasticSearchChecking() throws Exception {
		log.info("시작");
		if (!allBookPlaying) {
			bookService.elasticBookUpdate();
		}
		log.info("끝");
	}
}
