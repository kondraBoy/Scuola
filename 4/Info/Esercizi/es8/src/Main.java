/*Andrea Guarino 4BI
Creare una classe che vada a gestire un set di numeri interi appartenenti ad un range prefissato.
Ogni gestore di numeri interi istanziato conoscerà il valore minimo, il valore massimo (in riferimento al range da gestire) e se deve accettare numeri pari o numeri dispari.
La classe dovrà presentare i seguenti metodi:

Costruttori:
Default: istanzia un oggetto che accetta numeri pari compresi tra 0 e 200
Con parametri
Di copia

Getters e Setters

Un metodo per aggiungere un numero al set
Un metodo che restituisce una stringa csv di tutti i numeri del set
Un metodo che restituisce la media dei numeri del set
Un metodo che restituisce, in base ad un valore passato come parametro, il numero massimo o il numero minimo, tra i numeri del set

Crea un programma di prova che verifichi il funzionamento della classe.


*/
public class Main {
    public static void main(String[] args) {
        GestoreNumeri gestoreNumeri1 = new GestoreNumeri(0,300,true);
        char sc;
        do {
            menu();
            sc = Input.leggiChar('a','e',"Scelta: ");
            switch (sc) {
                case 'a': {
                    aggiungiNumero(gestoreNumeri1);
                    break;
                }
                case 'b': {
                    stampaNumeri(gestoreNumeri1);
                    break;
                }
                case 'c': {
                    mediaNumeri(gestoreNumeri1);
                    break;
                }
                case 'd': {
                    numeroMaxMin(gestoreNumeri1);
                    break;
                }
            }
        }while(sc!='e');
    }

    private static void numeroMaxMin(GestoreNumeri gestoreNumeri1) {
        int scelta, number;
        System.out.println("Cosa vuoi stampare :");
        System.out.println("1) numero massimo");
        System.out.println("2) numero minimo");
        scelta = Input.leggiInt(1,2,"Scelta :");
        number = gestoreNumeri1.findMAXorMin(scelta);
        if(scelta==1){
            System.out.println("Il numero massimo è: " + number);
        }else
            System.out.println("Il numero minimo è: " + number);
    }

    private static void aggiungiNumero(GestoreNumeri gestoreNumeri1) {
        int num,max;
        max= gestoreNumeri1.getVmax();
        num = Input.leggiInt(0,max,"Inserire numero da posizionare nella sequenza di numeri");
        if(!gestoreNumeri1.addNumber(num)){
            System.out.println("Numero non divisibile per due");
        }else
            System.out.println("Numero inserito con successo");
    }

    private static void stampaNumeri(GestoreNumeri gestoreNumeri1) {
        String s = gestoreNumeri1.csvStringNumbers();
        System.out.println(s);
    }

    private static void mediaNumeri(GestoreNumeri gestoreNumeri1){
        double media = gestoreNumeri1.mediaNumbers();
        if(media==-1){
            System.out.println("Impossibile ottenere la media");
        }else{
            System.out.println("La media di tutti i numeri inseriti è: " + media);
        }

    }

    public static void menu(){
        System.out.println("a) Aggiungi numero alla sequenza");
        System.out.println("b) Stampa riga con tutti i numeri");
        System.out.println("c) Stampa media della sequenza");
        System.out.println("d) Valore massimo o minimo della sequenza");
        System.out.println("e) Termina il programma");
    }
}