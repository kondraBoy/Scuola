public class Sim implements Comparable<Sim> {
    private String nome;
    private String operatore;
    private String iccId;
    private String numero;
    private float credito;
    private int minuti;
    private boolean isActive;

    //COSTRUTTORI
    public Sim(){
        setActive(false);
        setOperatore("Tim");
        setCredito(5);
        setNome("NULL");
        setNumero("1235468790");
        setIccId("12345678901234567890");
        setMinuti(0);
    }

    public Sim(String nome,String operatore,String numero,String iccId){
        setOperatore("Postemobile");
        setActive(false);
        setCredito(0);
        setNome(nome);
        setNumero(numero);
        setIccId(iccId);
        setMinuti(0);
    }

    public Sim(Sim a){
        setActive(a.isActive());
        setCredito(a.getCredito());
        setNome(a.getNome());
        setNumero(a.getNumero());
        setIccId(a.getIccId());
        setMinuti(a.getMinuti());
    }
    //SETTER

    public void setOperatore(String operatore) {
        if (!(operatore.trim().isEmpty())) {
            this.operatore = operatore;
        } else
            this.operatore = "NULL";
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public void setCredito(float credito) {
        if(credito>=0){
            this.credito = credito;
        }
        else this.credito = 5;
    }

    public void setNome(String nome) {
        if (!(nome.trim().isEmpty())) {
            this.nome = nome;
        } else
            throw new IllegalArgumentException("Errore - nome intestatario errato - SIM NON ATTIVA");
    }
    public void setNumero(String numero) {
        if (!(numero.trim().isEmpty())) {
            this.numero = numero;
        } else
            this.numero = "1234567890";
    }

    public void setMinuti(int minuti) {
        if(minuti>=0){
            this.minuti = minuti;
        }
        else this.minuti = 0;
    }

    public void setIccId(String iccId) {
        if(!(iccId.trim().isEmpty())){
            this.iccId = iccId;
        }else{
            this.iccId = "12354678901234568790";
        }
    }

    //GETTER
    public float getCredito() {
        return credito;
    }

    public String getOperatore() { return operatore; }

    public boolean isActive() {
        return isActive;
    }

    public int getMinuti() {
        return minuti;
    }

    public String getIccId() {
        return iccId;
    }

    public String getNome() {
        return nome;
    }
    public String getNumero() {
        return numero;
    }
    //METODI
    public void addCredito(float credito){
        if(credito>0){
            this.credito=+credito;
        }
    }
    public int call(int minuti){
        int n;
        float creditoEnough;
        creditoEnough = this.credito * 0.32f;
        if(isActive()){
            if(creditoEnough>this.credito){
                n=1;
                this.credito=-creditoEnough;
            }else{
                n=2;
            }
        }else
            n=0;
        return n;
    }

   public String oreChiamata() {
       float ore = minuti / 60;
       float minutiCall = minuti % 60;
       String str = "Ore :" + ore + "Minuti :" + minutiCall;
       return str;
   }
    @Override
    public String toString() {
        return "Sim{" + "nome='" + nome + '\'' +
                ", iccId='" + iccId + '\'' +
                ", numero='" + numero + '\'' +
                ", credito=" + credito +
                ", minuti=" + minuti +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public int compareTo(Sim o) {
        int n;
        if(o.getIccId().compareTo(this.iccId)==0){
            n = 0;
        }
        if(o.getIccId().compareTo(this.iccId)>0){
            n = 1;
        }else
            n = -1;
        return n;
    }
    
}
