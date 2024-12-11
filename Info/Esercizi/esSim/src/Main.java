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

    private static void aggiungiMagazzino(Negozio negozio) {
        int num = Input.leggiInt(0,Integer.MAX_VALUE,"Inserire il numero di Sim con il quale rifornirsi");
        Sim sim;
        for(int i=0;i<num;i++){
            String operator = Input.leggiStr("Inserire nome operatore");

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
    public static void menu(){
        System.out.println("a)Attiva SIM");
        System.out.println("b)Ricarica SIM");
        System.out.println("c)Chiama");
        System.out.println("d)Mostra minuti");
        System.out.println("e)Disattiva SIM");
        System.out.println("f)Mostra status SIM");
        System.out.println("g) Termina programma");
    }

    }
}