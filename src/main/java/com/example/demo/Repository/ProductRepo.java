package com.example.demo.Repository;

import com.example.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> allProducts(){
        String sql="SELECT * FROM products";
        RowMapper<Product> rowMapper=new BeanPropertyRowMapper<>(Product.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
    public Product findById(int id){
        String sql="SELECT * FROM products WHERE id = ?";
        RowMapper<Product> rowMapper=new BeanPropertyRowMapper<>(Product.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,id);

    }
    public Product createProduct(Product p){
        String customerSql="INSERT INTO products (productName,price) VALUES (?,?)";
        jdbcTemplate.update(customerSql,p.getProductName(),p.getPrice());
        return null;
    }
    public Product updateProduct(Product p){
        String sql="UPDATE products SET productName = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql,p.getProductName(), p.getPrice() ,p.getId());
        return null;
    }
    public boolean deleteProduct(int id){
        String sql="DELETE FROM products WHERE id = ?";
        return jdbcTemplate.update(sql,id) > 0;
    }
}
