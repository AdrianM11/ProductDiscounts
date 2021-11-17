package com.example.products;

/*
 * Abstract class for discount agreements
 */
public abstract class DiscountAgreement {
    int dicountId;
    abstract void applyDiscount(Order order);
}
