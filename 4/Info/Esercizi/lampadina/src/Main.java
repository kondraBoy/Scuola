import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        String nome = Input.leggiStr("Inserisci il nome della lampadina:");
        Lampadina lampadina = new Lampadina(nome);
        char sc;
        do {
            menu();
            sc = Input.leggiChar('a', 'g', "Scelta: ");
            switch (sc) {
                case 1:
                    accendiSpegniLampadina(lampadina);
                    break;

                case 2:
                    impostaLuminosita(lampadina);
                    break;

                case 3:
                    impostaColoreRGB(lampadina);
                    break;

                case 4:
                    mostraStatoLampadina(lampadina);
                    break;

                case 5:
                    esportaCSV(lampadina);
                    break;

                case 6:
                    importaCSV(lampadina);
                    break;
            }
        } while (sc != 'g');
    }


    private static void menu() {
        System.out.println("a. Accendi/Spegni lampadina");
        System.out.println("b. Imposta luminosità");
        System.out.println("c. Imposta colore RGB");
        System.out.println("d. Mostra stato lampadina");
        System.out.println("e. Esporta in CSV");
        System.out.println("f. Importa da CSV");
        System.out.println("g. Esci");
    }


    private static void accendiSpegniLampadina(Lampadina lampadina) {
        boolean currentStatus = lampadina.getStatus();
        lampadina.setStatus(!currentStatus);
        System.out.println("Lampadina " + (lampadina.getStatus() ? "accesa" : "spenta"));
    }

    private static void impostaLuminosita(Lampadina lampadina) {
        int luminosita = Input.leggiInt(0,5,"Inserisci luminosità (1-5)");
        try {
            lampadina.setLum(luminosita);
            System.out.println("Luminosità impostata a " + luminosita);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    private static void impostaColoreRGB(Lampadina lampadina) {
        int rgb0, rgb1, rgb2;
        rgb0 = Input.leggiInt(0,255,"Inserire R di RGB");
        rgb1 = Input.leggiInt(0,255,"Inserire G di RGB");
        rgb2 = Input.leggiInt(0,255,"Inserire B di RGB");
        try {
            ArrayList<Integer> rgb = new ArrayList<>();
            rgb.add(rgb0);
            rgb.add(rgb1);
            rgb.add(rgb2);
            lampadina.setRgb(rgb);
            System.out.println("Colore RGB impostato a " + rgb);
        } catch (Exception e) {
            System.out.println("Errore: I valori RGB devono essere numeri tra 0 e 255");
        }
    }


    private static void mostraStatoLampadina(Lampadina lampadina) {
        System.out.println(lampadina.toCSV());
    }


    private static void esportaCSV(Lampadina lampadina) {
        System.out.println("Esportazione in CSV:");
        System.out.println(lampadina.toCSV());
    }


    private static void importaCSV(Lampadina lampadina) {
        String csvInput = Input.leggiStr("Inserisci la stringa CSV da importare: ");
        try {
            lampadina.fromCSV(csvInput);
            System.out.println("Lampadina aggiornata con successo.");
        } catch (Exception e) {
            System.out.println("Errore nell'importazione: " + e.getMessage());
        }
    }
}
