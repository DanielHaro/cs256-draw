
public class MyPropertyChangeEvent {
	
	    //public void myPropertyChanged(MyPropertyChangeEvent ev);
	    
	   
	    String propertyName;
	    int oldValue;
	    int newValue;
	    
	    
	    MyPropertyChangeEvent(String pn, int ov, int nv )
	    
	    {
	    	
	    	propertyName = pn;
	    			oldValue = ov;
	    			newValue = nv;
	    	
	    	
	    	
	    }
	    
	    
	    
	    public String getPropertyName ( ){

	        return propertyName;

	     }

	     public Object getOldValue (){

	        return oldValue;

	     }

	     public Object getNewValue (){

	        return newValue;

	     }


	    
	    

}
