package fr.mariech.facturier.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDto {

    private long paymentId;
    private String paymentMethod;
    private LocalDateTime paymentDate;

}
