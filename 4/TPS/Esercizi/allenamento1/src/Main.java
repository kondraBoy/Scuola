/*La classe deve offrire due metodi sincronizzati:

public synchronized void put(int value) per il produttore, che inserisce un nuovo valore nel buffer.
Se il buffer è pieno, il thread produttore deve attendere fino a quando non c'è spazio.

public synchronized int get() per il consumatore, che estrae un valore dal buffer.
Se il buffer è vuoto, il thread consumatore deve attendere fino a quando non è presente un elemento.



*/
public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Produttore produttore = new Produttore(buffer);
        produttore.start();

    }
}