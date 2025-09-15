import java.util.NoSuchElementException;
@SuppressWarnings("all")
public class MyList<T extends Comparable<T> & FileCSV> {
    private Nodo<T> first;

    public MyList() {
        this.first = null;
    }

    public void add(T obj)
    {
        if(obj != null){
            Nodo<T> toAdd = new Nodo<>(obj);
            if(first== null)
                this.first = toAdd;
            else{
                Nodo<T> aus = first;
                Nodo<T> prec = null;
                boolean tro = false;
                while(aus != null && !tro){
                    if (obj.compareTo(aus.getDato()) < 0)
                        tro = true;
                    else{
                        prec = aus;
                        aus = aus.getNext();
                    }
                }
                if(prec == null){
                    Nodo<T> exFirst = first;
                    first = toAdd;
                    toAdd.setNext(exFirst);
                }
                else if(aus == null){
                    prec.setNext(toAdd);
                    toAdd.setNext(null);
                }
                else{
                    toAdd.setNext(aus);
                    prec.setNext(toAdd);
                }
            }
        }
        else
            throw new NullPointerException("Oggetto null non consentito");
    }

    public boolean contains(T obj) {
        boolean exists = false;
        Nodo<T> current = first;
        while (current != null) {
            if (current.getDato().equals(obj)) {
                exists = true;
            }
            current = current.getNext();
        }
        return exists;
    }

    public int size() {
        int size = 0;
        Nodo<T> current = first;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }
    public void addFirst(T obj) {
        Nodo<T> newNode = new Nodo<>(obj);
        if (first != null) {
            newNode.setNext(first);
        }
        first = newNode;
    }

    public void addLast(T obj) {
        add(obj);
    }

    public void clear(){
        first = null;
    }

    public T element() {
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        return first.getDato();
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

    public void remove(T dato){
        if (first == null) {
            throw new NoSuchElementException("List is empty");
        }
        if (first.getDato().equals(dato)) {
            first = first.getNext();
        } else {
            Nodo<T> current = first;
            while (current.getNext() != null && !current.getNext().getDato().equals(dato)) {
                current = current.getNext();
            }
            if (current.getNext() == null) {
                throw new NoSuchElementException("Element not found");
            }
            current.setNext(current.getNext().getNext());
        }
    }

    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index is negative");
        }
        Nodo<T> current = first;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index is greater than list size");
            }
            current = current.getNext();
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index is greater than list size");
        }
        return current.getDato();
    }
}