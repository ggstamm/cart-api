package com.ggstamm.cartapi.entity;

public class ShoppingList 
{
	private int id;
	
	private int quantity;
	
	public ShoppingList() {}
	
	public ShoppingList(int id, int quantity) 
	{
		setId(id);
		setQuantity(quantity);
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public int getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
}
