package fr.mariech.facturier.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoice_line_item")
@Data @NoArgsConstructor
@IdClass(InvoiceLineItemId.class)
public class InvoiceLineItem {

    @Id
    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @Id
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private byte quantity;

    // Prix : calculé - Valeur dans product
}
