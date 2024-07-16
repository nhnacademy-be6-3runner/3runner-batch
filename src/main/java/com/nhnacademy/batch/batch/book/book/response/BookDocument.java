package com.nhnacademy.batch.batch.book.book.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class BookDocument {
	long id;
	String title;
	int price;
	int sellingPrice;
	String author;
	String thumbnail;
	String publisher;
	List<String> tagList;
	List<String> categoryList;

	public BookDocument(long id, String title, int price, int sellingPrice, String author, String thumbnail,
		String publisher) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.sellingPrice = sellingPrice;
		this.author = author;
		this.thumbnail = thumbnail;
		this.publisher = publisher;
		this.tagList = new ArrayList<>();
		this.categoryList = new ArrayList<>();
	}

	public void addTag(String tag) {
		tagList.add(tag);
	}

	public void addCategory(String category) {
		categoryList.add(category);
	}
	// public BookDocument(Book book) {
	// 	this.id = book.getId();
	// 	this.title = book.getTitle();
	// 	this.author = book.getAuthor();
	// 	this.publisher = book.getPublisher();
	// 	this.price = book.getPrice();
	// 	this.sellingPrice = book.getSellingPrice();
	// 	this.tagList = new ArrayList<>();
	// 	this.categoryList = new ArrayList<>();
	// 	if (Objects.nonNull(book.getBookImageList()) && !book.getBookImageList().isEmpty()) {
	// 		for (BookImage bookImage : book.getBookImageList()) {
	// 			if (bookImage.getType().equals(BookImageType.MAIN)) {
	// 				thumbnail = bookImage.getTotalImage().getUrl();
	// 			}
	// 		}
	// 	}
	// 	if (Objects.nonNull(book.getBookTagList()) && !book.getBookTagList().isEmpty()) {
	// 		for (BookTag bookTag : book.getBookTagList()) {
	// 			tagList.add(bookTag.getTag().getName());
	// 		}
	// 	}
	// 	if (Objects.nonNull(book.getBookCategoryList()) && !book.getBookCategoryList().isEmpty()) {
	// 		for (BookCategory bookCategory : book.getBookCategoryList()) {
	// 			categoryList.add(bookCategory.getCategory().getName());
	// 		}
	// 	}
	// }

}
