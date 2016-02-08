package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image.*;
import java.awt.Point;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;


public class MousePanel extends JPanel implements MouseListener, MouseMotionListener {
    
	private static final long serialVersionUID = -8595660419538273421L;
	public static MousePanel mouseP; 				//Instance of the MousePanel
    private int button = -1;						//determines which button is pressed based on a number
    private Point sPoint = new Point(-1, -1);  				//Points used to align shapes and mouse drag
    private Point ePoint = new Point(-1, -1);
    private BufferedImage bufferImg;
    private Graphics g;
    public MousePanel() {
        
    	
    	//setDoubleBuffered(false);       
        //addMouseListener(new MouseAdapter() {
          //public void mousePressed(MouseEvent e) {
            // save coord when mouse is pressed
         // sPoint.x = e.getX();
           // sPoint.y = e.getY();
        //  }
       // });
    	bufferImg = new BufferedImage(1000,1000, BufferedImage.TYPE_INT_RGB);
    	Graphics buffer = bufferImg.getGraphics();
    	buffer.setColor(Color.ORANGE);
    	buffer.fillRect(0, 0, bufferImg.getWidth(),bufferImg.getHeight());
        addMouseListener(this); 				//Used to do live track, etc.
        addMouseMotionListener(this); 
        repaint();
    }
    public static MousePanel getInstance()
    {
        if(mouseP == null) 						// If there is no instance...
            mouseP =  new MousePanel(); 		// Make one!
         return mouseP; 						// Send back the made instance
        
    }

    public void paintComponent(Graphics g)
    {
    	g.drawImage(bufferImg, 0, 0, getWidth(), getHeight(), null);
    }
    
    public void setButton(int button) {  			// Sets our button tracking variable
    	this.button = button;

    	//buffer.fillRect(30,30, 300, 100);
    	//repaint();
    	//ePoint.x = 20; 						//Cleans line tracking variables for next line made
    	//ePoint.y = 20;
        //sPoint.x = 200;  
        //sPoint.y = 200;
    }
    public void mousePressed(MouseEvent e){			// Initial coords for shape
    	System.out.println("mouse pressed");
    	e.consume();
        sPoint.x = e.getX();  
        sPoint.y = e.getY();
    	}
    public void mouseReleased(MouseEvent e){		//Final coords for shape
    	System.out.println("mouse released");
    	Graphics buffer = bufferImg.createGraphics();
    	buffer.setColor(Color.RED);
    	e.consume();  
        ePoint.x = e.getX();  
        ePoint.y = e.getY();
        switch(button){   						// Switch on which button was pressed.  There may be a better way
        case 0: 
        	buffer.setColor(Color.WHITE);
        	buffer.fillRect(0, 0, 500, 500);
        	repaint();
            break;  // The following shapes have weird offsets,as to make the dragging of a shape feel less insane!
        case 1: buffer.fillRect(sPoint.x, sPoint.y, ePoint.x-sPoint.x, ePoint.y-sPoint.y); repaint(); break;		// Draw filled rectangle
        case 2: buffer.drawRect(sPoint.x, sPoint.y, ePoint.x-sPoint.x, ePoint.y-sPoint.y); repaint(); break; 		// Draw empty rectangle
        case 3: buffer.fillOval(sPoint.x, sPoint.y, ePoint.x-sPoint.x, ePoint.y-sPoint.y); repaint(); break; 		// Draw filled oval
        case 4: buffer.drawOval(sPoint.x, sPoint.y, ePoint.x-sPoint.x, ePoint.y-sPoint.y); repaint(); break;		// Draw empty oval
        case 5: buffer.drawLine(sPoint.x, sPoint.y, ePoint.x, ePoint.y); repaint(); break; 							// Draw Line */
        }
    	}
	public void mouseDragged(MouseEvent e) { 		//makes the shape a live-drag
    	//e.consume();  
        //ePoint.x = e.getX();  
       // ePoint.y = e.getY();
        System.out.println(e.getY() + " x " + e.getX());
       // repaint();
		}
	public void mouseMoved(MouseEvent e) { } //This will be useful soon, adding mouse coords to a tooltip in the bottom right corner    
	public void mouseExited(MouseEvent e){//System.out.println("mouse exited");
		}
    public void mouseEntered(MouseEvent e){//System.out.println("mouse entered");
    	}
    public void mouseClicked(MouseEvent e){//System.out.println("mouse clicked");
    }
}
