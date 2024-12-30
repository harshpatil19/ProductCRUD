package com.ProductCRUDapp.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.ProductCRUDapp.DAO.ProductDAO;
import com.ProductCRUDapp.Model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDAO productdao;

	@RequestMapping("/home")
	public String home(Model m) {
		List<Product> products = productdao.getProducts();
		m.addAttribute("product", products);
		return "index";
	}

	@RequestMapping("/Addproduct")
	public String addProduct(Model m) {
		m.addAttribute("title", "AddProduct");
		return "addProductForm";
	}

	@RequestMapping(value = "/submit-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productdao.saveProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/home");
		return redirectView;
	}

	@RequestMapping("/home/delete/{Id}")
	public RedirectView deleteProduct(@PathVariable("Id") int Id, HttpServletRequest request) {
		this.productdao.deleteProduct(Id);
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl(request.getContextPath() + "/home");
		return redirectview;
	}
	@RequestMapping("/home/update/{Id}")
public String updateProduct(@PathVariable("Id")int Id, Model model) {
	Product product = this.productdao.getProduct(Id);
model.addAttribute("product", product);
		return  "Update";
	
}
}
