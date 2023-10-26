package com.Ecommerce_website.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.Model.Order;
import com.Ecommerce_website.Model.User;

public interface orderRepository extends JpaRepository<Order, Long>{
	Order findById(long id);

	Order findByOrderId(long id);

	List<Order> findByUserUserId(long id);

	List<Order> findByVendorVendorId(long id);


//	List<Order> findByOrderOrderId(long id);

	Order findByUserUserIdAndOrderId(long userId, long orderId);

	Order findByVendorVendorIdAndOrderId(long vendorId, long orderId);

//	Order findByOrderId(long orderId);


}
