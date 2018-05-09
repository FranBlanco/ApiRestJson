package repository;

import model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CouponRepository  extends JpaRepository<Coupon,Serializable>{

    boolean isValid(Coupon coupon);
}
