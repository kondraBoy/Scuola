import java.io.IOException;

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