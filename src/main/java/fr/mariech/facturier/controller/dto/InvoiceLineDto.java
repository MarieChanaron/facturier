package fr.mariech.facturier.controller.dto;

import fr.mariech.facturier.entity.Product;
import lombok.Data;

@Data
public class InvoiceLineDto {

    private InvoiceDto invoiceDto;
    private Product product;
    private byte quantity;
}
