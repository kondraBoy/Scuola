import java.util.Date;

/*Andrea Guarino 4BI
Realizzare il programma che permetta di effettuare acquisti e vendite di pacchetti azionari.
Il programma gestirà in modalità LIFO gli acquisti e calcolerà PluValenza e MinusValenza per ogni vendita.
La pila dei pacchetti azionari acquistati (per uno stesso titolo) viene salvata alla fine del programma in un file csv
 e viene ripristinata in ram all'inizio del programma a partire dal file csv.


 */
public class Main {
    public static void main(String[] args) {
        Pila<PacchettoAzionario> pila = new Pila<>();
        pila.importa("azioni.csv", new PacchettoAzionario());
        char sc;
        do{
            menu();
            sc = Input.leggiChar('a','d',"Scelta :");
            switch (sc) {
                case 'a': {

                }
            }
        }while(sc!='d');
        pila.esporta("azioni.csv");
    }


    public static void acquisto(Pila<PacchettoAzionario> pila){
        PacchettoAzionario p = new PacchettoAzionario();
        p.setNome(Input.leggiStr("Nome: "));
        p.setPrezzo(Input.leggiDouble(0,Double.MAX_VALUE,"Prezzo: "));
        p.setQuantita(Input.leggiInt(0,Integer.MAX_VALUE,"Quantità: "));
        p.setData(new Date());
        pila.push(p);
    }

    public static void vendita(Pila<PacchettoAzionario> pila) {
        String nomeRicerca = Input.leggiStr("Inserisci il nome dell'azione da cercare: ");
        PacchettoAzionario p = findAzioni(pila, nomeRicerca);
        if (p != null) {
            System.out.println("L'azione inserita è stata trovata.....");
            double przVendita = Input.leggiDouble(0, Double.MAX_VALUE, "A quale prezzo desidera vendere?");
            if (p.getPrezzo() > przVendita) {
                System.out.println("Il prezzo di vendita è inferiore al prezzo di acquisto, potresti incorrere in una minus valenza. Desideri continuare (y/si n/no)?");
                char sc = Input.leggiChar('y', 'n', "Scelta: ");
                if (sc == 'y') {


                }
            } else {
                System.out.println("Azione non trovata");
            }

        }
    }

        public static PacchettoAzionario findAzioni (Pila < PacchettoAzionario > pila, String nomeRicerca){
            boolean find = false;
            PacchettoAzionario p = new PacchettoAzionario();
            Pila<PacchettoAzionario> pilaTemp = new Pila<>();
            while (!pila.isEmpty()) {
                p = pila.pop();
                if (p.getNome().equalsIgnoreCase(nomeRicerca)) {
                    System.out.println("Azione trovata:");
                    System.out.println("Nome: " + p.getNome());
                    System.out.println("Prezzo: " + p.getPrezzo());
                    System.out.println("Quantità: " + p.getQuantita());
                    System.out.println("Data: " + p.getData());
                    System.out.println("----------------");
                    find = true;
                }
                pilaTemp.push(p);
            }
            while (!pilaTemp.isEmpty()) {
                pila.push(pilaTemp.pop());
            }
            return p;
        }

        public static void menu () {
            System.out.println("a) Acquisto");
            System.out.println("b) Vendita");
            System.out.println("c) Stampa");
            System.out.println("d) Esci");
        }

    }
