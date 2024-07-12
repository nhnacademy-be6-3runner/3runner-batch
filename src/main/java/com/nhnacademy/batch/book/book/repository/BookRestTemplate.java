package com.nhnacademy.batch.book.book.repository;

public interface BookRestTemplate {

	void saveNewIndex(String body, String indexName);

	void sendBulk(String body, String indexName);

	void sendAlias(String body);
}
