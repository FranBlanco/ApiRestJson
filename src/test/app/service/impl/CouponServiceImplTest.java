package app.service.impl;

import app.model.Coupon;
import app.model.Order;
import app.model.Product;
import app.repository.CouponRepository;
import app.service.CouponService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CouponServiceImplTest {


    @Spy
    private CouponRepository couponRepository;

    @InjectMocks
    private CouponServiceImpl couponService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void calculateWithoutOrder() throws Exception {

        Assert.assertEquals(0.0,0.0,couponService.calculate(null));
    }
    @Test
    public void calculateWithoutDiscount() throws Exception {
        Order order = new Order(null, buildProducts());
        couponRepository = Mockito.mock(CouponRepository.class);
        Mockito.when(couponRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());

        Assert.assertEquals(30.0,0.0,couponService.calculate(order));

    }


    @Test
    public void calculateWithDiscount() throws Exception {
        Order order = new Order("DISCOUNT5", buildProducts());
        couponRepository = Mockito.mock(CouponRepository.class);

        Coupon coupon = new Coupon("DISCOUNT5",5.0);

        Mockito.when(couponRepository.findById(Mockito.anyString())).thenReturn(Optional.of(coupon));

        Assert.assertEquals(25.0,0.0,couponService.calculate(order));

    }

    private List<Product> buildProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, 10.0));
        products.add(new Product(1, 20.0));

        return products;
    }

}