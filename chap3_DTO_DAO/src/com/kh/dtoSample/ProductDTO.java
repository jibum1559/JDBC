package com.kh.dtoSample;

public class ProductDTO {

	private int ProductId;
	private String ProductName;
	private String Category;
	private double Price;
	private int StockQuantity;
	
	//기본 생성자
	public ProductDTO() {
	
	}
	//파라미터 생성자
	public ProductDTO(int ProductId, String ProductName, String Category, double Price, int StockQuantity) {
		this.ProductId = ProductId;
		this.ProductName = ProductName;
		this.Category = Category;
		this.Price = Price;
		this.StockQuantity = StockQuantity;
	}
	
	
	//Getter Setter 생성자
	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		this.ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		this.ProductName = productName;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		this.Category = category;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		this.Price = price;
	}

	public int getStockQuantity() {
		return StockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.StockQuantity = stockQuantity;
	}

	@Override
	public String toString() {
		return "ProductsDTO";
	}
	
}
