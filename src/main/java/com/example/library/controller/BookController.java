package com.example.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.library.entity.Book;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;

@Controller
@RequestMapping("books")
public class BookController {
	
private final BookService bookService;
private final AuthorService authorService;	


	public BookController(BookService bookService,AuthorService authorService) {
	super();
	this.bookService = bookService;
	this.authorService = authorService;
}


	@GetMapping("")
    public String showBooks(Model model) {
        // Add a fragment for the book list to the model
		List<Book> books = bookService.findAllBook();
		model.addAttribute("books", books);
		 model.addAttribute("content", "fragments/book/bookList.html");
	        return "layout";
    }

	@GetMapping("/add")
	public String showAddBookForm(Model model) {
		model.addAttribute("book",new Book());
		model.addAttribute("authors",authorService.getAllAuthors());
		model.addAttribute("content","fragments/book/add-book.html");
		return "layout";
	}	
	
	@GetMapping("/edit/{id}")
	public String updateBook(@PathVariable Long id,Model model) {
		Book book = bookService.findById(id);
		model.addAttribute("book",book);
		model.addAttribute("authors",authorService.getAllAuthors());
		model.addAttribute("content","fragments/book/add-book.html");
		return "layout";
	}
	
	@PostMapping
	public String saveBook(@ModelAttribute("book") Book book) {
		bookService.createBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id); // Logic to delete a book
        return "redirect:/books"; // Redirect to the list of books
    }
}

