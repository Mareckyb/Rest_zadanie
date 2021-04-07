package com.example.Rest_zadanie;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Repository

public class ProductRepository {

    static Long currentId = 5L;

    static final List<Product> products = new LinkedList<>(Arrays.asList(
            new Product (1L, "szynka", "duda"),
            new Product(2L, "schab", "morliny"),
            new Product(3L, "pasztet babuni", "konspol"),
            new Product(4L, "smalec ze skwarkami", "żukowo")
    ));

    public List<Product> find() {
        return products;
    }

    public Product find(Long id) {

        return products.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    public Product save(Product product) {

        product.setId(currentId++);
        products.add(product);
        return product;
    }

    public Product update(Product product, Long id){
        Product productToUpdate = find(id);

        if (productToUpdate== null) {
            return null;
        }
        productToUpdate.setNameProduct(product.getNameProduct());
        productToUpdate.setProducer(product.getProducer());
        return productToUpdate;
    }

    public void delete(Long id){
        Product product = find(id);
        products.remove(product);
    }

}
