package fr.mariech.facturier.controller.dto;

import fr.mariech.facturier.entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class ClientDto {

    private long clientId;
    private String companyName;
    private String phone;
    private Address address;
    private List<InvoiceDto> invoices;
}
