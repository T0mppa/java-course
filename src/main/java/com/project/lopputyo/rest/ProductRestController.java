package com.project.lopputyo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.lopputyo.data.Product;
import com.project.lopputyo.service.ProductService;

@RestController
public class ProductRestController {
    
    ProductService pc;

    @Autowired
    public ProductRestController(ProductService pc) {
        this.pc = pc;
    }
    
    @GetMapping("/products")
    public List<Product> getProducts() {
        return pc.getProducts();
    }

    @PostMapping("/product")
    public String addProduct(@RequestBody Product product) {
        pc.addProduct(product);
        return "Product added";
    }

    @DeleteMapping("/delproduct")
    public String deleteProduct(@RequestBody Product product) {
        pc.removeProduct(product.getId());
        return "Product removed";
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable int id) {
        Product product = pc.findProduct(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
