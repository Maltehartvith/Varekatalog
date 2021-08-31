package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model){
        List<Product> productList = productService.allProducts();
        model.addAttribute("products", productList);
        return "Home/index";
    }
    @GetMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "Home/viewProduct";
    }
    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "Home/updateProduct";
    }
    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product p){
        productService.updateProduct(p);
        return "redirect:/";
    }
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model){
        productService.deleteProduct(id);
        return "redirect:/";
    }
    @GetMapping("/createProduct")
    public String createProduct(){
        return "Home/createProduct";
    }
    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute Product p){
        productService.createProduct(p);
        return "redirect:/";
    }

}
