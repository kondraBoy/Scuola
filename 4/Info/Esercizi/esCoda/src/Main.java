/*
Realizzare la classe Coda di oggetti di tipo Tocket(come esercizio di allenamento sull'uso di arrayList o LinkedList, decidete voi quale è meglio)
che esponga i seguenti metodi: pop, push, isEmpty, isFull, getLast.
Usando la classe coda, implementare la coda di un ufficio postale:
a) arrivo di una nuova persone (nuovo ticket, numero da determinare)
b) accesso di una persona allo sportello (visualizzare numero ticket)
 */
public class Main {
    public static void main(String[] args) {
        Coda coda = new Coda();
        char sc;
        do {
            menu();
            sc = Input.leggiChar('a', 'c', "Scelta :");
            switch (sc) {
                case 'a': {
                    arrivo(coda);
                    break;
                }
                case 'b': {
                    accesso(coda);
                    break;
                }
            }
        }while (sc != 'c') ;
    }

    public static void arrivo(Coda coda) {
        try{
            coda.push();
        }
        catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }

    private static void accesso(Coda coda) {
        try{
            System.out.println("Numero: " + coda.pop().getNum());
        }
        catch(IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }

    public static void menu(){
        System.out.println("a) Nuovo arrivo persona");
        System.out.println("b) Accesso persona allo sportello");
        System.out.println("c) Termine esecuzione");
    }


}
