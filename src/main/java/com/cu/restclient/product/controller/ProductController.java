package com.cu.restclient.product.controller;

import com.cu.restclient.ApiConfig;
import com.cu.restclient.product.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ApiConfig apiConfig;

    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Integer productId){
        String productApiUrl = "/products/" + productId;
        Product product = apiConfig.dummyRestClient().get().uri(productApiUrl).retrieve().body(Product.class);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProducts() {
        Map<String, Object> response = new HashMap<>();
        response.put("products",  new ArrayList<Product>());
        response.put("total", 0);
        response.put("skip", 0);
        response.put("limit", 0);

        ParameterizedTypeReference<Map<String, Object>> responseType = new ParameterizedTypeReference<Map<String, Object>>() {};
        Map<String, Object> data = apiConfig.dummyRestClient().get().uri("/products").retrieve().body(responseType);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}
