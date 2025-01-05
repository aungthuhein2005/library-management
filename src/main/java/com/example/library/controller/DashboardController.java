package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.library.service.BookService;
import com.example.library.service.BorrowerService;
import com.example.library.service.TransactionService;

@Controller
public class DashboardController {
	  @Autowired
	    private BookService bookService;
	    @Autowired
	    private BorrowerService borrowerService;
	    @Autowired
	    private TransactionService transactionService;

	    @GetMapping("/dashboard")
	    public String getDashboard(Model model) {
	        // Get stats
	        long totalBooks = bookService.getTotalBooks();
	        long borrowedBooks = bookService.getBorrowedBooks();
	        long availableBooks = totalBooks - borrowedBooks;
	        long totalBorrowers = borrowerService.getTotalBorrowers();
//
//	        // Get transaction data (dates and counts)
	        List<String> transactionDates = transactionService.getTransactionDates(); // List of dates
	        List<Long> transactionCounts = transactionService.getTransactionCounts(); // List of counts for each date
//
//	        // Add attributes to the model for Thymeleaf
	        model.addAttribute("totalBooks", totalBooks);
	        model.addAttribute("borrowedBooks", borrowedBooks);
	        model.addAttribute("availableBooks", availableBooks);
	        model.addAttribute("totalBorrowers", totalBorrowers);
	        model.addAttribute("transactionDates", transactionDates);
	        model.addAttribute("transactionCounts", transactionCounts);
	        model.addAttribute("content","fragments/dashboard.html");
	        return "layout";
	    }
}
