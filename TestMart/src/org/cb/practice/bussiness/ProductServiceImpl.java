package org.cb.practice.bussiness;

import java.util.ArrayList;
import java.util.List;

import org.cb.practice.Product;

public class ProductServiceImpl {
		
		List<String> bookList = new ArrayList<String>();
		List<String> musicList = new ArrayList<String>();
		List<String> movieList = new ArrayList<String>();
		
		public ProductServiceImpl() {
			
			bookList.add("Physics");
			bookList.add("chemistry");
			bookList.add("Telugu");
			
			musicList.add("Jazz");
			musicList.add("Pop");
			musicList.add("Rock");
			
			movieList.add("Khaidi");
			movieList.add("Driva");
			movieList.add("Badra");
				
		}
	
		public List<String> getProductCategories() {
		
			List<String> categories = new ArrayList<String>();
			categories.add("Books");
			categories.add("Music");
			categories.add("Movies");
		
			return categories;
		}
		
		public List<String> getProducts(String category) {
			
			switch(category.toLowerCase()) {
			
			case "books":
				return bookList;
				
			case "music":
				return musicList;
				
			case "movie":
				return movieList;
			}
			return null;
		}
		
		public boolean addProduct(String category, String product) {
			
			switch (category.toLowerCase()) {
			case "books":
				bookList.add(product);
				break;
				
			case "music":
				musicList.add(product);
				break;
			
			case "movie":
				movieList.add(product);
				break;

			default:
				return false;
			}
			return true;
		}

		public List<Product> getProductV2(String category) {
			 
			List<Product> productList = new ArrayList<>();
			productList.add(new Product("JavaBrains", "222", 99999.99));
			productList.add(new Product("C-Language", "32323", 44444.44));
			productList.add(new Product(".Net", "4334", 2323.44));
			
			return productList;
		}
}