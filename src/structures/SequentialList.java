package structures;

import java.io.Serializable;
import view.Constants;

public class SequentialList<T> implements Operations<T>, Serializable{

    private T data[];
    private int size;
    
    /**
     * Creates a new sequential list with default capacity (100).
     */
    public SequentialList(){
        size = 0;
        data = (T[]) new Object[100];
    }

    /**
     * Creates a new sequential list with the given capaciticy.
     * @param maxSize The list maximum capacity.
     */
    public SequentialList(int maxSize){
        size = 0;
        data = (T[]) new Object[maxSize];
    }
    
    @Override
    public boolean isEmpty(){
        return (size == 0);
    }

    @Override
    public boolean isFull(){
        return (size == data.length);
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public int getMaxSize(){
        return data.length;
    }
    
    @Override
    public boolean isValidPosition(int position){
        return (position >= 1 && position <= size + 1);
    }
    
    @Override
    public boolean addValue(int position, T value) throws Exception {
        if(!isValidPosition(position)){
            throw new Exception(Constants.PORTUGUESE ? "Posição Inválida!" : "Invalid Position!");
        } else if (isFull()){
            throw new Exception(Constants.PORTUGUESE ? "A lista está cheia!" : "The list is full!");
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
            throw new Exception(Constants.PORTUGUESE ? "Posição Inválida" : "Invalid Position");
        }
    }

    @Override
    public int getPositionByValue(T value) throws Exception {
        for(int i = 0; i < size; i++){
            if(value == data[i]){
                return i+1;
            }
        }
        throw new Exception("" + value + (Constants.PORTUGUESE ? " não está na lista!" : " is not on the list!"));
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
            throw new Exception(Constants.PORTUGUESE ? "A lista está vazia" : "The list is empty");
        } else if(!isValidPosition(position)){
            throw new Exception(Constants.PORTUGUESE ? "Posição Inválida" : "Invalid Position");
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
