package fr.mariech.facturier.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "client")
@Data @NoArgsConstructor
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private long clientId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "phone")
    private String phone;
    @OneToMany(mappedBy = "client")
    private List<Invoice> invoices;
}
