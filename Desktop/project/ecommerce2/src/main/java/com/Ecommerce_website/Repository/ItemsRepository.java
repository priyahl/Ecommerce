package com.Ecommerce_website.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.Model.Category;
import com.Ecommerce_website.Model.Items;

public interface ItemsRepository extends JpaRepository<Items, Long>{
	Items findById(long id);

	Items findByNameAndVendorVendorId(String name, long vendorId);

	List<Items> findByCategoryCatId(long id);

	Items findByNameAndCategoryCatId(String name, long catId);
	


}
