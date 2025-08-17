package com.springboot.bookreviewsystem.project.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bookreviewsystem.project.dto.ContactFormDto;
import com.springboot.bookreviewsystem.project.entity.CustomerMail;
import com.springboot.bookreviewsystem.project.repo.CustomerMailRepository;

@Service
public class CustomerMailService {

    @Autowired
    private CustomerMailRepository customerMailRepository;

    public CustomerMail saveContactForm(ContactFormDto contactForm) {
        CustomerMail customerMail = CustomerMail.builder()
                .name(contactForm.getName())
                .email(contactForm.getEmail())
                .subject(contactForm.getSubject())
                .message(contactForm.getMessage())
                .submittedAt(LocalDateTime.now())
                .status("new")
                .build();
        
        return customerMailRepository.save(customerMail);
    }

    public List<CustomerMail> getAllCustomerMails() {
        return customerMailRepository.findAll();
    }

    public CustomerMail getCustomerMailById(String id) {
        return customerMailRepository.findById(id).orElse(null);
    }

    public CustomerMail updateStatus(String id, String status) {
        CustomerMail customerMail = customerMailRepository.findById(id).orElse(null);
        if (customerMail != null) {
            customerMail.setStatus(status);
            return customerMailRepository.save(customerMail);
        }
        return null;
    }
}
