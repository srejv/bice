package se.grupp11.imat.nav;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.grupp11.imat.CategoryView;

public class CategoryLink extends NavigationLink {
	
	private ProductCategory cat; 
	public CategoryLink(ProductCategory category) {
		super(category.toString().replace('_', ' ').toLowerCase(), null);
		cat = category;
		
		CategoryView v = new CategoryView();
		v.LoadCategory(cat);
		this.setPanel(v);
	}
}
