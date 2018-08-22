package structures;

public class SequentialList<T> implements Operations<T> {

    private T data[];
    private int size;
    private final int max_size;
    
    /**
     * Creates a new sequential list with default capacity (100).
     */
    public SequentialList(){
        size = 0;
        max_size = 100;
        data = (T[]) new Object[max_size];
    }

    /**
     * Creates a new sequential list with the given capaciticy.
     * @param max_size The list maximum capacity.
     */
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
    
    @Override
    public boolean isValidPosition(int position){
        return (position >= 1 && position <= size + 1);
    }
    
    @Override
    public boolean addValue(int position, T value){
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
    public T getValueAtPosition(int position) throws Exception {
        if(isValidPosition(position)){
            return data[position-1];
        } else {
            throw new Exception("Invalid Position");
        }
    }

    @Override
    public int getPositionByValue(T value) throws Exception {
        for(int i = 0; i < size; i++){
            if(value == data[i]){
                return i+1;
            }
        }
        throw new Exception("" + value + " is not on the list!");
    }
    
    @Override
    public boolean setValueAtPosition(int position, T newValue) {
        if(isValidPosition(position)){
            data[position-1] = newValue;
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public T remove(int position) throws Exception {
        if(isEmpty()){
            throw new Exception("The list is empty");
        } else if(!isValidPosition(position)){
            throw new Exception("Invalid Position");
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
    
    @Override
    public int remove(T value) throws Exception {
        int position = getPositionByValue(value);
        if(position != 0){
            remove(position);
        }
        return position;
    }
}
