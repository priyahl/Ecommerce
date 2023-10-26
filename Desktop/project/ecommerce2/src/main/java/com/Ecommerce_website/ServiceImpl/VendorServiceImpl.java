package com.Ecommerce_website.ServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce_website.Dto.CategoryDto;
import com.Ecommerce_website.Dto.ItemsDto;
import com.Ecommerce_website.Dto.OrderDto;
import com.Ecommerce_website.Dto.OrderHistoryDto;
import com.Ecommerce_website.Dto.VendorDto;
import com.Ecommerce_website.Model.Category;
import com.Ecommerce_website.Model.Items;
import com.Ecommerce_website.Model.Order;
import com.Ecommerce_website.Model.User;
import com.Ecommerce_website.Model.Vendor;
import com.Ecommerce_website.Repository.CategoryRepository;
import com.Ecommerce_website.Repository.ItemsRepository;
import com.Ecommerce_website.Repository.UserRepository;
import com.Ecommerce_website.Repository.VendorRepository;
import com.Ecommerce_website.Repository.orderRepository;
import com.Ecommerce_website.Service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	public VendorRepository vendorRepo;
	@Autowired
	public CategoryRepository categoryRepo;
	@Autowired
	public ItemsRepository itemsRepo;
	@Autowired
	public orderRepository orderRepo;
	@Autowired
	public UserRepository userRepo;

	@Override
	public VendorDto addvendor(VendorDto vendorDto) {

		Vendor vendor = new Vendor();

		vendor.setName(vendorDto.getName());
		vendor.setEmailId(vendorDto.getEmailId());
		vendor.setMobileNumber(vendorDto.getMobileNumber());
		vendor.setAddress(vendorDto.getAddress());
		vendor.setStatus(true);
		vendor.setAvailability(vendorDto.getAvailability());
		vendor.setBalance(new BigDecimal(500.0));

		Vendor vemailId = vendorRepo.findByEmailId(vendorDto.getEmailId());
		if (vemailId == null) {

			Vendor addv = vendorRepo.save(vendor);

			vendorDto.setVendorId(addv.getVendorId());
			vendorDto.setName(addv.getName());
			vendorDto.setEmailId(addv.getEmailId());
			vendorDto.setMobileNumber(addv.getMobileNumber());
			vendorDto.setBalance(addv.getBalance());
			vendorDto.setAddress(addv.getAddress());
			vendorDto.setStatus(addv.isStatus());
			vendorDto.setAvailability(addv.getAvailability());
			vendorDto.setCreatedOn(addv.getCreatedOn());
			vendorDto.setLastUpdatedOn(addv.getLastUpdatedOn());

		} else {
			throw new RuntimeException("venbdor with same emailId is present");
		}

		return vendorDto;
	}

	@Override
	public VendorDto updatevendor(VendorDto vendorDto) {

		Vendor v1 = vendorRepo.findById(vendorDto.getVendorId());
		if (v1 != null) {

			v1.setName(vendorDto.getName());
			v1.setEmailId(vendorDto.getEmailId());
			v1.setMobileNumber(vendorDto.getMobileNumber());
			v1.setAddress(vendorDto.getAddress());
			v1.setAvailability(vendorDto.getAvailability());
			v1.setBalance(new BigDecimal(500.0));

			Vendor vemailId = vendorRepo.findByEmailId(vendorDto.getEmailId());
			if (vemailId == null) {

				Vendor addvendor = vendorRepo.save(v1);

				vendorDto.setVendorId(addvendor.getVendorId());
				vendorDto.setName(addvendor.getName());
				vendorDto.setEmailId(addvendor.getEmailId());
				vendorDto.setMobileNumber(addvendor.getMobileNumber());
				vendorDto.setBalance(addvendor.getBalance());
				vendorDto.setAddress(addvendor.getAddress());
				vendorDto.setAvailability(addvendor.getAvailability());
				vendorDto.setCreatedOn(addvendor.getCreatedOn());
				vendorDto.setLastUpdatedOn(addvendor.getLastUpdatedOn());

			} else {
				throw new RuntimeException("vendor emailid id is not present");
			}

		} else {
			throw new RuntimeException("vendor id is not present");
		}

		return vendorDto;
	}

	@Override
	public VendorDto getByVendorId(long id) {
		Vendor ven = vendorRepo.findById(id);
		if (ven != null) {
			VendorDto ddto = new VendorDto();
			ddto.setVendorId(ven.getVendorId());
			ddto.setName(ven.getName());
			ddto.setEmailId(ven.getEmailId());
			ddto.setMobileNumber(ven.getMobileNumber());
			ddto.setAddress(ven.getAddress());
			ddto.setStatus(ven.isStatus());
			ddto.setAvailability(ven.getAvailability());
			ddto.setBalance(ven.getBalance());
			ddto.setCreatedOn(ven.getCreatedOn());
			ddto.setLastUpdatedOn(ven.getLastUpdatedOn());
			return ddto;
		} else {
			throw new RuntimeException("vendor id is not present");
		}
	}

