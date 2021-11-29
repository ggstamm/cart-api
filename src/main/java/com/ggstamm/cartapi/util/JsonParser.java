package com.ggstamm.cartapi.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.ggstamm.cartapi.entity.Product;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class JsonParser {
	public Product[] loadProductListFromJSONFile() throws FileNotFoundException
	{		
		File file = new File("src\\main\\resources\\products.json");			
		JsonReader jsonReader = new JsonReader(new FileReader(file));		
		Product[] products = new Gson().fromJson(jsonReader, Product[].class);	
		
		return products;
	}		
}
