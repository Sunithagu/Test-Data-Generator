package com.test.testdatagenerator.controller;

import com.test.testdatagenerator.model.Product;
import com.test.testdatagenerator.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Product createmandServiceProviderConfiguration(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // get all Cloud Provider Configuration
    @GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getmandServiceProviderConfiguration() {
        return productService.getAllProducts();
    }

    //get Cloud Provider Configuration by id
    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getmandServiceProviderConfigurationById(@PathVariable("id") String id) {
        return productService.getProductById(id);
    }

    // update Cloud Provider Configuration by id
    @PutMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product updateCloudProviderConfiguration(@PathVariable("id") String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // delete existing Cloud Provider Configuration
    @DeleteMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletemandService(@PathVariable("id") String id) {
        productService.deleteProductById(id);
    }
}
