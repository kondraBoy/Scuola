public class Nodo <T> {
    private T dato;
    private Nodo next;

    public Nodo(T obj) {
        setDato(obj);
        setNext(null);
    }

    private void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public T getDato() {
        return dato;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public void setNode(Nodo<T> newNode) {

    }


}
