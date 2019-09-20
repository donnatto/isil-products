package isilproducts.controller;

import isilproducts.model.Product;
import isilproducts.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String getProductsList(Model model) {
        // List
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping({"/products/add"})
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product-add";
    }

    @GetMapping("/products/edit/{sku}")
    public String editProduct(@PathVariable String sku, Model model) {
        // Find product
        model.addAttribute("product", productService.findById(sku));
        // Edit page redirect
        return "product-edit";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product) {
        // Save
        productService.saveProduct(product);
        // List
        return "redirect:/products";
    }

    @PostMapping("/products/saveedit")
    public String saveEdit(Product product) {
        // Save
        productService.updateProduct(product);
        // List
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{sku}")
    public String deleteProduct(@PathVariable String sku) {
        // Delete
        productService.deleteProduct(sku);
        // Redirect
        return "redirect:/products";
    }
}
