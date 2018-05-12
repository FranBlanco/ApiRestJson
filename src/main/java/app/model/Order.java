package app.model;

import java.util.List;

public class Order {

    private String couponName;
    private List<Product> products;

    public Order(String couponName, List<Product> products) {
        this.couponName = couponName;
        this.products = products;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
