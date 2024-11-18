public class Cc {
    private float saldo;
    private String nome;
    private String cognome;



    public Double addSaldo(double add){

        if(checkPositivoDouble(add)){

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

    public void setSaldo(float saldo) {
        if(checkPositivoDouble(saldo)){
            this.saldo = saldo;
        }
    }
    //GETTER


    public float getSaldo() {
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


