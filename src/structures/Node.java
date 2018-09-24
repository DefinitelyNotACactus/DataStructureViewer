package structures;

public class Node<T> {
    
    private Node next;
    private T value;
    
    public Node(T value) {
        next = null;
        this.value = value;
    }
    
    public void setValue(T value) {
        this.value = value;
    }
    
    public T getValue() {
        return value;
    }
    
    public boolean hasNext(){
        return (next != null);
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public Node getNext() {
       return next;
    }
}
