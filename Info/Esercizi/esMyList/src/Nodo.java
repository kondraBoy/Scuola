public class Nodo <T> {
    private T dato;
    private Nodo next;

    public Nodo getNext() {
        return next;
    }

    public T getDato() {
        return dato;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
