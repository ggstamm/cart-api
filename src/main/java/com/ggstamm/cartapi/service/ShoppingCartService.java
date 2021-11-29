package com.ggstamm.cartapi.service;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		ShoppingCart shoppingCart = new ShoppingCart(productService.getProductListFromIds(shoppingList));		
		return shoppingCart;
	}	
	
	private ShoppingList getShoppingListFromJson(String payload)
	{
		return new JsonParser().loadShoppingListFromJSON(payload);
	}
}
	