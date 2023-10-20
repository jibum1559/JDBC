package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;


public class ProductController {
	private ProductModel productsModel;
	private ProductView productsView;
	
	public ProductController(Connection con, ProductView view) {
		this.productsModel = new ProductModel(con);
		this.productsView = view;
	}
	
	public void displayALLProducts() {
		List<ProductDTO> products = productsModel.getProducts();
		productsView.displayProducts(products);
	}
}
