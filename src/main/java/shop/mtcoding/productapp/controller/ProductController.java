package shop.mtcoding.productapp.controller;

import java.io.StringReader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/productList")
    public String productList() {
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
