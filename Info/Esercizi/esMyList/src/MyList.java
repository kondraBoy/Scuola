import java.util.NoSuchElementException;

public class MyList<T> {
    private Nodo<T> first;

    public MyList() {
        this.first = null;
    }

    public boolean add(T obj) {
        if (obj == null) {
            throw new NullPointerException("Not accepted null object");
        } else {
            Nodo<T> newNode = new Nodo<>(obj);
            if (first == null) {
                this.first = newNode;
            } else {
                Nodo<T> current = first;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        }
        return true;
    }

    public boolean contains(T obj) {
        Nodo<T> current = first;
        while (current != null) {
            if (current.getDato().equals(obj)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void addFirst(T obj) {
        Nodo<T> newNode = new Nodo<>(obj);
        if (first == null) {
            first = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
    }

    public void addLast(T obj) {
        add(obj);
    }

    public void clear(){
        first = null;
    }

    public T element(int index) {
        Nodo<T> current = first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.getDato();
            }
            count++;
            current = current.getNext();
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        return first.getDato();
    }

    public T getLast() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        Nodo<T> current = first;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getDato();
    }

    public T remove(){
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        T removedElement = first.getDato();
        first = first.getNext();
        return removedElement;
    }

    public T removeLast(){
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        if (first.getNext() == null) {
            T removedElement = first.getDato();
            first = null;
            return removedElement;
        }
        Nodo<T> current = first;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        T removedElement = (T) current.getNext().getDato();
        current.setNext(null);
        return removedElement;
    }

}