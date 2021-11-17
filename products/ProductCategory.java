package com.example.products;

public enum ProductCategory {
    CHAIR(1),
    TABLE(2),
    DESK(3);

    public final int code;

    ProductCategory(int code)
    {
        this.code = code;
    }
}
