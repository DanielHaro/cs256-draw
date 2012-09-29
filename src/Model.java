import java.beans.PropertyChangeEvent;
import java.util.Vector;



public class Model implements MyPropertyChangeListner {

	 private int recLength;
	 private int recWidth;
	 private Vector<MyPropertyChangeListner> mypropertyChangeListners = new Vector <MyPropertyChangeListner>();
	 
//public Model()
//{}

public Model (int l, int w)
{
	 recLength = l;
	 recWidth =  w;
	  	

}
	 

	 
public int getRecLength()
{return recLength;}

public void setRecLength (int recLength) 

{
    MyPropertyChangeEvent ev = new MyPropertyChangeEvent ("length",this.recLength,recLength);
   //fireMyPropertyChange(ev);
    this.recLength = recLength;
    fireMyPropertyChange(ev);
    System.out.println("UPdating model" + this.recLength);
    
}


public int getRecWidth()
{return recWidth;}

public void setRecWidth (int recWidth) {

    

	MyPropertyChangeEvent ev = new MyPropertyChangeEvent ("Width",this.recWidth,recWidth);
    //fireMyPropertyChange(ev);
    this.recWidth = recWidth;
    fireMyPropertyChange(ev);
    System.out.println("updating model" + this.recWidth);
    
}




//public synchronized void addMyPropertyChangeListner(MyPropertyChangeListner l){
	//  if(!myPropertyChangeListners.conains(l))
		//  myPropertyChangeListners.addElement(l);
	  
	
	


	 public synchronized void addMyPropertyChangeListner(MyPropertyChangeListner l)
	{ 
		 if(!mypropertyChangeListners.contains(l))
		 mypropertyChangeListners.addElement(l);
		 
		 
		 
	}
	
	
	public synchronized void removeMyPropertyChangeListner(MyPropertyChangeListner l)
	{
		 if(mypropertyChangeListners.contains(l))
			mypropertyChangeListners.removeElement(l);
		
	}


	
	public synchronized void fireMyPropertyChange(MyPropertyChangeEvent ev)
	{
		
		System.out.println("fire the views a");
		for(int i = 0 ; i < mypropertyChangeListners.size(); i++)
		{
			System.out.println("fire the views b");	
			((MyPropertyChangeListner)mypropertyChangeListners.elementAt(i)).myPropertyChanged(ev);
			
		}
			
		
		
	}

	

	@Override
	public void myPropertyChanged(MyPropertyChangeEvent textView1) {
		// TODO Auto-generated method stub
		
	}
	
	//@Override
	//public void myPropertyChanged(PropertyChangeEvent ev) {
		// TODO Auto-generated method stub
		
	//}
	
}
