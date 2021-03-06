package main;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;

public class ButtonIcon implements Icon{
	private int shape = 0;					//shape indicator
	private final int HEIGHT = 12;			//icon dimensions
	private final int WIDTH = 17;

	public ButtonIcon(int shape) {
		this.shape = shape;
	}

	public int getIconHeight() {
		return HEIGHT;
	}
	public int getIconWidth() {
		return WIDTH;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {		//sets all the shapes as icons on buttons
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
			g.drawLine(8, 20, 30, 8); 
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
		case 9: 
			try {
				Image img = ImageIO.read(this.getClass().getResource("images/Eraser.gif"));
				g.drawImage(img, 10,3, null);
			} catch (IOException e) {
				System.out.println("There was an issue importing the Eraser!! is the file in the main package??");
				e.printStackTrace();
			}
			break;
		case 10:
			try {
				Image img = ImageIO.read(this.getClass().getResource("images/Pencil.gif"));
				g.drawImage(img, 13,3, null);
			} catch (IOException e) {
				System.out.println("There was an issue importing the Pencil!! is the file in the main package??");
				e.printStackTrace();
			}
			break;
		}

		ButtonPanel.getInstance().repaint();		//updates colors of icons
	}
}
