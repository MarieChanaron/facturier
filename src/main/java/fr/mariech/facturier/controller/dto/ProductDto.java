package fr.mariech.facturier.controller.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ProductDto {

    private long productId;
    private String name;
    private String description;
    private String priceBeforeVat;
}
