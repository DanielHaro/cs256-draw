import java.beans.PropertyChangeEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class DrawView extends JPanel implements MyPropertyChangeListner, MouseMotionListener,MouseListener{
	
	
    private int xSaved;
    private int ySaved;
	private Model model;
	private int xCoor;
	private int yCoor;

	/**
	 * Create the panel.
	 */
	public DrawView() {
		setBackground(Color.YELLOW);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
            //model.addMyPropertyChangeListner(this);
	}

	
public void paintComponet (Graphics g) {
	
	System.out.println("painting");
	super.paintComponent(g);
	int len = model.getRecLength();
	int wid = model.getRecWidth();
	//g.drawRect(xCoor,yCoor, len, wid);
	g.drawRect(Math.min(xSaved, model.getRecLength()+ xSaved),
            Math.min(ySaved, model.getRecWidth()+ ySaved),
            Math.abs( model.getRecLength()),
            Math.abs(model.getRecWidth()));

	
}
	
	
	public void setModel(Model model) {

	       this.model = model;

	       model.addMyPropertyChangeListner(this);

	       this.addMouseListener(this);

	       this.addMouseMotionListener(this);       

	       
	       
	       //this.removeMouseListener(this);

	     //this.addMouseMotionListener(this);       

	    }


		@Override
		public void myPropertyChanged(MyPropertyChangeEvent ev) {

		       this.repaint();
				repaint();
		       

		    }


		@Override
		public void mouseDragged(MouseEvent ev) {
			
			System.out.println("dragging");
			int newXCoor = ev.getX();
			int newYCoor = ev.getY();
			int length = newXCoor  - xCoor;
			if (length < 0)
				length = length * -1;
	        model.setRecLength(length);
	        int width = newYCoor - yCoor;
	        if (width < 0)
				width = width * -1;
	        
	        model.setRecWidth(width);
	        
		}


		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			repaint();
			
		}


		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mousePressed(MouseEvent ev) {
			xCoor = ev.getX();
			yCoor = ev.getY();
			System.out.println(xCoor);
			System.out.println(yCoor);
			repaint();
			
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			repaint();
			
		}





		



	
	
	
//	public void setModel(Model model){
		
	//	this.model = model;
		//model.addMyPropertyChangeListner(this);
		
		
//	}
	
	
	
}
