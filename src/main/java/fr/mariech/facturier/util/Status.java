package fr.mariech.facturier.util;

import fr.mariech.facturier.controller.dto.InvoiceDto;

import java.time.LocalDateTime;

public class Status {

    public static String getStatus(InvoiceDto invoiceDto) {
        String status = "";
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime deadline = invoiceDto.getDeadline();

        if (invoiceDto.getPaymentDto() == null) {
            if (now.isAfter(deadline)) status = "En retard";
        } else {
            status = "Payé";
        }

        return status;
    }
}
