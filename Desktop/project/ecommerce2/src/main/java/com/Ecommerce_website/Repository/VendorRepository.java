package com.Ecommerce_website.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.Model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long>{
	Vendor findById(long id);
	Vendor findByEmailId(String emailId);
	Vendor findByVendorId(long vendorId);

}
