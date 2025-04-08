import java.io.IOException;

/*Realizzare applicazione che permetta di inserire e ricercare un prodotto venduto per la modifica del prezzo per il magazzino da una grande azienda di distribuzione.
Nell'inserimento si deve controllare che il codice sia univoco, mentre la ricerca avviene tramite conoscenza del codice.
Produrre grafo UML e codice java delle classi interessate.
Si dovrà produrre la classe Gestore che permette di memorizzare/ ricercare un prodotto tramite uso di un indice gestito da ABR (la cui classe già avete creato in precedenti esercizi) ed un file binario ad accesso random.
L'ABR dovrà essere considerato come indice di accesso al file random in cui dovrà essere memorizzato codice prodotto e indirizzo del record nel file binario.
L’indice dovrà essere salvato su disco al termine del programma e ricaricato in ram all’inizio del programma.


 */
public class Main{
    public static void main(String[] args){
        Gestore gestore = null;
        try {
            gestore = new Gestore();
        } catch (IOException e) {
            System.out.println("Errore nel caricamento del gestore");
        }
        char sc;
        do{
            menu();
            sc = Input.leggiChar('a','c',"Inserisci la tua scelta");
            switch (sc){
                case 'a':{
                    inserimento(gestore);
                    break;
                }
                case 'b':{
                    ricerca(gestore);
                    break;
                }
            }
        }while(sc != 'c');
    }

    public static void menu(){
        System.out.println("a. Inserimento prodotto");
        System.out.println("b. Ricerca prodotto");
        System.out.println("c. Uscita");
    }

    public static void inserimento(Gestore gestore){
        int key = Input.leggiInt(0,Integer.MAX_VALUE,"Inserire il codice del nuovo prodotto");
        try {
            if(gestore.add(key) == -1)
                System.out.println("Il codice prodotto è già presente");
            else
                System.out.println("Prodotto aggiunto correttamente");
        } catch (IOException e) {
            System.out.println("Problemi nell'aggiunta del prodotto");
        }
    }

    public static void ricerca(Gestore gestore){
        int key = Input.leggiInt(0,Integer.MAX_VALUE,"Inserire il codice del nuovo prodotto");
        try {
            if(gestore.search(key) == -1)
                System.out.println("Il codice prodotto è presente");
            else
                System.out.println("Il codice prodotto risulta inesistente");
        } catch (IOException e) {
            System.out.println("Problemi nella ricerca del codice prodotto");
        }
    }
}