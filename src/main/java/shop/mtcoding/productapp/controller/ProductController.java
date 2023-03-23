package shop.mtcoding.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/product/save")
    public String save(String name, Integer price, Integer qty) {

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQty(qty);

        int result = productRepository.insert(product);
        if (result != 1) {
            System.out.println("상품 등록 실패");
        }

        return "redirect:/product";
    }

    @GetMapping("/product/{id}/update")
    public String productUpdate() {
        return "productUpdate";
    }

    @PostMapping("/product/{id}")
    public String update(String name, Integer price, Integer qty) {
        return "redirect:/productDetail";
    }
}
