import java.beans.PropertyChangeEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;


public class TextView1 extends JPanel implements MyPropertyChangeListner, ActionListener{
	private JTextField jtfRecWidth;
	private JTextField jtfRecLength;
    private Model model;
	/**
	 * Create the panel.
	 */
	public TextView1() {
		setForeground(new Color(0, 0, 139));
		setBackground(new Color(127, 255, 212));
		
		JLabel lblNewLabel_1 = new JLabel("Length");
		add(lblNewLabel_1);
		
		jtfRecLength = new JTextField();
		jtfRecLength.setFont(new Font("Tahoma", Font.PLAIN, 11));
		jtfRecLength.setText("0");
		add(jtfRecLength);
		jtfRecLength.setColumns(10);
		jtfRecLength.addActionListener(this);
		
		
		JLabel lblNewLabel = new JLabel("Width");
		add(lblNewLabel);
		
		jtfRecWidth = new JTextField();
		jtfRecWidth.setText("0");
		add(jtfRecWidth);
		jtfRecWidth.setColumns(10);
        jtfRecWidth.addActionListener(this);
        
	}
	public void myPropertyChanged(PropertyChangeEvent ev){}
	
public void setModel(Model model){
		
		this.model = model;
		model.addMyPropertyChangeListner(this);
 
}



@Override
public void myPropertyChanged(MyPropertyChangeEvent ev)
{
	
	System.out.println("text view prop change");
   if(ev.getPropertyName().equalsIgnoreCase("length"))
   
   { jtfRecLength.setText(""+ev.getNewValue());  }
                           
   else if (ev.getPropertyName().equalsIgnoreCase("width")) 
   		{jtfRecWidth.setText(""+ev.getNewValue());}


}


public void actionPerformed(ActionEvent ev)
{
	System.out.println("fire");
    String sLen = jtfRecLength.getText().trim();
    int len = Integer.parseInt(sLen);
    jtfRecLength.setText("");
    model.setRecLength(len);
   // model.fireMyPropertyChange(ev)
    System.out.println("fire");
    
     sLen = jtfRecWidth.getText().trim();
    int width = Integer.parseInt(sLen);
    jtfRecWidth.setText("");
    model.setRecWidth(width);
    //model.myPropertyChanged(ev);
}

}


