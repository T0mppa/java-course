package com.project.lopputyo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.lopputyo.data.Product;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public ProductService(){
        products.add(new Product(0, "iPhone", 999.99));
        products.add(new Product(1, "iPad", 799.99));
        products.add(new Product(2, "MacBook", 1999.99));
        products.add(new Product(3, "AppleWatch", 399.99));  
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public Product findProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public boolean removeProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }
}
