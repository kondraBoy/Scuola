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

    public void add(int key) throws IOException {
        if(abr.search(key) == null){
            raf.seek(raf.length());
            long address = raf.getFilePointer();
            abr.add(key);

        }
    }

}


