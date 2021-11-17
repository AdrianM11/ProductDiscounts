package com.example.products;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/*
 * CartItem class extends Product and adds two extra fields: quantity and appliedDiscount
 * This item is used by Order class
 */
@Getter
@Setter
public class CartItem extends Product {

    private int quantity;
    private BigDecimal appliedDiscount = BigDecimal.ZERO;

    public CartItem(Product product)
    {
        super(product);
        quantity = 1;
    }

    public void addUnit()
    {
        this.quantity = this.quantity + 1;
    }

    public int removeUnit()
    {
        this.quantity = this.quantity - 1;
        return this.quantity;
    }
}
