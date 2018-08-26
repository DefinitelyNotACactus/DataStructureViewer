package structures;

public class Queue<T> {
    
    private T[] data;
    private int start;
    private int end;
    private int size;
    
    public Queue() {
        start = 0;
        end = -1;
        size = 0;
        data = (T[]) new Object[100];
    }
    
    public Queue(int maxSize) {
        start = 0;
        end = -1;
        size = 0;
        data = (T[]) new Object[maxSize];
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public boolean isFull() {
        return (size == data.length);
    }
    
    public int getSize() {
        return size;
    }
    
    public int getMaxSize() {
        return data.length;
    }
    
    public int getStart(){
        return start;
    }
    
    public int getEnd(){
        return end;
    }
    
    public boolean isValidPosition(int position){
        return (position >= 1 && position <= data.length);
    }
        
    public T getFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("The queue is empty!");
        } else {
            return data[start];   
        }
    }
    
    public boolean enqueue(T newElement) throws Exception {
        if(isFull()){
            throw new Exception("The queue is full!");
        } else {
            end = (end + 1) % data.length;
            data[end] = newElement;          
            size++;
            return true;
        }
    }
    
    public T dequeue() throws Exception {
        if(isEmpty()){
            throw new Exception("The queue is empty!");
        } else {
            T aux = data[start];
            data[start] = null;
            start = (start + 1) % data.length;
            size--;
            return aux;
        }
    }
    
    public T getValueAtPosition(int position) throws Exception {
        if(isValidPosition(position)){
            return data[position-1];
        } else {
            throw new Exception("Invalid Position");
        }
    }
}
