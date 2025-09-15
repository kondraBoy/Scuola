/*Andrea Guarino 4BI
Caricare un elenco di figure geometriche a partire da un file csv (da descrivere). Ogni riga del file conterrà i dati o di un quadrilatero o di un triangolo (in base al valore di un item). Al termine del caricamento il programma stamperà il perimetro di ogni figura iportata (polimorfismo!!).
Classe Gestore: aggiunta di due metodi importazione ed esportazione di fugure geometriche.
Interface FileCsv: da scrivere (metodi toCsv e fromCsv)
Classe Figura: deve implementare l'interface FileCsv.


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