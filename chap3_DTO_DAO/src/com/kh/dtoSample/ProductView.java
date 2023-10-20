package com.kh.dtoSample;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
	
	public void displayProducts(List<ProductDTO> products) {
		for(ProductDTO p : products) {
			System.out.println("product_id : " + p.getProductId());
			System.out.println("prodcut_name : " + p.getProductName());
			System.out.println("category : " + p.getCategory());
			System.out.println("price : " + p.getPrice());
			System.out.println("stock_quantity : " + p.getStockQuantity());
			System.out.println();
		}
	}
}
