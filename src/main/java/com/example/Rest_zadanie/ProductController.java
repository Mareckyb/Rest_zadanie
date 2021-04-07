package com.example.Rest_zadanie;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("SklepMiesny")

public class ProductController {

    final ProductRepository productRepository;

    public ProductController (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    List<Product> index() {
        return productRepository.find();
    }

    @GetMapping("{id}")
    Product show(@PathVariable Long id, HttpServletResponse response) {
        Product product = productRepository.find(id);
        if (product != null) {
            return product;
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @PutMapping("{id}")
    Product update(@RequestBody Product product, @PathVariable Long id, HttpServletResponse response) {
        Product updatedProduct = productRepository.update(product, id);

        if (updatedProduct != null) {
            return updatedProduct;
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @DeleteMapping("{id}")
    String delete(@PathVariable Long id, HttpServletResponse response) {
        productRepository.delete(id);
        response.setStatus(HttpStatus.NO_CONTENT.value());
        return "Usunięte z mięsnego";
    }

    @PostMapping
    Product save(@RequestBody Product product, HttpServletResponse response) {
        Product savedProduct = productRepository.save(product);
        if (savedProduct != null) {
            response.setStatus(HttpStatus.CREATED.value());
            return savedProduct;
        } else {
            response.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
            return null;
        }
    }




}
