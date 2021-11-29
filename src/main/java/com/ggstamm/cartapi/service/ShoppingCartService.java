package com.ggstamm.cartapi.service;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggstamm.cartapi.entity.ShoppingCart;
import com.ggstamm.cartapi.entity.ShoppingList;

@Service
public class ShoppingCartService 
{
	@Autowired
	ProductService productService;
	
	public ShoppingCart newShoppingCartFromShoppingList(ShoppingList[] shoppingList) throws FileNotFoundException
	{
		ShoppingCart shoppingCart = new ShoppingCart(productService.getProductListFromIds(shoppingList));		
		return shoppingCart;
	}	
}
	