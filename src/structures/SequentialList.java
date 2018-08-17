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
    
    public int setValueAtPosition(int position, T value){
        if(isFull()){
            return 0;
        } else if(!isValidPosition(position)){
            return -1;
        } else {
            if(position == size + 1){
                data[position-1] = value;
                size++;
                return 1;
            } else {
                for(int i = size-1; i >= position; i--){
                    data[i] = data[i-1];
                }
                data[position-1] = value;
                size++;
                return 1;
            }
        }
    }

    @Override
    public T getValueAtPosition(int position){
        return data[position-1];
    }

    @Override
    public T remove(int position){
        if(isEmpty() || !isValidPosition(position)){
            return null;
        } else {           
            for(int i = position-1; i <= max_size; i++){
                data[i] = data[i+1];
            }
            size--;
            return data[position-1];
        }
    }
}
