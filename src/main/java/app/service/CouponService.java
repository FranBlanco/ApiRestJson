package app.service;

import app.model.Order;
import org.springframework.stereotype.Service;

@Service
public interface CouponService {

    double calculate(Order order);
}