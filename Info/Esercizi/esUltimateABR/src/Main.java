/*Realizzare applicazione che permetta di inserire e ricercare un prodotto venduto per la modifica del prezzo per il magazzino da una grande azienda di distribuzione.
Nell'inserimento si deve controllare che il codice sia univoco, mentre la ricerca avviene tramite conoscenza del codice.
Produrre grafo UML e codice java delle classi interessate.
Si dovrà produrre la classe Gestore che permette di memorizzare/ ricercare un prodotto tramite uso di un indice gestito da ABR (la cui classe già avete creato in precedenti esercizi) ed un file binario ad accesso random.
L'ABR dovrà essere considerato come indice di accesso al file random in cui dovrà essere memorizzato codice prodotto e indirizzo del record nel file binario.
L’indice dovrà essere salvato su disco al termine del programma e ricaricato in ram all’inizio del programma.


 */
public class Main{
    public static void main(String[] args){
        Gestore gestore = new Gestore();
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

    }

    public static void ricerca(Gestore gestore){

    }
}