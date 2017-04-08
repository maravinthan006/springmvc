package com.niit.controller;
 

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO productdao;
	@Autowired
	private CategoryDAO categorydao;

	@Autowired
	private SupplierDAO supplierdao;

	@RequestMapping(value="Product", method=RequestMethod.GET)
    public ModelAndView sendproduct(@ModelAttribute("product") Product product,Model model)
	{																					
		ModelAndView mv=new ModelAndView("Product");
		List<Product> plist= productdao.plist();
		mv.addObject("productList", plist);
		List<Category> list= categorydao.list();
		mv.addObject("category_drop", list);
		List<Supplier> slist= supplierdao.slist();
		mv.addObject("supplier_drop", slist);
		mv.addObject("product",new Product());
		return mv;
	}
	
	
	@RequestMapping(value="saveproduct", method=RequestMethod.POST)
	public String saveProduct(
			@Valid  @ModelAttribute(value="product") Product product,BindingResult result,Model model){
	{
		System.out.println("inside saveproduct");
		productdao.addProduct(product);
		ModelAndView mv=new ModelAndView("Product");
		List<Product> plist= productdao.plist();
		mv.addObject("productList", plist);
		System.out.println("AddProduct Controller Passed");
	System.out.println(product.getImage());
		MultipartFile prodImage=product.getImage();
		if(!prodImage.isEmpty()){
			Path paths=Paths.get("E:\\workspace\\shoppingcart\\src\\main\\webapp\\WEB-INF\\resources\\images\\"+ product.getId()+".png");
			try {
			prodImage.transferTo(new File(paths.toString()));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		return "Product";
	  }
	}
	@RequestMapping(value = "editproduct", method = RequestMethod.GET) 
	public ModelAndView editCategory(@RequestParam("productId") String productId) {
		ModelAndView model = new ModelAndView("Product", "product", new Product());
		List<Product> plist=productdao.plist();
		model.addObject("productList",plist);
		model.addObject("values", productdao.getProductById(productId));
		List<Category> list= categorydao.list();
		model.addObject("category_drop", list);
		List<Supplier> slist= supplierdao.slist();
		model.addObject("supplier_drop", slist);	
		model.addObject("product",new Product());
		System.out.println("EditProduct Controller Passed");
		return model;
	}
	
	@RequestMapping(value = "deleteproduct", method = RequestMethod.GET) 
	public String deleteCategory(@RequestParam("productId") String productId, Model model) {
		System.out.println("Delete Product Controller Reached");
		productdao.deleteProduct(productId);
		List<Product> list= productdao.plist();
		model.addAttribute("productList", list);
		model.addAttribute("product",new Product());
		System.out.println("Delete Product Controller Passed");
		return "Product";

	}
	@RequestMapping(value = "productpage", method = RequestMethod.GET) 
	public String productpage(@RequestParam("productid") String productid, Model model) {
		
		model.addAttribute("productlist", productdao.getProductById(productid));
		return "Productpage";

	}


}
	