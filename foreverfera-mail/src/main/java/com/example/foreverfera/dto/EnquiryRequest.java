package com.example.foreverfera.dto;

import lombok.Data;

@Data
public class EnquiryRequest {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String eventType;
    private String eventDate;
    private String guestCount;
    private String preferredPlan;
    private String message;
}