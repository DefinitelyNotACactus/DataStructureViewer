package structures;

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
    public boolean addValue(int pos, T value) throws Exception {
        if (!isValidPosition(pos)) {
            throw new Exception("Invalid Position!");
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
            throw new Exception("Invalid Position!");
        }
        while (con < pos) {
            aux = aux.getNext();
            con++;
        }
        return aux.getValue();
    }

    public Node getNodeAtPosition(int pos) throws Exception {
        int con = 1;
        Node<T> aux = head;
        if (!isValidPosition(pos)) {
            throw new Exception("Invalid Position!");
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

    @Override
    public T remove(int pos) throws Exception {
        int cont = 1;
        Node<T> aux = head;
        Node<T> aix = null;
        if(isEmpty()){
            throw new Exception("The list is empty");
        } else if(!isValidPosition(pos)) {
            throw new Exception("Invalid Position!");
        } else {
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
    }

    @Override
    public int remove(T value) throws Exception {
        int pos = getPositionByValue(value);
        remove(pos);
        return pos;
    }
}
