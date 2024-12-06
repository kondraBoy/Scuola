import java.util.LinkedList;

public class Coda<Ticket> {
    private LinkedList<Ticket> coda;
    private int maxSize;

    public Coda(int maxSize) {
        this.coda = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public void push(Ticket ticket) {
        if (isFull()) {
            System.out.println("La coda è piena, non posso aggiungere un altro ticket.");
        } else {
            coda.addLast(ticket);
        }
    }

    public Ticket pop() {
        if (isEmpty()) {
            System.out.println("La coda è vuota, non posso rimuovere un ticket.");
            return null;
        } else {
            return coda.removeFirst();
        }
    }

    public boolean isEmpty() {
        return coda.isEmpty();
    }


    public boolean isFull() {
        return coda.size() >= maxSize;
    }


    public Ticket getLast() {
        if (isEmpty()) {
            System.out.println("La coda è vuota, non posso ottenere l'ultimo ticket.");
            return null;
        } else {
            return coda.getLast();
        }
    }
}
