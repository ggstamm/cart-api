package com.ggstamm.cartapi.service;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ggstamm.cartapi.entity.ProductResponse;
import com.ggstamm.cartapi.entity.ShoppingCart;
import com.ggstamm.cartapi.entity.ShoppingList;
import com.ggstamm.cartapi.util.JsonParser;

@Service
public class ShoppingCartService 
{
	@Autowired
	ProductService productService;
	
	public ShoppingCart newShoppingCartFromShoppingList(String payload) throws FileNotFoundException
	{
		ShoppingList shoppingList = getShoppingListFromJson(payload);
		List<ProductResponse> productResponseList = productService.getProductListFromIds(shoppingList);
		
		if(isBlackFriday())
		{
			productResponseList.add(productService.getBlackFridayGiftProduct());
		}
		
		ShoppingCart shoppingCart = new ShoppingCart(productResponseList);
		
		return shoppingCart;
	}	
	
	private ShoppingList getShoppingListFromJson(String payload)
	{
		return new JsonParser().loadShoppingListFromJSON(payload);
	}
	
	private boolean isBlackFriday()
	{
		LocalDate today = LocalDate.now();
		LocalDate blackFriday = LocalDate.of(2021, 11, 26);
		if(blackFriday.getDayOfMonth() == today.getDayOfMonth())		
		{
			if(today.getMonthValue() == blackFriday.getMonthValue())
			{
				return true;		
			}			
		}
		return false;
	}
	
}
	