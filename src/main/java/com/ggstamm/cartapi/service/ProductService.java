package com.ggstamm.cartapi.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ggstamm.cartapi.entity.Product;
import com.ggstamm.cartapi.entity.ProductResponse;
import com.ggstamm.cartapi.entity.ShoppingList;
import com.ggstamm.cartapi.util.JsonParser;

@Service
public class ProductService {
	public List<ProductResponse> getProductListFromIds(ShoppingList shoppingList) throws FileNotFoundException
	{
		HashMap<Integer, Product> productsHash = getProductsDatabase();
		List<ProductResponse> productsResponseList = new ArrayList<>();
		Product product = new Product();
		
		for(int iteration = 0; iteration < shoppingList.getProducts().size(); iteration++)
		{
			product = productsHash.get(shoppingList.getProducts().get(iteration).getId());
			productsResponseList.add(new ProductResponse(product, (shoppingList.getProducts().get(iteration).getQuantity())));
		}	
		
		return productsResponseList;
	}

	
	public HashMap<Integer, Product> getProductsDatabase() throws FileNotFoundException
	{
		HashMap<Integer, Product> productsHash = new HashMap<>();
		Product[] products =  getProductListFromJSONFile();
		
		for(int iteration = 0; iteration < products.length; iteration++)
		{
			productsHash.put(products[iteration].getId(), products[iteration]);
		}
		
		return productsHash;		
	}	

	private Product[] getProductListFromJSONFile() throws FileNotFoundException
	{
		return new JsonParser().loadProductListFromJSONFile();
	}	
}
