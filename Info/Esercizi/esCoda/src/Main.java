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
        do{
            menu();
            char sc = Input.leggiChar('a','c',"Scelta :");
            switch(sc){
                case 'a':{

                    break;
                }
                case 'b':{

                    break;
                }
        }while(sc!='c');
    }

}
