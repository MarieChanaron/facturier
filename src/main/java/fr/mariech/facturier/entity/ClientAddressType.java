package fr.mariech.facturier.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client_address_type")
@Data @NoArgsConstructor
public class ClientAddressType {

    @EmbeddedId
    private ClientAddressTypeId clientAddressTypeId;
    @Column(name = "address_type")
    private String addressType;

}
