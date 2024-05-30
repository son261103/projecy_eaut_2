package com.example.admingiadien.controller;

import com.example.admingiadien.DTO.ProductsDTO;
import com.example.admingiadien.Entity.Products;
import com.example.admingiadien.Service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductContronller {
    @Autowired
    private ProductService productService;

    // hiển thị sản phẩm
    @GetMapping("/products")
    public String showProductsByCategory(@RequestParam("categoryId") int categoryId, Model model) {
        // Lấy danh sách sản phẩm dựa trên categoryId
        List<ProductsDTO> products = productService.getProductsByCategoryId(categoryId);

        // Chuyển danh sách sản phẩm vào model để hiển thị trên view
        model.addAttribute("products", products);

        // Trả về tên của trang hiển thị danh sách sản phẩm
        return "Admin/pages/products/products";
    }


}
