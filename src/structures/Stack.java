package structures;

public class Stack<T> extends SequentialList<T> {

    private T[] data;
    private int top;
    private int size;

    public Stack() {
        top = -1;
        size = 0;
        data = (T[]) new Object[100];
    }

    public Stack(int maxSize) {
        top = -1;
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

    @Override
    public boolean isValidPosition(int position) {
        return (position >= 1 && position <= data.length);
    }

    public boolean push(T newElement) throws Exception {
        if (isFull()) {
            throw new Exception("The stack is full!");
        } else {
            top++;
            data[top] = newElement;
            size++;
            return true;
        }
    }

    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("The stack is empty!");
        } else {
            T aux = data[top];
            data[top] = null;
            top--;
            size--;
            return aux;
        }
    }

    @Override
    public boolean addValue(int position, T value) {
        return false;
    }
    
    @Override
    public T getValueAtPosition(int position) throws Exception {
        throw new Exception("only possible get the top value/position");
    }
    
    @Override
    public int getPositionByValue(T value) throws Exception {
        throw new Exception("only possible get the top value/position");
    }
    @Override
    public boolean setValueAtPosition(int position, T newValue) {
        return false;
    }
    @Override
    public T remove(int position) throws Exception {
        throw new Exception("only possible remove the top value");
    }
    @Override
    public int remove(T value) throws Exception {
        throw new Exception("only possible remove the top value");  
    }
}
