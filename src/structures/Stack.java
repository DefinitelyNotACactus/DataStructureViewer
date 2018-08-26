package structures;

public class Stack<T> {

    private T[] data;
    private int top;
    private int size;

    public Stack() {
        top = 0;
        size = 0;
        data = (T[]) new Object[100];
    }

    public Stack(int maxSize) {
        top = 0;
        size = 0;
        data = (T[]) new Object[maxSize];
    }

    public int getTop() throws Exception {
        if (isEmpty()) {
            throw new Exception("The stack is empty!");
        } else {
            return top;

        }
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
    
    public boolean isValidPosition(int position) {
        return (position >= 1 && position <= data.length);
    }

    public boolean push(T newElement) throws Exception {
        if (isFull()) {
            throw new Exception("The stack is full!");
        } else {
            data[top] = newElement;
            top++;
            size++;
            return true;
        }
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("The stack is empty!");
        } else {
            top--;
            T aux = data[top];
            data[top] = null;      
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
