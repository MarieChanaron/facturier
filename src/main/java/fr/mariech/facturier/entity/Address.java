package fr.mariech.facturier.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private String complementaryInfo;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "city")
    private String city;
    /*@OneToMany(mappedBy = "address")
    private List<Client> clients;*/
}
