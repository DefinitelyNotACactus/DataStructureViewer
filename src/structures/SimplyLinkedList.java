/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

/**
 *
 * @author aluno
 */
public class SimplyLinkedList<T> implements Operations<T>  {
    private Node<T> head;
    private int size;
    
    public SimplyLinkedList(){
    head = null;
    size = 0;
    }

    @Override
    public boolean isEmpty() {
     return(size == 0);
    }

    @Override
    public boolean isFull() {
       return false; 
    }

    @Override
    public int getSize() {
       return size;
    }

    @Override
    public int getMaxSize() {
        return size;
    }

    @Override
    public boolean isValidPosition(int pos) {
    return(pos>0 && pos<=size);    
    }

    @Override
    public boolean addValue(int pos, T value) {
        if(!isValidPosition(pos)){
            return false;
        }     
        if(pos == 1){
         return addValueAtBeggining(value);
        }
        else{
        if(pos == size + 1){
         return addValueAtEnding(value);
        }
        else{
         return addValueAtMiddle(pos ,value);
        }
        }
       
    }

    @Override
    public T getValueAtPosition(int pos)  throws Exception {
      int con = 1;
      Node<T> aux = head;
      if(!isValidPosition(pos)){
            return null;
        } 
      while(con < pos){
      aux = aux.getNext();
      con++;
      }
      return aux.getValue();
    }

    @Override
    public int getPositionByValue(T value) throws Exception {
      int con = 1;
      Node<T> aux = head; 
     while(con <= size){
     if(aux.getValue() == value){
     break;
     }    
     aux = aux.getNext();
     con++;
     }
     if(aux.getValue() != value && con == size){
         throw new Exception("" + value + " is not on the list");
     }
     return con;
    }

    
    public boolean addValueAtBeggining(T value){
     Node<T> newNode = new Node<>();
     newNode.setNext(head);
     head.setNext(newNode);
     return true;
    }
    
    public boolean addValueAtEnding(T value){
     Node<T> newNode = new Node<>();
     newNode.setNext(null);
      Node<T> aux = head;
     while(aux.getValue()!= null){
     aux = aux.getNext();
     }
     aux.setNext(newNode);
     return true;
    }
    
    public boolean addValueAtMiddle(int pos,T value){
     Node<T> newNode = new Node<>();
     Node<T> aux = head;
     int i = 1;
     while(i != pos - 1){
    aux = aux.getNext();
    i++;  
    }
     newNode.setNext(aux.getNext().setNext(aux));
     aux
     return true;
    }
    
    @Override
    public boolean setValueAtPosition(int position, T newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(int position) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int remove(T value) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
