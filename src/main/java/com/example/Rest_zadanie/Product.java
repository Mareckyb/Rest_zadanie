package com.example.Rest_zadanie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Product {

    Long id;
    String nameProduct;
    String producer;

    public Product (Long id, String nameProduct, String producer){
        this.nameProduct=nameProduct;
        this.producer=producer;
        this.id=id;
    }

}