//	@Override
//	public VendorDto deleteVendor(long id) {
//	    Vendor vendor = vendorRepo.findById(id);
//	    if (vendor != null) {
//	        vendorRepo.delete(vendor);
//	        VendorDto deletedDto = new VendorDto();
//	        deletedDto.setVendorId(vendor.getVendorId());
//	        // Set other fields as needed
//	        return deletedDto;
//	    } else {
//	        throw new RuntimeException("Vendor with ID " + id + " not found.");
//	    }
//	}

	@Override
	public Object deleteVendor(long id) {

		Vendor ven = vendorRepo.findById(id);
		if (ven != null) {
			ven.setStatus(false);
			ven.setAvailability("No");
			vendorRepo.save(ven);
			Map<String, String> map = new HashMap<String, String>();
			map.put("status", "deleted successfully");
			return map;
		} else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("status", "vendor does not exists");
			return map;
		}
	}

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		Vendor ven = vendorRepo.findById(categoryDto.getVendorId());
		if (ven != null) {

			Category cat1 = categoryRepo.findByNameAndVendorVendorId(categoryDto.getName(), categoryDto.getVendorId());
			if (cat1 == null) {
				Category cat = new Category();
				cat.setName(categoryDto.getName());
				cat.setVendor(ven);

				Category cat2 = categoryRepo.save(cat);

				categoryDto.setCatId(cat2.getCatId());
				categoryDto.setName(cat2.getName());
				categoryDto.setVendorId(cat2.getVendor().getVendorId());
				categoryDto.setCreatedOn(cat2.getCreatedOn());
				categoryDto.setLastUpdatedOn(cat2.getLastUpdatedOn());

			} else {
				throw new RuntimeException("vendor with same categoryName is already present");
			}

		} else {
			throw new RuntimeException("vendor id is not present");
		}

		return categoryDto;
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto) {
		Category cat = categoryRepo.findById(categoryDto.getCatId());
		if (cat != null) {
			Category cat1 = categoryRepo.findByNameAndVendorVendorId(categoryDto.getName(),
					cat.getVendor().getVendorId());
			if (cat1 == null) {
				cat.setCatId(categoryDto.getCatId());
				cat.setName(categoryDto.getName());

				Category cat2 = categoryRepo.save(cat);

				categoryDto.setCatId(cat2.getCatId());
				categoryDto.setName(cat2.getName());
				categoryDto.setVendorId(cat2.getVendor().getVendorId());
				categoryDto.setCreatedOn(cat2.getCreatedOn());
				categoryDto.setLastUpdatedOn(cat2.getLastUpdatedOn());

			} else {
				throw new RuntimeException("vendor with same categoryName is already present");
			}

		} else {
			throw new RuntimeException("category id is not present");
		}

		return categoryDto;

	}

	@Override
	public CategoryDto getByCategoryId(long id) {
		Category cat = categoryRepo.findById(id);
		if (cat != null) {
			CategoryDto cdto = new CategoryDto();
			cdto.setCatId(cat.getCatId());
			cdto.setName(cat.getName());
			cdto.setVendorId(cat.getVendor().getVendorId());
			cdto.setCreatedOn(cat.getCreatedOn());
			cdto.setLastUpdatedOn(cat.getLastUpdatedOn());
			return cdto;
		} else {
			throw new RuntimeException("Category id is not present");
		}
	}

	@Override
	public List<CategoryDto> getAllCategoryByVendorId(long id) {
		Vendor ven = vendorRepo.findById(id);
		if (ven != null) {
			List<Category> cat = categoryRepo.findByVendorVendorId(id);
			List<CategoryDto> cdto = new ArrayList();

			for (Category cat1 : cat) {
				CategoryDto catdto = new CategoryDto();
				catdto.setCatId(cat1.getCatId());
				catdto.setName(cat1.getName());
				catdto.setVendorId(cat1.getVendor().getVendorId());
				catdto.setCreatedOn(cat1.getCreatedOn());
				catdto.setLastUpdatedOn(cat1.getLastUpdatedOn());

				cdto.add(catdto);
			}
			return cdto;
		} else {
			throw new RuntimeException("vendor id is not present");
		}
	}

	@Override
	public ItemsDto addItems(ItemsDto itemsDto) {
//		Vendor ven =vendorRepo.findById(itemsDto.getVendorId());
//		if(ven!=null) {
		Category catid = categoryRepo.findById(itemsDto.getCatId());
		if (catid != null) {
			Items item = itemsRepo.findByNameAndVendorVendorId(itemsDto.getName(), catid.getVendor().getVendorId());
			if (item == null) {
				Items it = new Items();
				it.setName(itemsDto.getName());
				it.setQuantity(0);
				it.setCategory(catid);
				it.setVendor(catid.getVendor());
//				it.setCart(null);
				it.setAmount(itemsDto.getAmount());
				it.setStatus(true);

				Items item1 = itemsRepo.save(it);

				itemsDto.setItemId(item1.getItemId());
				itemsDto.setName(item1.getName());
				itemsDto.setQuantity(item1.getQuantity());
				itemsDto.setCatId(item1.getCategory().getCatId());
				itemsDto.setVendorId(item1.getVendor().getVendorId());
//				itemsDto.setCartId(item1.getCart().getCartId());
				itemsDto.setAmount(item1.getAmount());
				itemsDto.setStatus(item1.isStatus());
				itemsDto.setCreatedOn(item1.getCreatedOn());
				itemsDto.setLastUpdatedOn(item1.getLastUpdatedOn());
				return itemsDto;

			} else {
				throw new RuntimeException("item with same Name is already present");
			}

		} else {
			throw new RuntimeException("category id is not present");
		}
//		}else {
//			throw new RuntimeException("vendor id is not present");
//		}

	}

	@Override
	public ItemsDto updateItem(ItemsDto itemsDto) {
		Items item = itemsRepo.findById(itemsDto.getItemId());
		if (item != null) {
			Items item1 = itemsRepo.findByNameAndCategoryCatId(itemsDto.getName(), itemsDto.getCatId());
			if (item1 == null) {
				item.setName(itemsDto.getName());
				item.setAmount(itemsDto.getAmount());
				item.setStatus(itemsDto.isStatus());

				Items item2 = itemsRepo.save(item);

				itemsDto.setItemId(item2.getItemId());
				itemsDto.setName(item2.getName());
				itemsDto.setCatId(item2.getCategory().getCatId());
				itemsDto.setVendorId(item2.getVendor().getVendorId());
//    		itemsDto.setCartId(item2.getCart().getCartId());
				itemsDto.setAmount(item2.getAmount());
				itemsDto.setStatus(item2.isStatus());
				itemsDto.setCreatedOn(item2.getCreatedOn());
				itemsDto.setLastUpdatedOn(item2.getLastUpdatedOn());
			} else {
				throw new RuntimeException("category with same item is already present");
			}
		} else {
			throw new RuntimeException("Item id is not present");
		}

		return itemsDto;
	}

