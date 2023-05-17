package fr.mariech.facturier.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "payment")
@Data @NoArgsConstructor
public class Payment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private long paymentId;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;
    @OneToMany(mappedBy = "payment")
    private List<Invoice> invoices;
}
