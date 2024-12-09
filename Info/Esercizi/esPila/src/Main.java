/*Andrea Guarino & Cucchi UwU 4BI
Realizzare la classe Pila su tipo Generico T (con lancio di eccezioni per le situazioni di errore) che
abbia i seguenti metodi pubblici:
a)costruttori
b)push
c)pop
d)size
e)isEmpty e isFull
Realizzare il main che permetta di gestire quest'espressione matematica in notazione postfissa 56+7-4*
 */
public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila<Integer>(2);
        char sc;
        do {
            menu();
            sc = Input.leggiChar('a', 'c', "Scelta :");
            switch (sc) {
                case 'a': {
                    aggiunta(pila);
                    break;
                }
                case 'b': {
                    calcolo(pila);
                    break;
                }
            }
        }while (sc != 'c') ;
    }

    public static void aggiunta(Pila pila) {
        //
    }

    private static void calcolo(Pila pila) {
        //
    }

    public static void menu(){
        System.out.println("a) Aggiungi numero");
        System.out.println("b) Calcolo numero");
        System.out.println("c) Termine esecuzione");
    }


}
