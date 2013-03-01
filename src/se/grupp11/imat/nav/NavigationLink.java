package se.grupp11.imat.nav;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NavigationLink extends JLabel {
	
	public enum NavType { JPanelLink, CategoryLink, ListLink };
	public NavType type;
	
	public JPanel panel;
	
	public NavigationLink(String text, JPanel panel) {
		this.setText(text);
		this.panel = panel;
	}
	
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
	
	@Override 
	public String toString() {
		return getText();
	}
}
