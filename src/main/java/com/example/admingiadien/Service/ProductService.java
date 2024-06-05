package com.example.admingiadien.Service;

import com.example.admingiadien.DTO.ProductsDTO;
import com.example.admingiadien.Entity.Categories;
import com.example.admingiadien.Entity.Products;
import com.example.admingiadien.Mapper.ProductMapper;
import com.example.admingiadien.Repository.CategoriesRepository;
import com.example.admingiadien.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final CategoriesRepository categoriesRepository;
    //hien thi product
    public List<ProductsDTO> ShowAllProducts() {
        List<Products> productsList = productRepository.findAll();
        List<Categories> categories = categoriesRepository.findAll();
        return productMapper.toDto(productsList);
    }

    // Thêm sản phẩm mới
    public ProductsDTO addProduct(ProductsDTO productDTO) {
        productDTO.setCreatedAt(LocalDateTime.now());
        productDTO.setUpdatedAt(LocalDateTime.now());
        Products product = productMapper.toEntity(productDTO);
        productRepository.save(product);
        return productMapper.toDto(product);
    }

}
