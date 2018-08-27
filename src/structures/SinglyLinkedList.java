/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author Gabriel Arnaud
 */
public class SinglyLinkedList<T> implements Operations<T> {

    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
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
        return (pos >= 1 && pos <= size + 1);
    }

    @Override
    public boolean addValue(int pos, T value) {
        if (!isValidPosition(pos)) {
            return false;
        }
        if (pos == 1) {
            return addValueAtBeggining(value);
        } else if (pos == size + 1) {
            return addValueAtEnding(value);
        } else {
            return addValueAtMiddle(pos, value);
        }
    }

    @Override
    public T getValueAtPosition(int pos) throws Exception {
        int con = 1;
        Node<T> aux = head;
        if (!isValidPosition(pos)) {
            return null;
        }
        while (con < pos) {
            aux = aux.getNext();
            con++;
        }
        return aux.getValue();
    }

    public Node getNodeAtPosition(int pos) {
        int con = 1;
        Node<T> aux = head;
        if (!isValidPosition(pos)) {
            return null;
        }
        while (con < pos) {
            aux = aux.getNext();
            con++;
        }
        return aux;
    }

    @Override
    public int getPositionByValue(T value) throws Exception {
        int con = 1;
        Node<T> aux = head;
        while (con <= size) {
            if (aux.getValue() == value) {
                break;
            }
            aux = aux.getNext();
            con++;
        }
        if (aux.getValue() != value && con == size) {
            throw new Exception("" + value + " is not on the list");
        }
        return con;
    }

    public boolean addValueAtBeggining(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(head);
        head = newNode;
        size++;
        return true;
    }

    public boolean addValueAtEnding(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(null);
        Node<T> aux = head;
        while (aux.getNext() != null) {
            aux = aux.getNext();
        }
        aux.setNext(newNode);
        size++;
        return true;
    }

    public boolean addValueAtMiddle(int pos, T value) {
        Node<T> newNode = new Node<>(value);
        Node<T> aux = head;
        int i = 1;
        while (i != pos - 1) {
            aux = aux.getNext();
            i++;
        }
        newNode.setNext(aux.getNext());
        aux.setNext(newNode);
        size++;
        return true;
    }

    @Override
    public boolean setValueAtPosition(int position, T newValue) {
        if (isValidPosition(position)) {
            Node<T> aux = head;
            for (int i = 0; i < position - 1; i++) {
                aux = aux.getNext();
            }
            aux.setValue(newValue);
            return true;
        } else {
            return false;
        }
    }

    public T remove(int pos) throws Exception {
        int cont = 1;
        Node<T> aux = head;
        Node<T> aix = null;
        if (!isValidPosition(pos)) {
            return null;
        }
        if (pos != 1) {
            while (cont < pos) {
                aix = aux;
                aux = aux.getNext();
                cont++;
            }
            aix.setNext(aux.getNext());
            size--;
            return aux.getValue();
        } else {
            head = aux.getNext();
            size--;
            return aux.getValue();
        }
    }

    public int remove(T value) throws Exception {
        int pos = getPositionByValue(value);
        remove(pos);
        return pos;
    }

}
