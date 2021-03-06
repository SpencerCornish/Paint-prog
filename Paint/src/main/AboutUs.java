package main;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class AboutUs implements ActionListener {
	
	private final Point BPOS = new Point(280,125);    	// Button Position
	private JLabel text;
	private JDialog about = new JDialog(null, "About", Dialog.ModalityType.APPLICATION_MODAL);
	private JButton bOkay = new JButton("OK");
	private Dimension prefS = new Dimension();  		// Preferred Button Dimension
	private Dimension prefT = new Dimension();
	private JLabel picLabel = new JLabel();
	public AboutUs() throws IOException
	{
		try {
			Image img = ImageIO.read(this.getClass().getResource("images/Icon.gif"));
			about.setIconImage(img);
		} catch (IOException e) {
			System.out.println("There was an issue importing my Logo!! is the file in the main package??");
			//e.printStackTrace();
		}
		about.setLayout(null);	// Decided to do manual alignment, since there were to be so few elements on a fixed size window

		BufferedImage pic = ImageIO.read(this.getClass().getResource("images/Logo.gif"));
		Image dPic = pic.getScaledInstance(180, 150, Image.SCALE_SMOOTH);
		picLabel = new JLabel(new ImageIcon(dPic));
		picLabel.setBounds(10, 10, 180, 150);
		about.add(picLabel);

		prefS = bOkay.getPreferredSize();
		bOkay.setBounds(BPOS.x, BPOS.y, prefS.width, prefS.height);
		bOkay.addActionListener(this);
		about.add(bOkay);

		text = new JLabel("N.S. Paint - Version 0.02");
		prefT = text.getPreferredSize();
		text.setBounds(200, 50, prefT.width, prefT.height);
		about.add(text);

		text = new JLabel("Copyright \u00a92016");
		prefT = text.getPreferredSize();
		text.setBounds(200, 70, prefT.width, prefT.height);
		about.add(text);

		text = new JLabel("All Rights Reserved.");
		prefT = text.getPreferredSize();
		text.setBounds(200, 90, prefT.width, prefT.height);
		about.add(text);

		about.setMinimumSize(new Dimension(370, 200));  	// Minimum Window Size
		about.setResizable(false);  					// Do not allow window resizing
		about.setLocationRelativeTo(null); 				// Centers About window on screen
		about.setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		about.dispose(); 								// Destroys the About window when OK is pressed
	}
}
