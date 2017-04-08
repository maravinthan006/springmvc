package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

@Controller
public class SupplierController {
@Autowired
SupplierDAO supplierdao;

@RequestMapping(value="Supplier",method=RequestMethod.GET)
public ModelAndView sendSupplier(@ModelAttribute("supplier") Supplier supplier)
{
	ModelAndView mv=new ModelAndView("Supplier");
	
	List<Supplier> slist= supplierdao.slist();
	mv.addObject("supplierList", slist);
	return mv;
}

@RequestMapping(value="supplieradd", method=RequestMethod.POST)
public ModelAndView addSupplier(Supplier supplier,Model model)
 {
	
	ModelAndView mv=new ModelAndView("Supplier");
	supplierdao.addSupplier(supplier);
	List<Supplier> slist= supplierdao.slist();
	model.addAttribute("supplierList", slist);
	
	return mv;

 }
@RequestMapping(value = "editsupplier", method = RequestMethod.GET) 
public ModelAndView editSupplier(@RequestParam("supplierId") String supplierId) {
	ModelAndView model = new ModelAndView("Supplier", "supplier", new Supplier());
	model.addObject("list", supplierdao.slist());
	model.addObject("value", supplierdao.getSupplierById(supplierId));
	System.out.println("Supplier Edit Controller Passed");
	List<Supplier> list= supplierdao.slist();
	model.addObject("supplierList", list);
		return model;
}


@RequestMapping(value = "deletesupplier", method = RequestMethod.GET) 
public String deleteSupplier(@RequestParam("supplierId") String supplierId, Model model) {
	System.out.println("Supplier Delete Controller Passed");
	supplierdao.deleteSupplier(supplierId);
	List<Supplier> list= supplierdao.slist();
	model.addAttribute("supplierList", list);
	
	return "Supplier";

}

}
