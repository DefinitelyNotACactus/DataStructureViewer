package structures;

public class Heap {
    private int data[];
    private int currentSize;
    private int maxSize;
    private boolean min;
    
    public Heap(boolean min) {
        this.min = min;
        maxSize = 50;
        currentSize = 0;
        data = new int[maxSize];
    }
    
    public boolean isFull() {
        return currentSize == maxSize;
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    public int getMaxSize() {
        return maxSize;
    }
    
    public int getSize() {
        return currentSize;
    }
    
    public boolean insert(int value) {
        if(isFull()) {
            return false;
        }
        data[currentSize] = value;
        int i = currentSize;
        while(i > 0 && compare(data[getParent(i)], data[i]) > 0) {
            swap(i, getParent(i));
            i = getParent(i);
        }
        currentSize++;
        return true;
    }
    
    public int remove() {
        if(isEmpty()) {
            return -1;
        }
        int removed = data[0];
        currentSize--;
        data[0] = data[currentSize];
        reorder(0);
        return removed;
    }
    
    private void reorder(int index) {
        int leftChild = getLeftChild(index),
        rightChild = getRightChild(index),
        lesser = index;
        if(leftChild < currentSize && compare(data[leftChild], data[index]) < 0) {
            lesser = leftChild;
        }
        if(rightChild < currentSize && compare(data[rightChild], data[leftChild]) < 0) {
            lesser = rightChild;
        }
        if(lesser != index) {
            swap(index, lesser);
            reorder(lesser);
        }
    }
    
    private void swap(int indexA, int indexB) {
        int aux = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = aux;
    }
    
    private int compare(int a, int b) {
        if(min) {
            return a - b;
        } else {
            return b - a;
        }
    }
    
    private int getParent(int x) {
        return (x - 1)/2;
    }
    
    private int getLeftChild(int x) {
        return 2 * x + 1;
    }
    
    private int getRightChild(int x) {
        return 2 * x + 2;
    }
}
