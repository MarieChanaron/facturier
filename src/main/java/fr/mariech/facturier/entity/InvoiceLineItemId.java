package fr.mariech.facturier.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor @AllArgsConstructor
public class InvoiceLineItemId implements Serializable {

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "product_id")
    private Product product;
    @OneToOne
    @JoinColumn(name = "invoice_id", nullable = false, referencedColumnName = "invoice_id")
    private Invoice invoice;
}
