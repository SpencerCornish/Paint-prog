package main;

import java.awt.*;
import javax.swing.Icon;

public class ButtonIcon implements Icon{
	private int shape = 0;
	
	public ButtonIcon(int shape) {
		this.shape = shape;
	}

	public int getIconHeight() {
		return 12;
	}

	public int getIconWidth() {
		return 17;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		switch(shape) {
		case 1: 
			g.setColor(ColorPanel.getInstance().getColor(0)); 
			g.fillRect(x, y, getIconWidth(), getIconHeight()); 
			break;
		case 2: 
			g.setColor(ColorPanel.getInstance().getColor(1)); 
			g.drawRect(x, y, getIconWidth(), getIconHeight());
			break;
		case 3: 
			g.setColor(ColorPanel.getInstance().getColor(0)); 
			g.fillOval(x, y, getIconWidth(), getIconHeight()); 
			break;
		case 4: 
			g.setColor(ColorPanel.getInstance().getColor(1)); 
			g.drawOval(x, y, getIconWidth(), getIconHeight()); 
			break;
		case 5: 
			g.setColor(ColorPanel.getInstance().getColor(1)); 
			g.drawLine(8, 18, 40, 8); 
			break;
		case 6: 
			g.setColor(ColorPanel.getInstance().getColor(2)); 
			g.fillRect(5, y, 10, 15); 
			break;
		case 7: 
			g.setColor(ColorPanel.getInstance().getColor(1)); 
			g.fillRect(5, y, 10, 15); 
			break;
		case 8: 
			g.setColor(ColorPanel.getInstance().getColor(0));
			g.fillRect(5, y, 10, 15); 
			break;
		}
		ButtonPanel.getInstance().repaint();		//updates colors of icons
	}
}
