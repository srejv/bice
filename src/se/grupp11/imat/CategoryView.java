package se.grupp11.imat;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import de.jgrid.JGrid;
import se.chalmers.ait.dat215.project.*;
import javax.swing.AbstractListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;

public class CategoryView extends JPanel {
	
	JList list;
	/**
	 * Create the panel.
	 */
	public CategoryView() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCategory = new JLabel("Category");
		add(lblCategory);
		
		list = new JList();
		list.setBackground(Color.WHITE);
		list.setPreferredSize(new Dimension(100, 200));

		add(list);

	}
	
	public void LoadCategory(ProductCategory category) {
		
		List<Product> prodList = IMatDataHandler.getInstance().getProducts(category);
		ProductListCollection collection = new ProductListCollection(prodList);
		ProductCustomListModel listModel = new ProductCustomListModel(collection);
		list.setModel(listModel);
		
		this.updateUI();
	}
	
}
