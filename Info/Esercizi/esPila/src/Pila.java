import java.io.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Pila <T extends FileCSV> {
    private LinkedList<T> lista;

    public Pila() {
        lista = new LinkedList<>();
    }

    public void push(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Non posso aggiungere un elemento nullo");
        }
        lista.addLast(obj);
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("La pila è vuota");
        }
        return lista.removeFirst();
    }

    public int size() {
        return lista.size();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }
    public void esporta(String nf){
        try{
            FileWriter fw = new FileWriter(nf);
            for(T obj : lista){
                fw.write(obj.toCSV());
                fw.write("\n");
            }
            fw.close();
        }catch (IOException e){
            System.out.println("Errore di scrittura");
        }
    }
    public void importa(String nf, T obj) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nf));
            String line = reader.readLine();
            while (line != null) {
                obj.fromCSV(line);
                lista.add(obj);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Errore di lettura");
        }
    }
}
