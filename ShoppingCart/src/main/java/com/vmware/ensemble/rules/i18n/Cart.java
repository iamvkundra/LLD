package com.vmware.ensemble.rules.i18n;

import java.util.ArrayList;
import java.util.List;

import com.vmware.ensemble.rules.i18n.products.Product;

public class Cart {
    List<Product> cartItems;

    public Cart() {
        this.cartItems =  new ArrayList<>();
    }

    public void addProduct(Product product) {
        cartItems.add(product);
        System.out.println("Added the product in the Cart, Original Price: " + product.getPrice()
        +" Discounted Price: " + cartItems.get(cartItems.size()-1).getPrice());
    }

    public void removeProduct(String productId) {
        Product product = null;
        for (Product p : cartItems) {
            if (p.getProductId().equals(productId)) {
                product = p;
                break;
            }
        }
        cartItems.remove(product);
        System.out.println("Successfully Removed the product from Cart, ProductId: " + productId);
    }

    long getTotalCartPrice() {
        long totalPrice = 0;
        for (Product product : cartItems) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
