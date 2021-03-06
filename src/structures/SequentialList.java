package structures;

import java.util.Timer;
import java.util.TimerTask;
import view.Constants;
import view.SequentialListViewer;

public class SequentialList<T> implements Operations<T> {

    private T data[];
    private int size;
    private SequentialListViewer view;
    
    /**
     * Creates a new sequential list with default capacity (100).
     */
    public SequentialList(){
        size = 0;
        data = (T[]) new Object[100];
    }

    /**
     * Creates a new sequential list with the given capaciticy.
     * @param view
     * @param maxSize The list maximum capacity.
     */
    public SequentialList(SequentialListViewer view, int maxSize){
        size = 0;
        data = (T[]) new Object[maxSize];
        this.view = view;
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
            throw new Exception(Constants.PORTUGUESE ? "Posi��o Inv�lida!" : "Invalid Position!");
        } else if (isFull()){
            throw new Exception(Constants.PORTUGUESE ? "A lista est� cheia!" : "The list is full!");
        } else {
            new Timer().scheduleAtFixedRate(new TimerTask(){
                int i = size;
                @Override
                public void run(){
                    if(i >= position){
                        data[i] = data[i-1];
                        view.listElements(i, true);
                        i--;
                    } else {
                        data[position-1] = value;
                        size++;
                        view.listElements(position, true);
                        cancel();
                    }
                }
            }, 1000, 1000);     
            return true;
        }
    }

    @Override
    public T getValueAtPosition(int position) throws Exception {
        if(isValidPosition(position)){
            return data[position-1];
        } else {
            throw new Exception(Constants.PORTUGUESE ? "Posi��o Inv�lida" : "Invalid Position");
        }
    }

    @Override
    public int getPositionByValue(T value) throws Exception {
        for(int i = 0; i < size; i++){
            if(value == data[i]){
                return i+1;
            }
        }
        throw new Exception("" + value + (Constants.PORTUGUESE ? " n�o est� na lista!" : " is not on the list!"));
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
            throw new Exception(Constants.PORTUGUESE ? "A lista est� vazia" : "The list is empty");
        } else if(!isValidPosition(position)){
            throw new Exception(Constants.PORTUGUESE ? "Posi��o Inv�lida" : "Invalid Position");
        } else {
            T removed = data[position-1];
            new Timer().scheduleAtFixedRate(new TimerTask(){
                int i = position-1;
                @Override
                public void run(){
                    if(i < size-1){
                        data[i] = data[i+1];
                        view.listElements();
                        i++;
                    } else {
                        data[size-1] = null;
                        size--;
                        view.listElements();
                        cancel();
                    }
                }
            }, 1000, 1000);
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
