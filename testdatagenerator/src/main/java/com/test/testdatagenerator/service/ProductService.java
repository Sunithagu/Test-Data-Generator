package com.test.testdatagenerator.service;

import com.test.testdatagenerator.model.Product;
import com.test.testdatagenerator.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String configurationId) {
        return productRepository.findById(configurationId).orElse(null);
    }

    public Product createProduct(Product mandServiceProviderConfig) {
        return productRepository.save(mandServiceProviderConfig);
    }

    public Product updateProduct(String configurationId, Product Product) {
//        MandServiceProviderConfig mandServiceProviderConfig = mandServiceProviderConfigRepo.findById(configurationId).orElse(null);
//        mandServiceProviderConfig.setMandProperties(configuration.getMandProperties());
        return productRepository.save(Product);
    }

    public void deleteProductById(String configurationId) {
        productRepository.deleteById(configurationId);
    }

    public void deleteAllProduct() {
        productRepository.deleteAll();
    }
}
