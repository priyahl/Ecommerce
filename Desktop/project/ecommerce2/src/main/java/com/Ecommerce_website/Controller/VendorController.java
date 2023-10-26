package com.Ecommerce_website.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce_website.Dto.CategoryDto;
import com.Ecommerce_website.Dto.ItemsDto;
import com.Ecommerce_website.Dto.OrderDto;
import com.Ecommerce_website.Dto.OrderHistoryDto;
import com.Ecommerce_website.Dto.VendorDto;
import com.Ecommerce_website.Service.VendorService;

@RestController
public class VendorController {
	@Autowired
	VendorService vendorService;
	
    @PostMapping("/addvendor")
	public VendorDto addvendor(@RequestBody  VendorDto vendorDto) {
		return vendorService.addvendor(vendorDto);
	}
    
    @PutMapping("/updatevendor")
	public VendorDto updatevendor(@RequestBody  VendorDto vendorDto) {
		return vendorService.updatevendor(vendorDto);
	}
    
    @GetMapping("/getbyvendorid/{id}")
    public VendorDto getVendorById(@PathVariable long id) {
    return vendorService.getByVendorId(id);
    }
    

	@DeleteMapping("/deletevendor/{id}")
	public Object deletevendor(@PathVariable long id) {
		return vendorService.deleteVendor(id);
	}

//    @DeleteMapping("/del/{id}")
//    public VendorDto deleteVendor(@PathVariable long id) {
//        return vendorService.deleteVendor(id);
//    }
    
    @PostMapping("/addCategory")
	public CategoryDto addcategory(@RequestBody  CategoryDto categoryDto) {
		return vendorService.addCategory(categoryDto);
	}
    
    @PutMapping("/updateCategory")
   	public CategoryDto updateCategory(@RequestBody  CategoryDto categoryDto) {
   		return vendorService.updateCategory(categoryDto);
   	}
    
    @GetMapping("/getCategoryById/{id}")
    public CategoryDto getByCategoryId(@PathVariable long id) {
    	return vendorService.getByCategoryId(id);
    }
    
    @GetMapping("/getAllCategoryByVendorId/{id}")
    public List<CategoryDto> getAllCategoryByVendorId(@PathVariable long id) {
    	return vendorService.getAllCategoryByVendorId(id);
    }
    
    @PostMapping("/addItems")
  	public ItemsDto addItems(@RequestBody  ItemsDto itemsDto) {
  		return vendorService.addItems(itemsDto);
  	}
    
    @PutMapping("/updateItem")
    public ItemsDto updateItem(@RequestBody ItemsDto itemsDto) {
    	return vendorService.updateItem(itemsDto);
    }
    
    @GetMapping("/getAllItemsByCatId/{id}")
    public List<ItemsDto> getAllItemsByCatId(@PathVariable long id) {
    	return vendorService.getAlItemsByCategoryId(id);
    }
    
    @GetMapping("/getAllItemsByItemId/{id}")
    public ItemsDto getAllItemsByItemId(@PathVariable long id) {
    	return vendorService.getByItemId(id);
    }
    
    @GetMapping("/getAllOrderHistoryByVendorId/{id}")
    public List<OrderHistoryDto> getAllOrderHistoryByVendorId(@PathVariable long id) {
    	return vendorService.getAllOrderHistoryByVendorId(id);
    }
  
    @GetMapping("/getAllOrderHistoryByVendorIdAndOrderId/{vendorId}/{orderId}")
		private OrderHistoryDto getAllOrderHistoryByVendorIdAndOrderId(@PathVariable long vendorId,@PathVariable long orderId) {
			return vendorService.getAllOrderHistoryByVendorIdAndOrderId( vendorId, orderId);
		}
  
   

}
