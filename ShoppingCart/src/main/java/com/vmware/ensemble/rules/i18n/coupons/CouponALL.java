package com.vmware.ensemble.rules.i18n.coupons;

import java.util.List;

import com.vmware.ensemble.rules.i18n.enums.CouponType;
import com.vmware.ensemble.rules.i18n.enums.DeductionType;
import com.vmware.ensemble.rules.i18n.interfaces.CartItem;
import com.vmware.ensemble.rules.i18n.models.Coupon;
import com.vmware.ensemble.rules.i18n.models.Product;

public class CouponALL extends Coupon {

    public CouponALL(int discount) {
        super(discount);
    }

    @Override
    public void applyCoupon(List<CartItem> cartItems, int currentIndexOfCartItem) {
        for (CartItem cartItem : cartItems) {
            if (!cartItem.isCoupon()) {
                Product product = (Product) cartItem;
                product.applyCoupon(this);
            }
        }
    }

    @Override
    public CouponType getCouponType() {
        return CouponType.ALL;
    }

    @Override
    public DeductionType getDeductionType() {
        return DeductionType.PERCENTAGE;
    }
}
