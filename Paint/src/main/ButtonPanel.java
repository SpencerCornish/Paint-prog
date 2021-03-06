package main;
/**
 * Paint Program
 * Authors:
 * 		Nate Tranel
 * 		Spencer Cornish
 * 		
 * 
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class ButtonPanel extends JPanel implements ActionListener { 

	private static final long serialVersionUID = -923758246107102096L;

	private final Cursor CRSHAIR = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR); 		// Crosshair cursor
	private final Cursor CDEF = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR); 				// Default cursor

	private final Dimension PREF = new Dimension(40,26); 						// The preferred button dimensions
	private final Dimension PREF2 = new Dimension(85, 26);

	public static ButtonPanel btnP; 		// Instance of Button Panel
	private JButton buttonClear; 			// Clear the screen
	private JButton buttonRectangleF; 		// Draw a Filled Rectangle
	private JButton buttonRectangleE; 		// Draw a Filled Rectangle
	private JButton buttonOvalF; 			// Draw a Filled Oval
	private JButton buttonOvalE; 			// Draw an Empty Oval 
	private JButton buttonLineD; 			// Draw a line
	private JButton buttonFree;				// Free-Draw a Line
	private JButton buttonOpt;				// Options Panel
	private JButton buttonErase;			// Options Panel



	public ButtonPanel() {
		buttonRectangleF = new JButton(new ButtonIcon(1));					//button 1
		add(buttonRectangleF);
		buttonRectangleF.setPreferredSize(PREF);
		buttonRectangleF.addActionListener(this);
		buttonRectangleF.setToolTipText("Draw a filled rectangle");

		buttonRectangleE = new JButton(new ButtonIcon(2)); 					//button 2
		add(buttonRectangleE);
		buttonRectangleE.setPreferredSize(PREF);
		buttonRectangleE.addActionListener(this);
		buttonRectangleE.setToolTipText("Draw an empty rectangle");

		buttonOvalF = new JButton(new ButtonIcon(3));						//button 3
		add(buttonOvalF);
		buttonOvalF.setPreferredSize(PREF);
		buttonOvalF.addActionListener(this);
		buttonOvalF.setToolTipText("Draw a filled oval");

		buttonOvalE = new JButton(new ButtonIcon(4));						//button 4
		add(buttonOvalE);
		buttonOvalE.setPreferredSize(PREF);
		buttonOvalE.addActionListener(this);
		buttonOvalE.setToolTipText("Draw an empty oval");

		buttonLineD = new JButton(new ButtonIcon(5));						//button 5
		add(buttonLineD); 
		buttonLineD.setPreferredSize(PREF);
		buttonLineD.addActionListener(this);  
		buttonLineD.setToolTipText("Draw a straight line");

		buttonFree = new JButton(new ButtonIcon(10));											//button 6
		add(buttonFree); 
		buttonFree.setPreferredSize(PREF);
		buttonFree.addActionListener(this);  
		buttonFree.setEnabled(false);
		buttonFree.setToolTipText("Free draw - Coming Soon!");


		buttonOpt = new JButton("Options");									//button 8
		add(buttonOpt);
		buttonOpt.setPreferredSize(PREF2);
		buttonOpt.addActionListener(this);
		buttonOpt.setEnabled(false);
		buttonOpt.setToolTipText("Change Line Thickness, etc.");


		buttonClear = new JButton("Clear");									//button 0
		add(buttonClear);
		buttonClear.setPreferredSize(PREF2);
		buttonClear.addActionListener(this);
		buttonClear.setToolTipText("Clear the canvas");		

		buttonErase = new JButton(new ButtonIcon(9));						//button 7
		add(buttonErase);
		buttonErase.setPreferredSize(PREF);
		buttonErase.addActionListener(this);
		buttonErase.setEnabled(false);
		buttonErase.setToolTipText("Erase Tool");

	}

	public static ButtonPanel getInstance()	//get instance of button panel
	{					
		if(btnP == null)
			btnP =  new ButtonPanel();
		return btnP; 
	}

	public void actionPerformed(ActionEvent ae) {
		MousePanel.getInstance().setCursor(CRSHAIR); 		//Sets the mouse Cursor to a Cross hair for editing

		if(ae.getSource() == buttonClear) {					//clears if user clicks clear button
			MousePanel.getInstance().setButton(0);
			MousePanel.getInstance().setCursor(CDEF);
			MousePanel.getInstance().clearAll(false);
			ColorPanel.getInstance().rstColors(true);
			Frame.getInstance().setStatus("Canvas Cleared!");
		}
		else if(ae.getSource() == buttonRectangleF) {
			MousePanel.getInstance().setButton(1);
			Frame.getInstance().setStatus("Filled Rectangle Tool");
		}
		else if(ae.getSource() == buttonRectangleE){ 
			MousePanel.getInstance().setButton(2);		//feeds button 2 (because it's a rectangle) to button variable in MousePanel class
			Frame.getInstance().setStatus("Empty Rectangle Tool");
		}
		else if(ae.getSource() == buttonOvalF) {
			MousePanel.getInstance().setButton(3);
			Frame.getInstance().setStatus("Filled Oval Tool");
		}
		else if(ae.getSource() == buttonOvalE) {
			MousePanel.getInstance().setButton(4);
			Frame.getInstance().setStatus("Empty Oval Tool");
		}
		else if(ae.getSource() == buttonLineD) {
			MousePanel.getInstance().setButton(5);
			Frame.getInstance().setStatus("Line Tool");
		}
		else if(ae.getSource() == buttonFree) {
			MousePanel.getInstance().setButton(6);
			Frame.getInstance().setStatus("Free Draw Tool");
		}
		else if(ae.getSource() == buttonOpt) {}	//coming soon!
		else if(ae.getSource() == buttonErase) {
			MousePanel.getInstance().setButton(7);
			Frame.getInstance().setStatus("Eraser Tool");
		}

	}
}

