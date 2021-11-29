package com.ggstamm.cartapi.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggstamm.cartapi.entity.ShoppingCart;
import com.ggstamm.cartapi.entity.ShoppingList;
import com.ggstamm.cartapi.service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
	@Autowired
	private ShoppingCartService shoppingCartService; 	
		
	@PostMapping(value = "/products", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ShoppingCart> returnShoppingCartFromShoppingList() throws FileNotFoundException
	{
		ShoppingList[] shoppingList = 
			{
					new ShoppingList(1, 10),
					new ShoppingList(3, 0),
					new ShoppingList(4, 7)
			};		
		ShoppingCart shoppingCart = shoppingCartService.newShoppingCartFromShoppingList(shoppingList);
		return ResponseEntity.ok(shoppingCart);
	}
}
