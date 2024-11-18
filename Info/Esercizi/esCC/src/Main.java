/*Andrea Guarino 4BI
1) realizzare una classe ContoCorrente che permette la gestione di un conto corrente bancario.
Attributi da definire che permettono di identificare un cc. Metodi che permettono di impostare
un conto corrente alla sua apertura, realizzare prelievo e versamento su di esso(con controlli),
conoscere il saldo.
2)Realizzare il programma presente allo sportello che prevede, dopo la creazione di un conto
corrente, di effettuare più operazioni di versamento e di prelievo(con feedback) a scelta dall
utente.
3) disegnare schema delle classi UML e documentazione della classe Cc

*/
public class Main {
    public static void main(String[] args) {
        char sc;
        Cc conto = new Cc();
        setConto(conto);
        do {
            menu();
            sc = Input.leggiChar('a','d',"Scelta: ");
            switch (sc) {
                case 'a': {
                    prelievo(conto);
                    break;
                }
                case 'b': {
                    versamento(conto);
                    break;
                }
                case 'c': {
                    mostraSaldo(conto);
                    break;
                }
            }
        }while(sc!='d');
    }

    public static void menu(){
        System.out.println("a) Prelievo");
        System.out.println("b) Versamento");
        System.out.println("c) Visualizza conto");
        System.out.println("d) Esci dallo sportello");
    }

    public static void setConto(Cc conto){
        String nome = Input.leggiStr("Inserire nome intestatario conto");
        conto.setNome(nome);
        String cognome = Input.leggiStr("Inserire nome intestatario conto");
        conto.setCognome(cognome);
        Double saldo = Input.leggiDouble(0,Float.MAX_VALUE,"Inserire saldo del conto");
        conto.setSaldo(saldo);
    }

    public static void prelievo(Cc conto){

    }
}