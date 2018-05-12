package app.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CouponTest {

    @Test
    public void testEmptyConstructor(){
        Coupon coupon = new Coupon();
        assertNull(coupon.getName());
        assertNull(coupon.getValue());

    }
    @Test
    public void testConstructor(){
        Coupon coupon = new Coupon("SuperCoupon", 100.0);
        assertEquals("SuperCoupon", coupon.getName());
        assertEquals(100.0,0,coupon.getValue());
    }

    @Test
    public void testSettersAndGetters(){
        Coupon coupon = new Coupon();
        coupon.setName("SuperCoupon");
        coupon.setValue(50.0);

        Assert.assertEquals("SuperCoupon",coupon.getName());
        Assert.assertEquals(50.0,0,coupon.getValue());

    }

}