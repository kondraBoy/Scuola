import java.util.LinkedList;

public class Pila <T> {
    private LinkedList<T> pila;
    private int maxSize;

    public Pila(int maxSize) {
        this.pila = new LinkedList<>();
        this.maxSize = maxSize;
    }
    public Pila(){
        this.pila = new LinkedList<>();
        this.maxSize = Integer.MAX_VALUE;
    }

    private void setNmax(int maxSize){
        if(maxSize > pila.size())
            this.maxSize = maxSize;
        else
            throw new IllegalArgumentException("");
    }

    public void push() {
        if (isFull()) {
            throw new IllegalStateException("pila piena");
        } else {

        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("pila vuota");
        } else {
            return pila.removeLast();
        }
    }

    public boolean isEmpty() {
        return pila.isEmpty();
    }


    public boolean isFull() {
        return pila.size() >= maxSize;
    }


    public T getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila è vuota, quindi non esistono elementi");
        } else {
            return pila.getLast();
        }
    }
}

