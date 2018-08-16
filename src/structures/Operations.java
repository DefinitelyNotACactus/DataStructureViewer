package structures;

public interface Operations {
    
    public boolean isEmpty();
            
    public boolean isFull();
    
    public int getSize();
    
    //public int setValueAtPosition(int position, Object value);
    
    public Object getValueAtPosition(int position);
    
    public Object remove(int position);
}
