package shop.mtcoding.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import shop.mtcoding.productapp.model.Product;
import shop.mtcoding.productapp.model.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public String productList(Model model) {

        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);

        return "productList";
    }

    @GetMapping("/product/{id}")
    public String productDetail(@PathVariable Integer id, Model model) {

        Product product = productRepository.findById(id);
        model.addAttribute("product", product);

        return "productDetail";
    }

    @GetMapping("/productSave")
    public String productSave() {
        return "productSave";
    }

    @GetMapping("/product/{id}/update")
    public String productUpdate() {
        return "productUpdate";
    }
}
