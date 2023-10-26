package com.Ecommerce_website.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.Model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	Category findById(long id);

	Category findByNameAndVendorVendorId(String name, long vendorId);

	List<Category> findByVendorVendorId(long id);

}
