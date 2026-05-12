package com.example.foreverfera.controller;

import com.example.foreverfera.dto.EnquiryRequest;
import com.example.foreverfera.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MailController {

    private final MailService mailService;

    @PostMapping("/send")
    public ResponseEntity<?> sendMail(
            @RequestBody EnquiryRequest request
    ) {

        try {

            mailService.sendMail(request);

            return ResponseEntity.ok(
                    "Mail sent successfully"
            );

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.internalServerError()
                    .body(e.getMessage());
        }
    }
}