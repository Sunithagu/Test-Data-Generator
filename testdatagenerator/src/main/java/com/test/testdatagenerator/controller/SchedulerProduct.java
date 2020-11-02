package com.test.testdatagenerator.controller;


import com.test.testdatagenerator.model.Product;
import com.test.testdatagenerator.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class SchedulerProduct {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SchedulerProduct.class);

    @Autowired
    RestTemplate restTemplate;



    @Autowired
    private ProductService productService;

    @Scheduled(fixedRateString = "${generate.data}")
    public void generateData() {

        Random random = new Random();
        List<String> companyName = Arrays.asList("ORACLE" , "SAP","AUTONINJA");
        List<String> productName = Arrays.asList("ERP" , "CRM" , "MONITORING" , "BANKING");
        List<String> distributorName = Arrays.asList("CHANDAN" , "PRAJWAL" , "AASHIKA" , "AKSHITHA");
        List<String> locationName = Arrays.asList("BANGLORE" , "CHANNAI" , "DELHI" , "SAN FRANCISCO");

        Product product = new Product(companyName.get(random.nextInt(companyName.size())),
                productName.get(random.nextInt(productName.size())),
                distributorName.get(random.nextInt(distributorName.size())),
                locationName.get(random.nextInt(locationName.size())));
        LOGGER.info(productService.createProduct(product).toString());

    }


}
