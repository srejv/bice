package se.grupp11.imat;

import java.util.ArrayList;
import java.util.List;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

public class ProductListCollection {
	private List<Product> products;
	private int numProducts;
	
	public ProductListCollection(List<Product> products) {
		this.products = products;
		this.numProducts = products.size(); 
	}
	
	public ProductListCollection() {
		products = new ArrayList<Product>();
		for(int i = 1; i < 11; i++) {
			products.add(IMatDataHandler.getInstance().getProduct(i));
		}
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public int getNumProducts() {
		return products.size();
	}

}
