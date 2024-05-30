package com.example.admingiadien.Service;

import com.example.admingiadien.DTO.ProductsDTO;
import com.example.admingiadien.Entity.Products;
import com.example.admingiadien.Mapper.ProductMapper;
import com.example.admingiadien.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;



    // lấy id của product
    @Transactional
    public ProductsDTO getProductById(int id){
        Products products = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Khoong tìm thấy sản phẩm có id là: " + id));
        return productMapper.toDto(products);
    }

    // hieenr thị sản phẩm
    @Transactional
    public List<ProductsDTO> getProductsByCategoryId(int categoryId){
        List<Products> productsList = productRepository.findByCategoryId(categoryId);
        return productsList.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }


}
