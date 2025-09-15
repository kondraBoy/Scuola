import java.util.LinkedList;

/*
1. Attivare una SIM

2. Disattivare una SIM

3. Acquisto SIM da parte del negozio. Le SIM acquistate dal negozio andranno in magazzino.

4. Ricaricare una SIM: si dovrà chiedere l’operatore, il numero di telefono e l’importo della ricarica

5. Richiedere la portabilità del numero: si dovrà chiedere l’ICCID della sim, il numero di telefono di cui effettuare la portabilità, l’operatore attuale e il nuovo operatore. Nella fase di portabilità si dovrà chiedere all’utente se trasferire o meno il credito residuo.

6. Visualizzare le SIM attive/disattive in negozio in base alla scelta dell’utente.
*/
public class Main {
    public static void main(String[] args) {
        Negozio negozio = new Negozio();
        char sc;
        do {
            menu();
            sc = Input.leggiChar('a','g',"Scelta: ");
            switch (sc) {
                case 'a': {
                    attivaSim(negozio);
                    break;
                }
                case 'b': {
                    disattivaSim(negozio);
                    break;
                }
                case 'c': {
                    aggiungiMagazzino(negozio);
                    break;
                }
                case 'd': {
                    ricaricaSim(negozio);
                    break;
                }
                case 'e': {
                    portabilitaSim(negozio);
                    break;
                }
                case 'f':{

                    break;
                }
            }
        }while(sc!='g');
    }

    private static void aggiungiMagazzino(Negozio negozio) {
        int num = Input.leggiInt(0,Integer.MAX_VALUE,"Inserire il numero di Sim con il quale rifornirsi");
        Sim sim;
        for(int i=0;i<num;i++){
            String operatore = Input.leggiStr("Inserire nome operatore");
            String Iccid = Input.leggiStr("Inserire Iccid");
            String numero = Input.leggiStr("Inserire numero");
            sim = new Sim("NULL",operatore,numero,Iccid);
            negozio.addSimToStorage(sim);
        }
    }
    private static void disattivaSim(Negozio negozio) {
        String iccid = Input.leggiStr("Inserire l'iccid della sim da disattivare");
        if(negozio.deactivateSim(iccid)){
            System.out.println("Sim disattivata con successo");
        }else
            System.out.println("Sim non disattivata, l' Iccid inserito non esiste");
    }


    public static void attivaSim(Negozio negozio){
        String msg, nome;
        nome = Input.leggiStr("Inserisci il nome dell'intestatario sim");
        msg = negozio.sellSim(nome);
        System.out.println(msg);
    }
    public static void ricaricaSim(Negozio negozio){
        char sc;
        String numero = Input.leggiStr("Inserisci il numero di cui effettuare la ricarica");
        String operatore = Input.leggiStr("Inserisci l'operatore del numero telefonico");
        Sim sim = negozio.findNumeroOperatore(numero,operatore);
        if(sim == null){
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
        }else{
            System.out.println("Il numero inserito è inesistente, quindi è impossibile effettuare la ricarica");
        }
    }

    private static void portabilitaSim(Negozio negozio) {
        String iccid = Input.leggiStr("Inserisci iccid scheda sim");
        String numero = Input.leggiStr("Inserisci numero di telefono da portare");
        String operatoreAttuale = Input.leggiStr("Inserisci l'operatore attuale");
        String nuovoOperatore = Input.leggiStr("Inserire Il nuovo operatore");
        Sim sim = negozio.findNumeroOperatoreIccid(numero, operatoreAttuale,iccid);
        Sim newSim;
        if(sim!=null){
            int sc = Input.leggiInt(0,1,"Vuoi trasferire il credito (1 si/0 no)");
            switch (sc){
                case 0:{
                    newSim = new Sim(sim);
                    newSim.setOperatore(nuovoOperatore);
                    newSim.setCredito(0);
                    negozio.addSimToSold(newSim);
                }
                case 1:{
                    newSim = new Sim(sim);
                    newSim.setOperatore(nuovoOperatore);
                    negozio.addSimToSold(newSim);
                }
            }
        }else
            System.out.println("Non è stata trovata la sim");
    }


    public static void visualizzaSim(Negozio negozio) {
        char scelta = Input.leggiChar('a', 'b', "a) Visualizza SIM attive\nb) Visualizza SIM disattive\nScelta: ");

        LinkedList<Sim> simsDaVisualizzare = negozio.getSimToVisualize(scelta == 'a');

        if (simsDaVisualizzare.isEmpty()) {
            System.out.println("Nessuna SIM trovata.");
        } else {
            for (Sim sim : simsDaVisualizzare) {
                System.out.println(sim);
            }
        }
    }






    public static void menu(){
        System.out.println("a) Attiva SIM");
        System.out.println("b) Disattiva SIM");
        System.out.println("c) Aggiungi SIM a magazzino");
        System.out.println("d) Ricarica SIM");
        System.out.println("e) Richiedi portabilità numero");
        System.out.println("f) Visualizza SIM attive/disattive");
        System.out.println("g) Termina programma");
    }

}
