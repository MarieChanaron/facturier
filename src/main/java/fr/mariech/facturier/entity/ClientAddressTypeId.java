package fr.mariech.facturier.entity;

import com.fasterxml.jackson.annotation.JacksonInject;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor @AllArgsConstructor
public class ClientAddressTypeId implements Serializable {

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false, referencedColumnName = "client_id")
    private Client client;
    @OneToOne
    @JoinColumn(name = "address_id", nullable = false, referencedColumnName = "address_id")
    private Address address;
}
