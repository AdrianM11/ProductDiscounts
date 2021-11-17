package com.example.products;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/*
 * Order class
 * Order belongs to a customer, that may or may not have discount agreements
 * Products inside are added in a map with product Id as key
 */
@Getter
@Setter
public class Order {
    int orderId;
    String customerName;
    Map<Integer, CartItem> items = new HashMap<>();

    public Order(int orderId, String customerName)
    {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    /*
     * adds a product to the cart.
     * It increments the current number of products in the order if the product is already in the cart
     */
    public void addItem(Product product)
    {
        CartItem item = items.get(product.getProductId());
        if (item == null)
        {
            items.put(product.getProductId(), new CartItem(product));
        }
        else
        {
            item.addUnit();
        }
    }

    /*
     * removes a product from the cart
     * It decrements the current number of products in the order and removes the product from the map if the values is zero
     */
    public void removeItem(Product product)
    {
        CartItem item = items.get(product.getProductId());
        if (item != null && item.removeUnit() == 0)
        {
            items.remove(product.getProductId());
        }
    }
}
