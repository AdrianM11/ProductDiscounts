package com.example.products;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {

    private int productId;
    private String productName;
    private ProductCategory productCategory;
    private BigDecimal standardPrice;

    public Product(int productId,
                   String productName,
                   ProductCategory productCategory,
                   BigDecimal standardPrice)
    {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.standardPrice = standardPrice;
    }

    public Product(Product p)
    {
        this.productId = p.getProductId();
        this.productName = p.getProductName();
        this.productCategory = p.getProductCategory();
        this.standardPrice = p.getStandardPrice();
    }
}
