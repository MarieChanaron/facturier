package fr.mariech.facturier.controller.dto;

import fr.mariech.facturier.entity.Payment;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InvoiceDto {

    private long invoiceId;
    private LocalDateTime issuingDate;
    private LocalDateTime deadline;
    private Payment payment;

}
