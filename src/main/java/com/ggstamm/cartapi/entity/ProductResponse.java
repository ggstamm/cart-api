package com.ggstamm.cartapi.entity;

public class ProductResponse 
{
private Integer id;
	
	private Integer quantity;
	
	private Integer unit_amount;
	
	private Integer total_amount;
	
	private Integer discount;
	
	private Boolean is_gift;
	
	public ProductResponse() {}
	
	public ProductResponse(Product product, int quantity)
	{
		this.setId(product.getId());
		this.setQuantity(quantity);
		this.setUnit_amount(product.getAmount());
		this.setTotal_amount();
		this.setIs_gift(product.getIs_gift());
		this.setDiscount(0);		
	}

	public ProductResponse(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getUnit_amount() {
		return unit_amount;
	}

	public void setUnit_amount(Integer unit_amount) {
		this.unit_amount = unit_amount;
	}

	public Integer getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount() {
		this.total_amount = this.unit_amount * this.quantity;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Boolean getIs_gift() {
		return is_gift;
	}

	public void setIs_gift(Boolean is_gift) {
		this.is_gift = is_gift;
	}
}
