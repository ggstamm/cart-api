package com.ggstamm.cartapi.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
			if(!productsHash.containsKey(shoppingList.getProducts().get(iteration).getId()))
			{
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
						"The Product with ID = " + shoppingList.getProducts().get(iteration).getId() + " don't exist");			
			}
			
			product = productsHash.get(shoppingList.getProducts().get(iteration).getId());
			
			if(product.getIs_gift())
			{
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
						"The Product with ID = " + product.getId() + " is not available for purchase");
			}
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
	
	public ProductResponse getBlackFridayGiftProduct() throws FileNotFoundException
	{
		return getGiftProduct();
	}

	private Product[] getProductListFromJSONFile() throws FileNotFoundException
	{
		return new JsonParser().loadProductListFromJSONFile();
	}		
	
	private ProductResponse getGiftProduct() throws FileNotFoundException
	{
		Collection<Product> products = getProductsDatabase().values();
		Product giftProduct = new Product();
		
		for(Product product : products)
		{
			if(product.getIs_gift())
			{
				giftProduct = product;
				break;
			}
		}
		
		return new ProductResponse(giftProduct, 1);
	}
}
