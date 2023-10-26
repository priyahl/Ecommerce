package com.Ecommerce_website.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.Model.Cart;
import com.Ecommerce_website.Model.Category;

public interface CartRepository extends JpaRepository<Cart, Long>{
	Cart findById(long id);

}
