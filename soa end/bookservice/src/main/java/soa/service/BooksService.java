package soa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import soa.model.Books;
import soa.repository.BooksRepository;

@Service
public class BooksService {
BooksRepository BR;
public BooksService(BooksRepository BR) {
	this.BR = BR;
	
}
public Object createBook(Books B) {
	Map<String, Object> response = new HashMap<>();
	try {
		BR.save(B);
		response.put("status", "success");
		response.put("message", "New book has been added.");
		
	} 
	catch(Exception e) {
		response.put("status", "error");
		response.put("message", e.getMessage());
		
	}
	 return response;
}
public Object readAllBooks() {
	Map<String, Object> response = new HashMap<>();
	try {
		List<Books> books = BR.findAll();
		response.put("status", "success");
		response.put("books", books);
		
	} 
	catch(Exception e) {
		response.put("status", "error");
		response.put("message", e.getMessage());
		
	}
	 return response;
}
public Object readBookById(Long id) {
	Map<String, Object> response = new HashMap<>();
	try {
		Books book = BR.findById(id).get();
		response.put("status", "success");
		response.put("book", book);
		
	} 
	catch(Exception e) {
		response.put("status", "error");
		response.put("message", e.getMessage());
		
	}
	 return response;
}
public Object updateBook(Long id, Books B) {
	Map<String, Object> response = new HashMap<>();
	try {
		Books book = BR.findById(id).get();
		book.setTitle(B.getTitle());
		book.setAuthor(B.getAuthor());
		book.setIsbn(B.getIsbn());
		BR.save(book);
		response.put("status", "success");
		response.put("message", "evadra nuvv");
		
	} 
	catch(Exception e) {
		response.put("status", "error");
		response.put("message", e.getMessage());
		
	}
	 return response;
}
public Object deleteBook(Long id) {
	Map<String, Object> response = new HashMap<>();
	try {
		BR.deleteById(id);
		response.put("status", "success");
		response.put("message", "fahhhhhhhhh");
		
	} 
	catch(Exception e) {
		response.put("status", "error");
		response.put("message", e.getMessage());
		
	}
	 return response;
}
}
