import java.util.LinkedList;

public class Coda {
    private LinkedList<Ticket> coda;
    private int maxSize;

    public Coda(int maxSize) {
        this.coda = new LinkedList<>();
        this.maxSize = maxSize;
    }
    public Coda(){
        this.coda = new LinkedList<>();
        this.maxSize = 5;
    }

    public void push() {
        if (isFull()) {
            throw new IllegalStateException("Coda piena");
        } else {
            if(this.coda.isEmpty())
                this.coda.add(new Ticket(1));
            else
                this.coda.addLast(new Ticket(getLast().getNum() + 1));
        }
    }

    public Ticket pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Coda vuota");
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
