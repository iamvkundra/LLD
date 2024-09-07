package com.vmware.ensemble.rules.i18n.models;

import java.util.ArrayList;
import java.util.List;

import com.vmware.ensemble.rules.i18n.enums.DeductionType;
import com.vmware.ensemble.rules.i18n.enums.ProductType;
import com.vmware.ensemble.rules.i18n.interfaces.CartItem;

public class Product implements CartItem {

    private final double price;
    private final ProductType productType;
    private final List<Coupon> appliedCoupons;

    public Product(ProductType productType, double price) {
        this.appliedCoupons = new ArrayList<>();
        this.price = price;
        this.productType = productType;
    }

    public void applyCoupon(Coupon coupon) {
        appliedCoupons.add(coupon);
    }

    public double getDiscountedPrice() {
        double discountedPrice = this.price;
        for (Coupon coupon : appliedCoupons) {
            if (coupon.getDeductionType() == DeductionType.PERCENTAGE) {
                discountedPrice = discountedPrice * (100 - coupon.getDiscount()) /100;
            } else {
                discountedPrice =  discountedPrice - coupon.getDiscount();
            }
        }
        return discountedPrice;
    }

    public double getPrice() {
        return this.price;
    }

    public ProductType getProductType(){
        return this.productType;
    }

    @Override
    public boolean isCoupon() {
        return false;
    }
}
