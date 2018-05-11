package app.controller;

import app.service.CouponService;
import app.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatePriceController {

    @Autowired
    private CouponService couponService;

    @RequestMapping(value="/")
    public String index(){
        return "Hello world";
    }

    @RequestMapping(value="/calculate", method = RequestMethod.POST)
    @ResponseBody
    public Double calculatePrice(@RequestBody  Order order) {
        System.out.println(order);
        return couponService.calculate(order);
    }
}
