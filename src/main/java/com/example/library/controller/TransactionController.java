package com.example.library.controller;

import com.example.library.entity.Transaction;
import com.example.library.service.BookService;
import com.example.library.service.BorrowerService;
import com.example.library.service.TransactionService;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    
    @Autowired
    private BorrowerService borrowerService;
    
    @Autowired
    private BookService bookService;

    // Display list of transactions
    @GetMapping
    public String listTransactions(Model model) {
        model.addAttribute("transactions", transactionService.getAllTransactions());
        model.addAttribute("content","fragments/transaction/transactionList.html");
        return "layout";  // Returns a view with a list of transactions
    }

    // Show form to create a new transaction
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("borrowers", borrowerService.getAllBorrowers());
        model.addAttribute("books", bookService.findAllBook());
        model.addAttribute("content","fragments/transaction/add-transaction.html");
        return "layout";
    }

    // Show form to edit an existing transaction
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Transaction transaction = transactionService.getTransactionById(id);
        model.addAttribute("transaction", transaction);
        model.addAttribute("borrowers", borrowerService.getAllBorrowers());
        model.addAttribute("books", bookService.findAllBook());
        model.addAttribute("content","fragments/transaction/add-transaction.html");
        return "layout";
    }

    // Handle form submission to save a transaction
    @PostMapping
    public String saveTransaction(@ModelAttribute Transaction transaction) {
        transactionService.createTransaction(transaction);
        return "redirect:/transactions";  // Redirect back to transaction list after saving
    }

    // Handle delete a transaction
    @GetMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deletetransaction(id);
        return "redirect:/transactions";  // Redirect back to transaction list after deleting
    }
    
    
}
