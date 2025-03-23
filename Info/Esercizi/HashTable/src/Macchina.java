import java.io.IOException;
import java.io.RandomAccessFile;


public class Macchina implements IOFileRandom, Comparable{
    private final int LENSTR = 70;
    private String targa, marca, modello;
    private char alim;
    private double cc, prezzo;
    private int anno;


    public int getAnno() {
        return anno;
    }
    public void setAnno(int anno) {
        if(anno >= 1900)
            this.anno = anno;
        else
            throw new IllegalArgumentException("Anno non valido");
    }

    public double getPrezzo() {
        return this.prezzo;
    }
    public void setPrezzo(double prezzo) {
        if(prezzo > 0)
            this.prezzo = prezzo;
        else
            throw new IllegalArgumentException("Prezzo non valido");
    }

    public double getCc() {
        return this.cc;
    }
    public void setCc(double cc) {
        if(cc > 0)
            this.cc = cc;
        else
            throw new IllegalArgumentException("Cilindrata non valida");
    }

    public char getAlim() {
        return this.alim;
    }
    public void setAlim(char alim) {
        this.alim = alim;
    }

    public String getModello() {
        return this.modello;
    }
    public void setModello(String modello) {
        if(!modello.isEmpty())
            this.modello = modello;
        else
            throw new IllegalArgumentException("Modello non valido");
    }

    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String marca) {
        if(!marca.isEmpty())
            this.marca = marca;
        else
            throw new IllegalArgumentException("Marca non valida");
    }

    public String getTarga() {
        return this.targa;
    }
    public void setTarga(String targa) {
        if(!targa.isEmpty())
            this.targa = targa;
        else
            throw new IllegalArgumentException("Targa non valida");
    }

    public Macchina(){
        setAlim('B');
        setCc(100);
        setMarca("Ford");
        setModello("Fiesta");
        setPrezzo(100000);
        setTarga("AA111AA");
        setAnno(2014);
    }
    public Macchina(char alim, int cc, String marca, String modello,
                    double prezzo, String targa, int anno) throws IllegalArgumentException{
        setAlim(alim);
        setCc(cc);
        setMarca(marca);
        setModello(modello);
        setPrezzo(prezzo);
        setTarga(targa);
        setAnno(anno);
    }

    @Override
    public String toString(){
        String s = getAlim() + " ";
        s = s.concat(getCc() + " ");
        s = s.concat(getMarca() + " ");
        s = s.concat(getModello() + " ");
        s = s.concat(getPrezzo() + " ");
        s = s.concat(getTarga() + " ");
        s = s.concat(getAnno() + "");
        return s;
    }


    @Override
    public void write(RandomAccessFile raf) throws IOException {
        Input.write(raf, getTarga(), LENSTR);
        Input.write(raf, getMarca(), LENSTR);
        Input.write(raf, getModello(), LENSTR);
        raf.writeChar(getAlim());
        raf.writeDouble(getCc());
        raf.writeDouble(getPrezzo());
        raf.writeInt(getAnno());
    }

    @Override
    public void read(RandomAccessFile raf) throws IOException {
        setTarga(Input.readString(raf, LENSTR));
        setMarca(Input.readString(raf, LENSTR));
        setModello(Input.readString(raf, LENSTR));
        setAlim(raf.readChar());
        setCc(raf.readDouble());
        setPrezzo(raf.readDouble());
        setAnno(raf.readInt());
    }

    @Override
    public int compareTo(Object o) {
        Macchina m = (Macchina) o;
        return this.getTarga().compareTo(m.getTarga());
    }
}
