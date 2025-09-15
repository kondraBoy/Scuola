public class ContatoreCondiviso {
    private int contatore = 0;
    private final int MAX = 20;

    public int stampaPari() throws InterruptedException {
        while (contatore < MAX && contatore % 2 != 0) {
            wait();
        }

        if (contatore >= MAX) return -1;

        int valore = contatore++;
        notifyAll();
        return valore;
    }

    public int stampaDispari() throws InterruptedException {
        while (contatore < MAX && contatore % 2 == 0) {
            wait();
        }

        if (contatore >= MAX) return -1;

        int valore = contatore++;
        notifyAll();
        return valore;
    }
}
