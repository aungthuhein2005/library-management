package com.example.library.controller;

import com.example.library.entity.Borrower;
import com.example.library.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/borrowers")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    // Display the list of borrowers
    @GetMapping
    public String listBorrowers(Model model) {
        model.addAttribute("borrowers", borrowerService.getAllBorrowers());
        model.addAttribute("content","fragments/borrower/borrowerList.html");
        return "layout"; // View to display the list of borrowers
    }

    // Show the form to add a new borrower
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("borrower", new Borrower());
        model.addAttribute("content","fragments/borrower/add-borrower.html");
        return "layout";
    }

    // Handle the form submission for adding or updating a borrower
    @PostMapping
    public String saveBorrower(@ModelAttribute Borrower borrower) {
        borrowerService.createBorrower(borrower);
        return "redirect:/borrowers"; // Redirect to the list of borrowers
    }

    // Show the form to edit an existing borrower
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Borrower borrower = borrowerService.getBorrowerById(id);
        model.addAttribute("borrower", borrower);
        model.addAttribute("content","fragments/borrower/add-borrower.html");
        return "layout";
    }

    // Handle the deletion of a borrower
    @GetMapping("/delete/{id}")
    public String deleteBorrower(@PathVariable("id") Long id) {
        borrowerService.deleteBorrower(id);
        return "redirect:/borrowers"; // Redirect to the list of borrowers
    }
}
