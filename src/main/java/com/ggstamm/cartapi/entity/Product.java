package com.ggstamm.cartapi.entity;

public class Product 
{
	private Integer id;
	
	private String title;
	
	private String description;
	
	private Integer amount;
	
	private boolean is_gift;
	
	public Product() {}
	
	public Integer getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}	
	
	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public Integer getAmount() 
	{
		return amount;
	}

	public void setAmount(Integer amount) 
	{
		this.amount = amount;
	}

	public boolean getIs_gift() 
	{
		return is_gift;
	}

	public void setIs_gift(boolean is_gift) 
	{
		this.is_gift = is_gift;
	}	
}
