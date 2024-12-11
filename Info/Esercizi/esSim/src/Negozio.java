import java.util.LinkedList;

public class Negozio {
    private String pIva,nome,indirizzo;
    private LinkedList<Sim> simSold,simBuy;
    
    public Negozio(){
        setNome("Mario Rossi");
        setpIva("00000000000");
        setIndirizzo("Via Romano Nicolo' 18");
    }

    public Negozio(String nome,String pIva,String indirizzo){
        setNome(nome);
        setIndirizzo(indirizzo);
        setpIva(pIva);
    }

    public void setNome(String nome) {
        if(nome.trim().isEmpty()){
            throw new IllegalArgumentException("Non è stato inserito nulla");
        }else
            this.nome = nome;
    }

    public void setIndirizzo(String indirizzo) {
        if(indirizzo.trim().isEmpty()){
            throw new IllegalArgumentException("Non è stato inserito nulla");
        }else
            this.indirizzo = indirizzo;
    }

    public void setpIva(String pIva) {
        if(pIva.trim().isEmpty()){
            throw new IllegalArgumentException("Non è stato inserito nulla");
        }else
            this.pIva = pIva;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getpIva() {
        return pIva;
    }

    public boolean addSimToStorage(Sim sim){
           boolean check = false;
           if(checkIccid(sim.getIccId()) == null && checkNumero(sim.getNumero()) == null)
           {
               check = true;
               this.simBuy.add(sim);
           }
           return check;
    }

    private Sim checkIccid(String iccid,LinkedList<Sim> lista){
        Sim find = null;
        for(int i=0; i<lista.size() && find==null;i++){
            Sim sim = lista.get(i);
            if(sim.getIccId().equals(iccid)){
                find = sim;
            }
        }
        return find;
    }

    private Sim checkNumero(String numero,LinkedList<Sim> lista){
        Sim find = null;
        for(int i=0; i<lista.size() && find==null;i++){
            Sim sim = lista.get(i);
            if(sim.getNumero().equals(numero)){
                find = sim;
            }
        }
        return find;
    }

    public String sellSim(String nome){
        String msg = "SIM venduta";
        Sim sim = this.simBuy.getLast();
        try{
            sim.setNome(nome);
        }catch (IllegalArgumentException e){
            msg = e.getMessage();
        }
        if(msg.equals("SIM venduta")){
            this.simBuy.remove(sim);
            this.simSold.add(sim);
        }
        return msg;
    }

    public boolean deactivateSim(String iccid){
        boolean deleted = false;
        Sim sim = checkIccid(iccid,simSold);
        if(sim!=null){
            sim.setActive(false);
            sim.setCredito(0);
            sim.setOperatore("NULL");
            sim.setNome("NULL");
            deleted = true;
            this.simSold.remove(sim);
        }
        return deleted;
    }



   

    
}
