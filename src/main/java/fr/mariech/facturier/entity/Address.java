package fr.mariech.facturier.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data @NoArgsConstructor
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long addressId;
    @Column(name = "street_number")
    private String streetNumber;
    @Column(name = "street")
    private String street;
    @Column(name = "complementary_info")
    private String complementary_info;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "city")
    private String city;
}
