import java.io.*;

public class Gestore {
    private ABR abr;
    private RandomAccessFile raf;

    public Gestore()throws IOException {
        this.raf = new RandomAccessFile("prodotti.dat", "rw");
        try {
            ObjectInputStream fin = new ObjectInputStream(new FileInputStream("prodotti.dat"));
            this.abr = (ABR) fin.readObject();
        }
        catch (FileNotFoundException | ClassNotFoundException e) {
            abr = new ABR();
        }
    }

    public int add(int key) throws IOException {
        int n = -1;
        if(abr.search(key) == null){
            raf.seek(raf.length());
            long address = raf.getFilePointer();
            abr.add(key);
            n = 0;
        }
        return n;
    }

    public int search(int key) throws IOException {
        int n = -1;
        Node node = abr.search(key);
        if(node != null){
            raf.seek(node.getAddress());
            n = 0;
        }
        return n;
    }

}


