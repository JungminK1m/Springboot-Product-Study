package shop.mtcoding.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.productapp.model.Product;
import shop.mtcoding.productapp.model.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/productList")
    public String productList(Model model) {

        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);

        return "productList";
    }

    @GetMapping("/productDetail")
    public String productDetail() {
        return "productDetail";
    }

    @GetMapping("/productSave")
    public String productSave() {
        return "productSave";
    }

    @GetMapping("/productUpdate")
    public String productUpdate() {
        return "productUpdate";
    }
}
