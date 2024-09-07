package com.vmware.ensemble.rules.i18n.services;

import java.util.ArrayList;
import java.util.List;

import com.vmware.ensemble.rules.i18n.interfaces.Cart;
import com.vmware.ensemble.rules.i18n.interfaces.CartItem;
import com.vmware.ensemble.rules.i18n.models.Coupon;
import com.vmware.ensemble.rules.i18n.models.Product;

public class ShoppingCartService implements Cart {

    private final List<CartItem> cart;

    public ShoppingCartService() {
        this.cart = new ArrayList<>();
    }

    @Override
    public void addItem(CartItem cartItem) {
        this.cart.add(cartItem);
    }

    @Override
    public double checkOut() {
        double totalPrice = 0.0;
        ApplyCouponsOnAllProduct();
        for (CartItem cartItem : cart) {
            if (!cartItem.isCoupon()) {
                Product product = (Product) cartItem;
                totalPrice += product.getDiscountedPrice();
            }
        }
        return totalPrice;
    }

    private void ApplyCouponsOnAllProduct() {
        for (int index = 0; index < cart.size(); index++) {
            CartItem item = cart.get(index);
            if (item.isCoupon()) {
                Coupon coupon = (Coupon) item;
                coupon.applyCoupon(cart, index);
            }
        }
    }
}
