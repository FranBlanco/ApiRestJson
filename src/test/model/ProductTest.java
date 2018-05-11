package model;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest {

    @Test
    public void testConstructorWithArguments(){
        Product product = new Product(1,10.0);
//        Assert.assertEquals(1,product.getId());
        Assert.assertEquals(1,product.getId().intValue());
        Assert.assertEquals(10.0,0,product.getPrice().doubleValue());

    }

    @Test
    public void testEmptyConstructor(){
        Product product = new Product();
        Assert.assertEquals(null,product.getId());
        Assert.assertEquals(null,product.getPrice());

    }

    @Test
    public void testGettersAndSetters(){
        Product product = new Product();
        product.setId(10);
        product.setPrice(23.2);
        Assert.assertEquals(10,product.getId().intValue());
        Assert.assertEquals(23.2,0,product.getPrice());
    }
}
