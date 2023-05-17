package fr.mariech.facturier.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @NoArgsConstructor
public class InvoiceLineItemId implements Serializable {

    private Product product;
    private Invoice invoice;
}
