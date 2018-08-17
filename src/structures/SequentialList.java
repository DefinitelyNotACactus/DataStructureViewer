package structures;

public class SequentialList<T> implements Operations {
    private T data[];
    private int size;
    private final int max_size;
    
    public SequentialList(){
        size = 0;
        max_size = 100;
        data = (T[]) new Object[max_size];
    }

    public SequentialList(int max_size){
        size = 0;
        this.max_size = max_size;
        data = (T[]) new Object[max_size];
    }
    
    @Override
    public boolean isEmpty(){
        return (size == 0);
    }

    @Override
    public boolean isFull(){
        return (size == max_size);
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public int getMaxSize(){
        return max_size;
    }
    
    private boolean isValidPosition(int position){
        return (position >= 1 && position <= size + 1);
    }
    
    public boolean setValueAtPosition(int position, T value){
        if(!isValidPosition(position) || isFull()){
            return false;
        } else {
                for(int i = size; i >= position; i--){
                    data[i] = data[i-1];
                }
                data[position-1] = value;
                size++;
                return true;
        }
    }

    @Override
    public T getValueAtPosition(int position){
        if(isValidPosition(position)){
            return data[position-1];
        } else {
            return null;
        }
    }

    @Override
    public T remove(int position){
        if(isEmpty() || !isValidPosition(position)){
            return null;
        } else {           
            T removed = data[position-1];
            for(int i = position-1; i < size-1; i++){
                data[i] = data[i+1];
            }
            data[size-1] = null;
            size--;
            return removed;
        }
    }
}
