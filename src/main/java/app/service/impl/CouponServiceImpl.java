package app.service.impl;

import app.repository.CouponRepository;
import app.service.CouponService;
import app.model.Coupon;
import app.model.Order;
import app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public double calculate(Order order) {
        double amount = summarizeProducts(productsOf(order));
        double discount = obtainDiscount(couponOf(order));
        return applyCoupon(amount,discount);

    }

    private double obtainDiscount(Optional<Coupon> coupon) {
        return coupon.isPresent()
                ?coupon.get().getValue()
                :0;

    }

    private List<Product> productsOf(Order order){
        List<Product> result = new ArrayList<>();

        if(order != null){
            result.addAll(order.getProducts());
        }
        return result;
    }

    private Optional<Coupon> couponOf(Order order){
        if(order == null){
            return Optional.empty();
        }

        return couponRepository.findById(order.getCouponName());
    }

    private double applyCoupon(double amount, double discount) {

        if(discount >=  amount){
            return 0;
        }

        return amount - discount;


    }

    private double summarizeProducts(List<Product> products) {
        return products.stream().collect(Collectors.summarizingDouble(Product::getPrice)).getSum();
    }
}
