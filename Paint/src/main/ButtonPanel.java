package main;


import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Hunter Lloyd
 */
public class ButtonPanel extends JPanel implements ActionListener {

    public static ButtonPanel btnPnl; // Instance of Button Panel
    private JButton buttonClear; // Clear the screen
    private JButton buttonRectangleF; // Draw a Filled Rectangle
    private JButton buttonRectangleE; // Draw a Filled Rectangle
    private JButton buttonOvalF; // Draw a Filled Oval
    private JButton buttonOvalE; // Draw an Empty Oval 
    private JButton buttonLineD; // Draw a line

    ButtonPanel()
    {
        setBackground(Color.GRAY);
        buttonClear = new JButton("Clear");
        buttonRectangleF = new JButton("Filled Rectangle");
        buttonRectangleE = new JButton("Rectangle");
        buttonOvalF = new JButton("Filled Rectangle");
        buttonOvalE = new JButton("Filled Rectangle");
        buttonLineD = new JButton("Line");
        add(buttonLineD);
        add(buttonOvalE);
        add(buttonOvalF);
        add(buttonRectangleE);
        add(buttonRectangleF);
        add(buttonClear);
        buttonClear.addActionListener(this);
        buttonRectangleF.addActionListener(this);
        
    }
     public static ButtonPanel getInstance()
    {
        if(btnPnl == null)
           btnPnl =  new ButtonPanel();
        return btnPnl;
    }

     public void actionPerformed(ActionEvent ae)
     {
         System.out.println(ae.getActionCommand());
         if(ae.getSource() == buttonClear)
         {
        	 System.out.println("Holy cow! we detected something right! :)");
        	 
         
         }
         MousePanel.getInstance().repaint();
     }
}