//	@Override
//	public ItemsDto updateItem(ItemsDto itemsDto) {
//	    Items item = itemsRepo.findById(itemsDto.getItemId());
//
//	    if (item == null) {
//	        throw new RuntimeException("Item ID is not present");
//	    }
//
//	    Items existingItem = itemsRepo.findByNameAndVendorVendorId(itemsDto.getName(), itemsDto.getVendorId());
//
//	    if (existingItem != null) {
//	        throw new RuntimeException("Item with the same name is already present");
//	    }
//
//	    item.setQuantity(0); 
//	    try {
//	        BeanUtils.copyProperties(item, itemsDto);
//	        item = itemsRepo.save(item);
//
//	        ItemsDto updatedDto = new ItemsDto();
//	        BeanUtils.copyProperties(updatedDto, item);
//	        return updatedDto;
//	    } catch (Exception e) {
//	        throw new RuntimeException("Failed to update item", e);
//	    }
//	}

	@Override
	public List<ItemsDto> getAlItemsByCategoryId(long id) {
		Category cat = categoryRepo.findById(id);
		if (cat != null) {
			List<Items> item = itemsRepo.findByCategoryCatId(id);
			List<ItemsDto> idto = new ArrayList();

			for (Items item1 : item) {
				ItemsDto idto1 = new ItemsDto();
				idto1.setItemId(item1.getItemId());
				idto1.setName(item1.getName());
				idto1.setCatId(item1.getCategory().getCatId());
				idto1.setVendorId(item1.getVendor().getVendorId());
				idto1.setAmount(item1.getAmount());
				idto1.setStatus(item1.isStatus());
				idto1.setCreatedOn(item1.getCreatedOn());
				idto1.setLastUpdatedOn(item1.getLastUpdatedOn());

				idto.add(idto1);
			}
			return idto;
		} else {
			throw new RuntimeException("category id is not present");
		}
	}

	@Override
	public ItemsDto getByItemId(long id) {
		Items it = itemsRepo.findById(id);
		if (it != null) {
			ItemsDto idto = new ItemsDto();
			idto.setItemId(it.getItemId());
			idto.setName(it.getName());
			idto.setCatId(it.getCategory().getCatId());
			idto.setVendorId(it.getVendor().getVendorId());
			idto.setAmount(it.getAmount());
			idto.setStatus(it.isStatus());
			idto.setCreatedOn(it.getCreatedOn());
			idto.setLastUpdatedOn(it.getLastUpdatedOn());
			return idto;
		} else {
			throw new RuntimeException("item id is not present");
		}

	}
