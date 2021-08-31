package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;


    public List<Product> allProducts(){
        return productRepo.allProducts();
    }
    public Product findById(int id){

        return productRepo.findById(id);
    }
    public Product createProduct(Product p){
        productRepo.createProduct(p);
        return null;
    }
    public Product updateProduct(Product p){
        productRepo.updateProduct(p);
        return null;
    }
    public boolean deleteProduct(int id){
        return productRepo.deleteProduct(id);
    }

}
