package app.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {

    private Order order;
    @Before
    public void setup(){
        order = new Order("SuperCoupon",null);
    }

    @Test
    public void testConstructor(){
        Assert.assertEquals("SuperCoupon",order.getCouponName());
        Assert.assertNull(order.getProducts());
    }

    @Test
    public void testCoupon(){
        order.setCouponName("SuperCoupon");
        Assert.assertEquals("SuperCoupon", order.getCouponName());
    }

    @Test
    public void testProducts(){
        List<Product> products = new ArrayList<>();
        Product myProduct = new Product();
        products.add(myProduct);
        order.setProducts(products);
        Assert.assertEquals(1,products.size());
        Assert.assertEquals(myProduct,products.get(0));
    }

}