import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Gestore g = new Gestore("car.bin");
        g.carica();
        int sc;
        do {
            menu();
            sc = Input.leggiInt(1, 5, "Inserisci un numero tra 1 e 5");
            switch (sc) {
                case 1:
                    add(g);
                    break;
                case 2:
                    remove(g);
                    break;
                case 3:
                    print(g);
                    break;
                case 4:
                    search(g);
                    break;
            }
            g.salva();
        } while (sc != 5);
    }

    public static void menu(){
        System.out.println("1. Aggiungi macchina");
        System.out.println("2. Rimuovi macchina");
        System.out.println("3. Stampa macchine");
        System.out.println("4. Cerca macchina data la targa");
        System.out.println("5. Esci");
    }

    public static void add(Gestore g) {
        try {
            Macchina m = new Macchina();
            m.setTarga(Input.leggiStr("Inserisci la targa"));
            m.setMarca(Input.leggiStr("Inserisci la marca"));
            m.setModello(Input.leggiStr("Inserisci il modello"));
            m.setAlim(Input.leggiChar('A', 'G', "Inserisci l'alimentazione"));
            m.setCc(Input.leggiInt(100, 10000, "Inserisci i cc"));
            m.setAnno(Input.leggiInt(1900, 2020, "Inserisci l'anno"));
            m.setPrezzo(Input.leggiFloat(1000, 1000000, "Inserisci il prezzo"));
            g.add(m);
        } catch (Exception e) {
            System.out.println("Ci sono stati errori");
        }
    }

    public static void remove(Gestore g) {
        try {


            String targa = Input.leggiStr("Inserisci la targa");
            g.remove(targa);
        } catch (Exception e) {
            System.out.println("La targa non è presente");
        }
    }

    public static void print(Gestore g) {
        g.print();
    }

    public static void search(Gestore g) {
        try {
            String targa = Input.leggiStr("Inserisci la targa");
            Macchina m = g.get(targa);
            if(m == null)
                System.out.println("La targa non è presente");
            System.out.println(m);
        } catch (Exception e) {
            System.out.println("Si è verificato un errore");
        }
    }

}