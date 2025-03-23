import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

public class Gestore {
    RandomAccessFile raf;
    Map<String, Long> hashtable;


    public Gestore(String nomeFile) {
        try {
            raf = new RandomAccessFile(nomeFile, "rw");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void carica() {
        try {
            raf.seek(0);
            while (raf.getFilePointer() < raf.length()) {
                Macchina m = new Macchina();
                m.setTarga(raf.readUTF());
                m.setMarca(raf.readUTF());
                m.setModello(raf.readUTF());
                m.setAlim(raf.readChar());
                m.setCc(raf.readDouble());
                m.setAnno(raf.readInt());
                m.setPrezzo(raf.readDouble());
                hashtable.put(m.getTarga(), raf.getFilePointer());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //salva tutto il contenuto della hashtable nel file
    public void salva() {
        try {
            raf.seek(0);
            for (String targa : hashtable.keySet()) {
                long filePointer = hashtable.get(targa);
                raf.seek(filePointer);
                Macchina m = new Macchina();
                m.setTarga(raf.readUTF());
                m.setMarca(raf.readUTF());
                m.setModello(raf.readUTF());
                m.setAlim(raf.readChar());
                m.setCc(raf.readDouble());
                m.setAnno(raf.readInt());
                m.setPrezzo(raf.readDouble());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(Macchina m) throws Exception {
        raf.seek(raf.length());
        m.write(raf);
        hashtable.put(m.getTarga(), raf.getFilePointer());

    }

    public void remove(String targa) throws Exception{
            if(hashtable.get(targa) == null)
                throw new Exception("Targa non trovata");
            else{
                hashtable.remove(targa);
            }
    }

    public Macchina get(String targa) throws IOException {
        Macchina m = new Macchina();
        if(hashtable.get(targa) == null) {
            m = null;
        }else{
            long filePointer = hashtable.get(targa);
            raf.seek(filePointer);
            m.setTarga(raf.readUTF());
            m.setMarca(raf.readUTF());
            m.setModello(raf.readUTF());
            m.setAlim(raf.readChar());
            m.setCc(raf.readDouble());
            m.setAnno(raf.readInt());
            m.setPrezzo(raf.readDouble());
        }
        return m;
    }

    public String print(){
        String s = "";
        for(String targa : hashtable.keySet()){
            s = s.concat(targa + "\n");
        }
        return s;
    }
}
