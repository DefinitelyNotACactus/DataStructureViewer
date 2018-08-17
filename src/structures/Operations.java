package structures;

public interface Operations {
    
    public boolean isEmpty();
            
    public boolean isFull();
    
    public int getSize();
    
    public int getMaxSize();
    
    //public boolean setValueAtPosition(int position, Object value);
    
    public Object getValueAtPosition(int position);
    
    //public int getPositionByValue(Object value);
    
    public Object remove(int position);
}