//	public ItemsDto getByItemId(long id) {
//		return departmentList.stream().filter(department -> department.id == (id)).findFirst()
//
//				.orElseThrow(() -> new RuntimeException("The Department ID You Have Entered Is Not Available"));
//	}

	@Override
	public List<OrderHistoryDto> getAllOrderHistoryByVendorId(long id) {
		  Vendor ven=vendorRepo.findById(id);
	      if(ven!=null) {
	    	  
	    	  List<Order> order1=orderRepo.findByVendorVendorId(id);
	    	  List<OrderHistoryDto> odto=new ArrayList();
	    	  for(Order dto:order1) {
	    		  OrderHistoryDto od=new OrderHistoryDto();
	    		  od.setOrderId(dto.getOrderId());
	    	     od.setCartId(dto.getCart().getCartId());
	    	     od.setUserId(dto.getUser().getUserId());
	    	     od.setVendorId(dto.getVendor().getVendorId());
	    	     od.setAmount(dto.getAmount());
	    	     od.setTransactionId(dto.getTransactionId());
	    	     od.setDescription(dto.getDescription());
	    	     odto.add(od);
	    	  }
	  		return odto;
	      }
	      else {
	    	  throw new RuntimeException("vendor id is not present");
	      }
	}

	@Override
	public OrderHistoryDto getAllOrderHistoryByVendorIdAndOrderId(long vendorId, long orderId) {
		Vendor ven = vendorRepo.findByVendorId(vendorId);
		if (ven != null) {
			Order order = orderRepo.findByOrderId(orderId);
			if (order != null) {
				Order orders = orderRepo.findByVendorVendorIdAndOrderId(vendorId,orderId);
				if (orders != null) {
					OrderHistoryDto odto = new OrderHistoryDto();
					odto.setOrderId(orders.getOrderId());
					odto.setCartId(orders.getCart().getCartId());
					odto.setUserId(orders.getUser().getUserId());
					odto.setVendorId(orders.getVendor().getVendorId());
					odto.setAmount(orders.getAmount());
					odto.setTransactionId(orders.getTransactionId());
					odto.setDescription(orders.getDescription());
					return odto;
				}
				else throw new RuntimeException("no data exists");
			}
			else throw new RuntimeException("order id is not present");
		}
		else throw new RuntimeException("vendor id is not present");

	}



	


}
