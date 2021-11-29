package com.ggstamm.cartapi.entity;

import java.util.List;

public class ShoppingCart 
{
	private Integer total_amount;
	
	private Integer total_amount_with_discount;	
	
	private Integer total_discount;
	
	private List<ProductResponse> productsResponse;	
	
	public ShoppingCart() {}
	
	public ShoppingCart(List<ProductResponse> productResponseList)
	{
		this.productsResponse = productResponseList;
		this.setTotal_amount();
		this.setTotal_discount();
		this.setTotal_amount_with_discount();
	}

	public Integer getTotal_amount() 
	{
		return total_amount;
	}

	public void setTotal_amount() 
	{
		this.total_amount = 0;
		this.productsResponse.forEach(productResponse -> 
		{
			this.total_amount += productResponse.getTotal_amount();
		});
	}

	public Integer getTotal_discount() 
	{
		return total_discount;
	}
	
	public void setTotal_discount() 
	{
		this.total_discount = 0;
		this.productsResponse.forEach(productResponse -> 
		{
			this.total_discount += productResponse.getDiscount();
		});
	}

	public List<ProductResponse> getProducts() 
	{
		return productsResponse;
	}

	public void setProducts(List<ProductResponse> productsResponse) 
	{
		this.productsResponse = productsResponse;
	}

	public Integer getTotal_amount_with_discount() 
	{
		return total_amount_with_discount;
	}

	public void setTotal_amount_with_discount() 
	{
		this.total_amount_with_discount = 0;
		this.total_amount_with_discount = this.total_amount - this.total_discount;
	}
}
