package com.ProductCRUDapp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String name;
	private String description;
	private long price;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Product(String name, String description, long price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [Id=" + Id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
	
	
	
	
	

}
