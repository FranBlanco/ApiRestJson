package model;


import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {

    @Id
    private String name;
    @Basic
    private Double value;

    public Coupon(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public Coupon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}