public class Sim {
    private String nome;
    private String iccId;
    private String numero;
    private float credito;
    private int minuti;
    private boolean isActive;

    //COSTRUTTORI
    public Sim(){
        setActive(false);
        setCredito(5);
        setNome("Mario Rossi");
        setNumero("1235468790");
        setIccId("12345678901234567890");
        setMinuti(0);
    }

    public Sim(boolean active,float credito,String nome,String numero,String iccId,int minuti){
        setActive(active);
        setCredito(credito);
        setNome(nome);
        setNumero(numero);
        setIccId(iccId);
        setMinuti(minuti);
    }

    public Sim(Sim a){
        setActive(a.isActive);
        setCredito(a.credito);
        setNome(a.nome);
        setNumero(a.numero);
        setIccId(a.iccId);
        setMinuti(a.minuti);
    }
    //SETTER
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
            this.nome = "Mario Rossi";
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



}
