package se.grupp11.imat;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class ProductCustomListModel implements ListModel {
	private ProductListCollection collection;
	
	public ProductCustomListModel(ProductListCollection collection) {
		this.collection = collection;
	}

	@Override
	public Object getElementAt(int index) {
		return (collection.getProducts().get(index));
	}

	@Override
	public int getSize() {
		return (collection.getNumProducts());
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
	}
	
	@Override
	public void addListDataListener(ListDataListener arg0) {
	}

}
