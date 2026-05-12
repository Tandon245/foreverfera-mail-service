package com.example.foreverfera.service;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Value("${RESEND_API_KEY}")
    private String apiKey;

    public void sendEnquiryEmail(
            String firstName,
            String lastName,
            String phone,
            String email,
            String eventType,
            String eventDate,
            String guestCount,
            String preferredPlan,
            String message
    ) throws ResendException {

        Resend resend = new Resend(apiKey);

        String html = """
                <h2>New ForeverFera Enquiry</h2>

                <p><strong>Name:</strong> %s %s</p>
                <p><strong>Email:</strong> %s</p>
                <p><strong>Phone:</strong> %s</p>
                <p><strong>Event Type:</strong> %s</p>
                <p><strong>Event Date:</strong> %s</p>
                <p><strong>Guest Count:</strong> %s</p>
                <p><strong>Preferred Plan:</strong> %s</p>
                <p><strong>Message:</strong> %s</p>
                """
                .formatted(
                        firstName,
                        lastName,
                        email,
                        phone,
                        eventType,
                        eventDate,
                        guestCount,
                        preferredPlan,
                        message
                );

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("info@foreverfera.com")
                .to("info@foreverfera.com")
                .subject("New ForeverFera Enquiry")
                .html(html)
                .build();

        resend.emails().send(params);
    }
}