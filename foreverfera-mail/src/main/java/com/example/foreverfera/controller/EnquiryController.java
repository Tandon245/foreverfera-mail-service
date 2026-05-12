package com.example.foreverfera.controller;

import com.example.foreverfera.dto.EnquiryRequest;
import com.example.foreverfera.service.EmailService;
import com.resend.core.exception.ResendException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enquiry")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EnquiryController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<String> submitEnquiry(
            @RequestBody EnquiryRequest request
    ) throws ResendException {

        emailService.sendEnquiryEmail(
                request.getFirstName(),
                request.getLastName(),
                request.getPhone(),
                request.getEmail(),
                request.getEventType(),
                request.getEventDate(),
                request.getGuestCount(),
                request.getPreferredPlan(),
                request.getMessage()
        );

        return ResponseEntity.ok("Enquiry submitted successfully");
    }
}