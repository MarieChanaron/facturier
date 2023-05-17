package fr.mariech.facturier.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "invoice")
@Data @NoArgsConstructor
public class Invoice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private long invoiceId;
    @Column(name = "issuing_date")
    private LocalDateTime issuingDate;
    @Column(name = "deadline")
    private LocalDateTime deadline;
    @ManyToOne
    @JoinColumn(name = "client_id_fk")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "payment_id_fk")
    private Payment payment;
}
