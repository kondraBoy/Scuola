import java.io.*;
import java.util.Hashtable;
import java.util.Map;

public class Gestore {
    private Map<Integer,String> hashtable;
    private RandomAccessFile raf;

    public Gestore()throws IOException {
        this.raf = new RandomAccessFile("prodotti.dat", "rw");
        try {
            ObjectInputStream fin = new ObjectInputStream(new FileInputStream("prodotti.dat"));
            hashtable = (Map<Integer, String>) fin.readObject();
        }
        catch (FileNotFoundException | ClassNotFoundException e) {
            hashtable = new Hashtable<>();
        }
    }

    public int add(int key) throws IOException {
        int n = -1;
        if(hashtable.get(key) == null){
            raf.seek(raf.length());
            long address = raf.getFilePointer();
            hashtable.put(key, String.valueOf(address));
            n = 0;
        }
        return n;
    }
    public int search(int key){ //Non so come fare
        return key;
    }

}


