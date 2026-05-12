package com.example.foreverfera.service;

import com.example.foreverfera.dto.EnquiryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    public void sendMail(EnquiryRequest request) {

        String body = """
                NEW WEBSITE ENQUIRY

                ==================================

                Name:
                %s %s

                Phone:
                %s

                Email:
                %s

                Event Type:
                %s

                Event Date:
                %s

                Guest Count:
                %s

                Preferred Plan:
                %s

                Message:
                %s

                ==================================
                """
                .formatted(
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

        SimpleMailMessage mail =
                new SimpleMailMessage();
        mail.setFrom("info@foreverfera.com");

        mail.setTo("info@foreverfera.com");

        mail.setReplyTo(request.getEmail());

        mail.setSubject(
                "New Wedding Enquiry - "
                        + request.getEventType()
        );

        mail.setText(body);

        mailSender.send(mail);
    }
}