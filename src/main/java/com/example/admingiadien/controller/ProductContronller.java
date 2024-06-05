package com.example.admingiadien.controller;

import com.example.admingiadien.DTO.CategoriesDTO;
import com.example.admingiadien.DTO.ProductsDTO;
import com.example.admingiadien.Entity.Categories;
import com.example.admingiadien.Service.CategoriesService;
import com.example.admingiadien.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductContronller {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoriesService categoriesService;

    // hiển thị sản phẩm
    @GetMapping("/products")
    public String getProductsByCategoryId(@RequestParam("categoryId") Long categoryId,@RequestParam("categoryId") int id, Model model) {
        List<ProductsDTO> products = productService.ShowAllProducts();
        CategoriesDTO category = categoriesService.getCategoriesById(id);
        model.addAttribute("categoryName", category.getName());
        model.addAttribute("products", products);
        model.addAttribute("categoryId", categoryId);
        return "Admin/pages/products/products";
    }

    // thêm sản phâm
    @GetMapping("/addproduct")
    public String showAddProductForm(@RequestParam("categoryId") Long categoryId,@RequestParam("categoryId") int id, Model model) {
        ProductsDTO product = new ProductsDTO();
        product.setCategoryId(categoryId);
        CategoriesDTO category = categoriesService.getCategoriesById(id);
        model.addAttribute("categoryName", category.getName());
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("product", product);
        return "Admin/pages/products/addproduct";
    }

    @PostMapping("/addproduct")
    public String addProduct(@RequestParam("categoryId") Long categoryId, @ModelAttribute ProductsDTO product) {
        product.setCategoryId(categoryId); // Ensure categoryId is set in the product
        productService.addProduct(product);
        return "redirect:/products?categoryId=" + categoryId;
    }



}
