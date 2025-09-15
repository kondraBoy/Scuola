/*Andrea Guarino 4BI
Getstire quadrilateri e triangoli come elementi ereditati da classe figura e metodi comuni come stampa, area e perimetro.
Realizzare un programma che gestisce n figure tramite classe GESTORE che possono essere o quadrilateri o triangoli
(a scelta dell'utente) sui quali si possano fare le seguenti operazioni:
1)inserimento
2)stampa dei dati delle figure inserite (se quadrilatero si stampa "quadrilatero+ lato1+lato2+area=.....+perimetro=...’’",
se triangolo si stampa "triangolo+l1+l2+l3+area=....+perimetro=.....”,
3)elenco delle aree di ogni figura in output si stampa “quadriatero: area=.....” se quadrilatero; “triangolo:area=....” se triangolo.
Produrre classe GESTORE (con metodi add, toString ed elencoAree), la classe Figura e le classi Quadrilatero e TRiangolo
ed il main che realizzata I/O con utente e classe Gestore.

 */

public class Main {
    public static void main(String[] args) {
        Gestore gestore = new Gestore();
        char sc;
        do {
            menu();
            sc = Input.leggiChar('a','d',"Scelta: ");
            switch (sc) {
                case 'a': {
                    addFigura(gestore);
                    break;
                }
                case 'b': {
                    stampaDati(gestore);
                    break;
                }
                case 'c': {
                    elencoAree(gestore);
                    break;
                }
            }
        }while(sc!='d');
    }


    private static void addFigura(Gestore gestore) {
        float l1,l2,l3;
        char tipo = Input.leggiChar('a','b',"Inserisci tipo di figura (a=Quadrilatero, b=Triangolo): ");
        if (tipo == 'a') {
            l1 = Input.leggiFloat(0,Float.MAX_VALUE,"Inserire lato 1:");
            l2 = Input.leggiFloat(0,Float.MAX_VALUE,"Inserire lato 2:");
            gestore.add(new Quadrilateri(l1, l2));
        } else if (tipo == 'b') {
            l1 = Input.leggiFloat(0, Float.MAX_VALUE, "Inserire lato 1:");
            l2 = Input.leggiFloat(0, Float.MAX_VALUE, "Inserire lato 2:");
            l3 = Input.leggiFloat(0, Float.MAX_VALUE, "Inserire lato 3:");
            gestore.add(new Triangoli(l1, l2, l3));
        }

    }

    private static void elencoAree(Gestore gestore){
        String s = gestore.elencoAree();
        System.out.println(s);
    }

    private static void stampaDati(Gestore gestore){
        String s = gestore.toString();
        System.out.println(s);
    }

    private static void menu(){
        System.out.println("a) Inserisci figura");
        System.out.println("b) Stampa dati delle figure");
        System.out.println("c) Elenco delle aree");
        System.out.println("d) Esci");
    }
}
