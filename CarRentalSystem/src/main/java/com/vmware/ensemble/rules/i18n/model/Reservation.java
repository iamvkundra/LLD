package com.vmware.ensemble.rules.i18n.model;

import java.time.LocalDateTime;

public class Reservation {
    private String reservationId;
    private String userId;
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private PaymentDetails payment;
}
