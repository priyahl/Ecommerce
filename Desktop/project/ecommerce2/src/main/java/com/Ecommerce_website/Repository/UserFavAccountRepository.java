package com.Ecommerce_website.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.Model.UserFavAccount;

public interface UserFavAccountRepository extends JpaRepository<UserFavAccount, Long>{
	UserFavAccount findById(long id);

}
