/*

Realizzare un’applicazione in grado di gestire la vostra scheda SIM.

La SIM è caratterizzata da:

Nome intestatario

IMEI

Numero di telefono

Credito residuo

Minuti di chiamate effettuate sulla SIM

SIM attiva(boolean)

Realizzare i seguenti metodi:

Costruttori

Getters e Setters

Metodo toString

Metodo compareTo

Metodo che riceve un valore in euro ed effettua la ricarica della SIM.

Metodo che, dato un tempo in minuti, permetta di effettuare una chiamata. (La tariffa per le chiamate è pari a 0,32€/min – nel caso in cui il credito non sia sufficiente?)

Metodo DISATTIVA SIM con cui si potrà disattivare la SIM

Metodo che converte i minuti di chiamate nel formato: hh:mm



Realizzare un main di prova contenente il seguente menu:

Attiva SIM

Stampa dati SIM

Ricarica SIM (tagli ricarica: 5€, 10€, 20€)

Effettua telefonata

Visulizza hh:mm totale di chiamate

Disattiva SIM */
public class Main {
    public static void main(String[] args) {
        Sim sim = new Sim();
        char sc;
        do {
            menu();
            sc = Input.leggiChar('a','g',"Scelta: ");
            switch (sc) {
                case 'a': {
                    attivaSim(sim);
                    break;
                }
                case 'b': {
                    ricaricaSim(sim);
                    break;
                }
                case 'c': {
                    chiama(sim);
                    break;
                }
                case 'd': {
                    showOre(sim);
                    break;
                }
                case 'e': {
                    disattivaSim(sim);
                    break;
                }
                case 'f':{
                    statoSim(sim);
                    break;
                }
            }
        }while(sc!='g');
    }

    private static void statoSim(Sim sim) {
        String status = sim.toString();
        System.out.println(status);
    }

    private static void showOre(Sim sim) {
        String ore = sim.oreChiamata();
        System.out.println(ore);
    }

    private static void disattivaSim(Sim sim) {
        sim.setActive(false);
        System.out.println("Sim disattivata con successo");
    }


    public static void menu(){
        System.out.println("a)Attiva SIM");
        System.out.println("b)Ricarica SIM");
        System.out.println("c)Chiama");
        System.out.println("d)Mostra minuti");
        System.out.println("e)Disattiva SIM");
        System.out.println("f)Mostra status SIM");
        System.out.println("g) Termina programma");
    }
    public static void attivaSim(Sim sim){
        sim.setActive(true);
        System.out.println("Sim attivata con successo");
    }
    public static void ricaricaSim(Sim sim){
        char sc;
        System.out.println("Scegliere il taglio della ricarica");
        System.out.println("a) 5 €");
        System.out.println("b) 10 €");
        System.out.println("c) 20 €");
        sc = Input.leggiChar('a','c',"Scelta:");
        switch (sc){
            case 'a':{
                sim.addCredito(5f);
                break;
            }
            case 'b':{
                sim.addCredito(10f);
                break;
            }
            case 'c':{
                sim.addCredito(20f);
                break;
            }

        }

    }
    public static void chiama(Sim sim){
        int minuti = Input.leggiInt(0,Integer.MAX_VALUE,"Per quanti minuti si desidera chiamare");
        int status = sim.call(minuti);
        switch (status){
            case 0:{
                System.out.println("Impossibile chiamare, la SIM non è attiva");
            }
            case 1:{
                System.out.println("La chiamata è andata a buon fine");
            }
            case 2:{
                System.out.println("Impossibile chiamare, credito insufficiente");
            }
        }
    }
}