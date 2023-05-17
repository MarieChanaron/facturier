package fr.mariech.facturier.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InvoiceDto {

    private long invoiceId;
    private LocalDateTime issuingDate;
    private LocalDateTime deadline;
    private PaymentDto paymentDto;
    private double total;
    private String status;

}
