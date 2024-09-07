package com.vmware.ensemble.rules.i18n.models;

import java.util.List;

import com.vmware.ensemble.rules.i18n.enums.CouponType;
import com.vmware.ensemble.rules.i18n.enums.DeductionType;
import com.vmware.ensemble.rules.i18n.interfaces.CartItem;

public abstract class Coupon implements CartItem {

    private final int discount;

    public Coupon(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return this.discount;
    }

    @Override
    public boolean isCoupon() {
        return true;
    }

    public abstract void applyCoupon(List<CartItem> cartItems, int currentIndexOfCartItem);
    public abstract CouponType getCouponType();
    public abstract DeductionType getDeductionType();

}
