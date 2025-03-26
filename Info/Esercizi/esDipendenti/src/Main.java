import java.io.IOException;

/*Un’azienda è caratterizzata da un nome, un responsabile, un indirizzo, una e-mail ed un sito web. In tale azienda lavorano dipendenti di tipo diverso: Impiegati e Operai.

Tutti i dipendenti sono caratterizzati da:

§ Matricola (Intero - UNIVOCO)

§ Nome

§ Cognome

§ Data di nascita

Gli impiegati sono caratterizzati da un salario mensile e dal numero di ore di permesso (per ogni ora di permesso vengono decurtati 20€ dallo stipendio).

Gli operai, invece, sono caratterizzati da una paga oraria, un numero di ore di straordinario e un numero di ore di permesso (si consideri che, di norma, un mese è formato da 160 ore lavorative e le ore di straordinario hanno una paga orario incrementata del 30% rispetta a quella ordinaria).

Tutti gli elementi della gerarchia devono avere metodi comuni come stampaDati e calcolaPaga.

Realizzare un programma che gestisca i dipendenti di un’azienda.

Tale menù sarà costituito dai seguenti punti:

1. Inserimento di un nuovo dipendente

2. Stampa dell’elenco dei dipendenti dell’azienda

§ per gli operai stampare “matricola+nome+cognome+oreLavorate”;

§ per gli impiegati stampare “matricola+nome+cognome+pagaMensile”;

3. Stampa di tutti di dipendenti aventi uno stipendio mensile inferiore a 1350€

4. Licenziamento di un dipendete, data la matricola

5. Stampa del totale stipendi che l’azienda dovrà versare ai dipendenti

6. Esportazione su file csv di tutti i dipendenti di un tipo indicato ordinati per cognome (Operaio/Impiegato)


Dovrà esistere la classe Gestore che gestisce l’insieme dei dipendenti (l’insieme è gestita come lista non sequenziale gestita dalla classe MyList<T> vista a lezione) che avrà tutti i metodi necessari alle funzionalità del main. La classe T dovrà usare l’interfaccia Comparable e FileCsv.

L’interazione con l’utente avverrà tramite interfaccia grafica e le diverse voci del menù saranno rappresentate da bottoni presenti alla prima finestra visibile all’apertura del programma.

Realizzare il mockup dell’applicazione per individuare gli oggetti grafici necessari ad ogni singola finestra del programma.

Descrivere, inoltre, la struttura del file csv.
 */
public class Main {
    public static void main(String[] args) {
        Azienda azienda = new Azienda();
        char sc;
        do{
            menu();
            sc = Input.leggiChar('a','g',"Scelta: ");
            switch (sc){
                case 'a': {
                    addDipendente(azienda);
                    break;
                }
                case 'b': {
                    stampaDipendenti(azienda);
                    break;
                }
                case 'c': {
                    stampaPerSalario(azienda);
                    break;
                }
                case 'd': {
                    licenziaDipendente(azienda);
                    break;
                }
                case 'e': {
                    stampaTotaleStipendi(azienda);
                    break;
                }
                case 'f': {
                    esportaOrdinato(azienda);
                    break;
                }
            }
        }while(sc!='g');
    }

    public static void menu(){
        System.out.println("1. Inserimento di un nuovo dipendente");
        System.out.println("2. Stampa dell’elenco dei dipendenti dell’azienda");
        System.out.println("3. Stampa di tutti di dipendenti aventi uno stipendio mensile inferiore a 1350€");
        System.out.println("4. Licenziamento di un dipendete, data la matricola");
        System.out.println("5. Stampa del totale stipendi che l’azienda dovrà versare ai dipendenti");
        System.out.println("6. Esportazione su file csv di tutti i dipendenti di un tipo indicato ordinati per cognome (Operaio/Impiegato)");
        System.out.println("7. Esci");
    }

    public static void addDipendente(Azienda azienda){
        char sc;
        do{
            System.out.println("a. Aggiungi Impiegato");
            System.out.println("b. Aggiungi Operaio");
            System.out.println("c. Esci");
            sc = Input.leggiChar('a','c',"Scelta: ");
            switch (sc){
                case '1': {
                    int mat=Integer.parseInt(Input.leggiStr("Matricola: "));
                    String nome=Input.leggiStr("Nome: ");
                    String cog=Input.leggiStr("Cognome: ");
                    String data=Input.leggiStr("Data di nascita: ");
                    double salario=Input.leggiDouble(0,Double.MAX_VALUE,"Salario: ");
                    int orePermesso=Input.leggiInt(0,Integer.MAX_VALUE,"Ore permesso: ");
                    try {
                        Impiegato imp = new Impiegato(mat,nome,cog,data,salario,orePermesso);
                        azienda.addImpiegato(imp);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case '2': {
                    int mat=Integer.parseInt(Input.leggiStr("Matricola: "));
                    String nome=Input.leggiStr("Nome: ");
                    String cog=Input.leggiStr("Cognome: ");
                    String data=Input.leggiStr("Data di nascita: ");
                    double pagaOra=Input.leggiDouble(0,Double.MAX_VALUE,"Paga oraria: ");
                    int orePermesso=Input.leggiInt(0,Integer.MAX_VALUE,"Ore permesso: ");
                    int oreStraordinario=Input.leggiInt(0,Integer.MAX_VALUE,"Ore straordinario: ");
                    try {
                        Operaio op = new Operaio(mat,nome,cog,data,pagaOra,orePermesso,oreStraordinario);
                        azienda.addOperario(op);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
            }
        }while(sc!='c');
    }
    public static void stampaDipendenti(Azienda azienda){
        System.out.println(azienda.stampaDipendenti());
    }

    public static void stampaPerSalario(Azienda azienda){
        Double salario = Input.leggiDouble(0,Double.MAX_VALUE,"Salario: ");
        System.out.println(azienda.stampaDipendenti(salario));
    }

    public static void licenziaDipendente(Azienda azienda){
        int mat = Input.leggiInt(0,Integer.MAX_VALUE,"Matricola: ");
        azienda.licenziaDipendente(mat);
    }

    public static void stampaTotaleStipendi(Azienda azienda){
        System.out.println(azienda.calcolaStipendi());
    }

    public static void esportaOrdinato(Azienda azienda){
        char sc;
        do{
            System.out.println("a. Esporta Impiegati");
            System.out.println("b. Esporta Operai");
            System.out.println("c. Esci");
            sc = Input.leggiChar('a','c',"Scelta: ");
            switch (sc){
                case 'a': {
                    try{azienda.esportaOrdinato("impiegati.csv","Impiegato");
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 'b': {
                    try {
                        azienda.esportaOrdinato("operai.csv","Operaio");
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
            }
        }while(sc!='c');
    }
}