package soa.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import soa.model.Books;
import soa.service.BooksService;

@RestController
@RequestMapping("books")
public class BooksController {

	BooksService BS;
	
	public BooksController(BooksService BS)
	{
		this.BS = BS;
	}
	
	@PostMapping("books")
	public Object books(@RequestBody Books B)
	{
		return BS.createBook(B);
	}
	
	@GetMapping("books")
	public Object books()
	{
		return BS.readAllBooks();
	}
	
	@GetMapping("books/{id}")
	public Object books(@PathVariable("id") Long ID)
	{
		return BS.readBookById(ID);
	}
	
	@PutMapping("books/{id}")
	public Object books(@PathVariable("id") Long ID, @RequestBody Books B)
	{
		return BS.updateBook(ID, B);
	}
	
	@DeleteMapping("books/{id}")
	public Object deletebooks(@PathVariable("id") Long ID)
	{
		return BS.deleteBook(ID);
	}
}
