package com.example.products;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Customer {
    String customerName;
    List<DiscountAgreement> discountAgreements = new ArrayList<>();

    public Customer(String customerName)
    {
        this.customerName = customerName;
    }
}
