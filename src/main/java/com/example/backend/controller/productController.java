package com.example.backend.controller;

import com.example.backend.mapper.productMapper;
import com.example.backend.pojo.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class productController {
    @Autowired
    productMapper productMapper;

    @GetMapping("/product/{id}")// 根据产品ID查询产品信息
    public Object getProductById(@PathVariable int id) {
        // 通过产品ID查询产品信息
        System.out.println("getProductById: " + id);
        product product = productMapper.selectById(id);
        // 产品不存在时返回提示
        if (product == null || product.getId() == 0) {
            return "Product not found";
        }
        return product;
    }

    @GetMapping("/products")// 查询所有产品
    public Object getAllProducts() {
        // 查询所有产品
        System.out.println("getAllProducts");
        return productMapper.selectList(null);
    }

    @PostMapping("/product")// 添加新产品
    public String addProduct(@RequestBody product product) {
        // 添加新产品
        System.out.println("addProduct: " + product);
        int result = productMapper.insert(product);
        if (result > 0) {
            return "Product added successfully";
        } else {
            return "Failed to add product";
        }
    }

    @PutMapping("/product")// 更新产品信息
    public String updateProduct(@RequestBody product product) {
        // 更新产品信息
        System.out.println("updateProduct: " + product);
        int result = productMapper.updateById(product);
        if (result > 0) {
            return "Product updated successfully";
        } else {
            return "Failed to update product";
        }
    }

    @DeleteMapping("/product/{id}")// 删除产品
    public String deleteProduct(@PathVariable int id) {
        // 删除产品
        System.out.println("deleteProduct: " + id);
        int result = productMapper.deleteById(id);
        if (result > 0) {
            return "Product deleted successfully";
        } else {
            return "Failed to delete product";
        }
    }

    // 图片上传接口
    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "File is empty";
        }
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String filePath = "D:\\workplace\\stoneArt\\product_images"; // 你可以自定义路径
        File dest = new File(filePath , fileName);
        try {
            file.transferTo(dest);
            System.out.println("File uploaded successfully: " + dest.getAbsolutePath());
            return fileName; // 返回图片名，前端保存到image字段
        } catch (IOException e) {
            e.printStackTrace();
            return "Upload failed";
        }
    }
}
