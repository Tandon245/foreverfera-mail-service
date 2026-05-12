package com.example.foreverfera.controller;

import com.example.foreverfera.dto.EnquiryRequest;
import com.example.foreverfera.service.EmailService;
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
    public ResponseEntity<?> submitEnquiry(
            @RequestBody EnquiryRequest request
    ) {

        try {

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

            return ResponseEntity.ok(
                    "Enquiry submitted successfully"
            );

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.internalServerError()
                    .body(e.getMessage());
        }
    }
}