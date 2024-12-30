package com.ProductCRUDapp.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ProductCRUDapp.Model.Product;

@Repository
public class ProductDAO {

		@Autowired
	private HibernateTemplate hibernateTemplate;
		
		//Create product
	@Transactional 
	public void saveProduct(Product product) {
		
		this.hibernateTemplate.saveOrUpdate(product);
	}
	//List all Product
	public List<Product> getProducts(){
		List<Product> products=this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//Delete specific Product
	@Transactional
	public void deleteProduct(int ProductId) {
		Product product=this.hibernateTemplate.get(Product.class, ProductId);
		this.hibernateTemplate.delete(product);
	}
	
	//Update Product
	@Transactional
	public void updateProduct(Product product) {
	    this.hibernateTemplate.update(product);
	}

	
	//Get single product
	public Product getProduct(int ProductId) {
		Product product=this.hibernateTemplate.get(Product.class, ProductId);
		return product;
	}
	
	
}
