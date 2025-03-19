public class Azienda {
    private MyList<Dipendente> dipendenti;

    public Azienda() {
        this.dipendenti = new MyList<>();
    }

    public void addImpiegato(Impiegato imp) {
        dipendenti.add(imp);
    }

    public void addOperario(Operaio op) {
        dipendenti.add(op);
    }

    public String stampaDipendenti(){
        String s="";
        Dipendente current = dipendenti.getFirst();
        while (current != null) {
            s += current.stampaDati()+"\n";
        }
        return s;
    }

    public String stampaDipendenti(double salario){
        String s="";
        Dipendente current = dipendenti.getFirst();
        while (current != null) {
            if(current.calcolaPaga() > salario)
                s += current.stampaDati()+"\n";
        }
        return s;
    }

    public void licenziaDipendente(int mat){
        int pos=-1;
        Dipendente current = dipendenti.getFirst();
        while (current != null && pos==-1) {
            if(current.getMat() == mat) {
                dipendenti.remove(current);
                pos=1;
            }
        }
    }
}
