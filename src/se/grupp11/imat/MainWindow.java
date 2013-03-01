package se.grupp11.imat;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ProductCategory;
import se.grupp11.imat.nav.CategoryLink;
import se.grupp11.imat.nav.NavigationLink;
import se.grupp11.imat.nav.SeparationLink;

import java.awt.Dimension;

public class MainWindow {

	private JFrame frame;
	private JPanel start;
	private JPanel history;
	private JPanel settings;
	private JPanel checkout;
	private JPanel panel_1;
	private JPanel category;
	private JList navlist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		IMatDataHandler.getInstance();	
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println(System.getProperty("user.home"));
		start = new StartView();
		history = new HistoryView();
		settings = new SettingsView();
		checkout = new CheckoutView();
		category = new CategoryView();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 664, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 10));
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		navlist = new JList();
		navlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		navlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {
					int selectedIndex = navlist.getSelectedIndex();
					Object o = navlist.getSelectedValue();
					if(o instanceof CategoryLink) {
						panel_1.removeAll();
						CategoryLink c = (CategoryLink)o;
						panel_1.add(c.getPanel());
					} 
					else if(o instanceof SeparationLink) {
						// no thing
						navlist.setSelectedIndex(-1);
					}
					else {
						panel_1.removeAll();
						panel_1.add(((NavigationLink)o).getPanel());
					}
					panel_1.updateUI();
					/*
			        if (selectedIndex == -1) {
			        	// No selection
			        } else if(selectedIndex == 0) {
			        	// Start
			        	panel_1.removeAll();
			        	panel_1.add(start);
			        } else if(selectedIndex == 1) {
			        	// History
			        	panel_1.removeAll();
			        	panel_1.add(history);
		        	
			        } else if(selectedIndex == 2) {
			        	// Settings
			        	panel_1.removeAll();
			        	panel_1.add(settings);
			        } else if(selectedIndex == 3) {
			        	// Checkout
			        	panel_1.removeAll();
			        	panel_1.add(checkout);
			        }
			        panel_1.updateUI();*/
			    }
			}
		});
		SpringLayout sl_panel = new SpringLayout();
		sl_panel.putConstraint(SpringLayout.NORTH, navlist, 5, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, navlist, 5, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, navlist, -266, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, navlist, -5, SpringLayout.EAST, panel);
		panel.setLayout(sl_panel);
		navlist.setModel(new AbstractListModel() {
			NavigationLink[] values = new NavigationLink[] 
					{
					new NavigationLink("Start", start),
					new NavigationLink("History", history),
					new NavigationLink("Settings", settings),
					new NavigationLink("Checkout", checkout),
					new SeparationLink(),
					new CategoryLink(ProductCategory.BERRY),
					new CategoryLink(ProductCategory.BREAD),
					new CategoryLink(ProductCategory.CABBAGE),
					new CategoryLink(ProductCategory.CITRUS_FRUIT),
					new CategoryLink(ProductCategory.COLD_DRINKS),
					new CategoryLink(ProductCategory.DAIRIES),
					new CategoryLink(ProductCategory.EXOTIC_FRUIT),
					new CategoryLink(ProductCategory.FISH),
					new CategoryLink(ProductCategory.FLOUR_SUGAR_SALT),
					new CategoryLink(ProductCategory.FRUIT),
					new CategoryLink(ProductCategory.HERB),
					new CategoryLink(ProductCategory.HOT_DRINKS)
					};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(navlist);
	}
	
	class NavigationRenderer implements ListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

} 