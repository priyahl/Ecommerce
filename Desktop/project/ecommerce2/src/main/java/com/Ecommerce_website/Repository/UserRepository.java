package com.Ecommerce_website.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.Model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	User findById(long id);
public User findByEmailId(String emailId);
User findByUserId(long userId);

}
