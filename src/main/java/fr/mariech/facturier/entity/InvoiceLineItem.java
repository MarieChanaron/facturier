package fr.mariech.facturier.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "invoice_line_item")
@Data @NoArgsConstructor
public class InvoiceLineItem {

    @EmbeddedId
    private InvoiceLineItemId invoiceLineItemId;
    @Column(name = "quantity")
    private byte quantity;

    // Prix : calculé - Valeur dans product
}
