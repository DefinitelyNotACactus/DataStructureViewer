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
public class Node<T> {
    Node next;
    T value;
    
    public Node()
    {
    next = null;
    }
    
    public void setValue(T value)
    {
      this.value = value;
    }
    
    public T getValue()
    {
    return value;
    }
    
    public void setNext(Node next)
    {
      this.next = next;
    }
    
    public Node getNext()
    {
    return next;
    }
}
