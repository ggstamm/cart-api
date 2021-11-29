package com.ggstamm.cartapi.entity;

import java.util.List;

public class ShoppingList 
{
	private List<ShoppingItem> products;

	public List<ShoppingItem> getProducts() {
		return products;
	}

	public void setProducts(List<ShoppingItem> products) {
		this.products = products;
	}	
}
