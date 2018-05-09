package service.impl;

import model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CouponRepository;
import service.CouponService;

public class CouponServiceImpl implements CouponService{

    @Autowired
    CouponRepository couponRepository;


    @Override
    public boolean isValid(Coupon coupon) {
        return couponRepository.isValid(coupon);
    }
}
