package com.sb.gltkn.api;

import com.sb.gltkn.dto.ProductDtoV1;
import com.sb.gltkn.dto.ProductDtoV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductApi {

    // ############### URI Versioning ###############
    // http://localhost:8080/api/v1/product
    @GetMapping(value = "/v1/product")
    public ResponseEntity<ProductDtoV1> pathVersioningV1(){
        return ResponseEntity.of(Optional.of(new ProductDtoV1("ASUS Laptop")));
    }

    // http://localhost:8080/api/v2/product
    @GetMapping(value = "/v2/product")
    public ResponseEntity<ProductDtoV2> pathVersioningV2(){
        return ResponseEntity.of(Optional.of(new ProductDtoV2("ASUS Laptop", new BigDecimal(7500))));
    }

    // ############### Param Versioning ###############
    // http://localhost:8080/api/product?apiVersion=1
    @GetMapping(value = "/product", params = "apiVersion=1")
    public ResponseEntity<ProductDtoV1> paramVersioningV1(){
        return ResponseEntity.of(Optional.of(new ProductDtoV1("ASUS Laptop")));
    }

    // http://localhost:8080/api/product?apiVersion=2
    @GetMapping(value = "/product", params = "apiVersion=2")
    public ResponseEntity<ProductDtoV2> paramVersioningV2(){
        return ResponseEntity.of(Optional.of(new ProductDtoV2("ASUS Laptop", new BigDecimal(7500))));
    }

    // ############### Header Versioning ###############
    // http://localhost:8080/api/product
    @GetMapping(value = "/product", headers = "X-API-VERSION=1")
    public ResponseEntity<ProductDtoV1> headerVersioningV1(){
        return ResponseEntity.of(Optional.of(new ProductDtoV1("ASUS Laptop")));
    }

    // http://localhost:8080/api/product
    @GetMapping(value = "/product", headers = "X-API-VERSION=2")
    public ResponseEntity<ProductDtoV2> headerVersioningV2(){
        return ResponseEntity.of(Optional.of(new ProductDtoV2("ASUS Laptop", new BigDecimal(7500))));
    }
}
