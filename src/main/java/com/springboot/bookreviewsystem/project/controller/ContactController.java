package com.springboot.bookreviewsystem.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookreviewsystem.project.dto.ContactFormDto;
import com.springboot.bookreviewsystem.project.entity.CustomerMail;
import com.springboot.bookreviewsystem.project.service.CustomerMailService;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private CustomerMailService customerMailService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitContactForm(@RequestBody ContactFormDto contactForm) {
        try {
            // Basic validation
            if (contactForm.getName() == null || contactForm.getName().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Name is required");
            }
            if (contactForm.getEmail() == null || contactForm.getEmail().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Email is required");
            }
            if (contactForm.getSubject() == null || contactForm.getSubject().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Subject is required");
            }
            if (contactForm.getMessage() == null || contactForm.getMessage().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Message is required");
            }

            // Save to MongoDB
            CustomerMail savedMail = customerMailService.saveContactForm(contactForm);
            
            return ResponseEntity.ok("Contact form submitted successfully. Reference ID: " + savedMail.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Failed to submit form: " + e.getMessage());
        }
    }

    @GetMapping("/mails")
    public ResponseEntity<List<CustomerMail>> getAllCustomerMails() {
        try {
            List<CustomerMail> mails = customerMailService.getAllCustomerMails();
            return ResponseEntity.ok(mails);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/mails/{id}")
    public ResponseEntity<CustomerMail> getCustomerMailById(@PathVariable String id) {
        try {
            CustomerMail mail = customerMailService.getCustomerMailById(id);
            if (mail != null) {
                return ResponseEntity.ok(mail);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PutMapping("/mails/{id}/status")
    public ResponseEntity<String> updateMailStatus(@PathVariable String id, @RequestParam String status) {
        try {
            CustomerMail updatedMail = customerMailService.updateStatus(id, status);
            if (updatedMail != null) {
                return ResponseEntity.ok("Status updated successfully to: " + status);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Failed to update status: " + e.getMessage());
        }
    }
}
