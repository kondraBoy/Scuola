public class Cc {
    private double saldo;
    private String nome;
    private String cognome;



    public void addSaldo(double add){
        if(checkPositivoDouble(add)){
            this.saldo=this.saldo+add;
        }
    }

    public void removeSaldo(double rem){
        if(checkPositivoDouble(rem) && rem<=this.saldo){
            this.saldo=this.saldo-rem;
        }
    }



    //COSTRUTTORI
    public Cc(){
        setNome("Mario");
        setCognome("Rossi");
        setSaldo(0);
    }

    public Cc(double saldo,String nome,String cognome){
        setSaldo(saldo);
        setNome(nome);
        setCognome(cognome);
    }

    public Cc(Cc a){
        setCognome(a.cognome);
        setNome(a.nome);
        setSaldo(a.saldo);
    }

    //SETTER

    public void setCognome(String cognome) {
        if(checkStr(cognome)){
            this.cognome = cognome;
        }
    }

    public void setNome(String nome) {
        if(checkStr(nome)){
            this.nome = nome;
        }
    }

    public void setSaldo(double saldo) {
        if(checkPositivoDouble(saldo)){
            this.saldo = saldo;
        }
    }
    //GETTER


    public double getSaldo() {
        return saldo;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    //CHECKER
    private boolean checkPositivoDouble(double num){
        boolean check = true;
        if(saldo<0){
            System.out.println("Il saldo non può essere minore di 0");
            check = false;
        }
        return check;
    }

    private boolean checkStr(String s){
        boolean check = true;
        if (s.trim().isEmpty()) {
            System.out.println("Errore");
            check = false;
        }
        return check;
    }
}


