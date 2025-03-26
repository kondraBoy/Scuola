import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
@SuppressWarnings("all")
public class Azienda {
    private MyList<Dipendente> dipendenti;
    private String nome;
    private String responsabile;
    private String indirizzo;
    private String sitoWeb;
    private String email;

    public Azienda() {
        this.dipendenti = new MyList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getEmail() {
        return email;
    }

    public String getResponsabile() {
        return responsabile;
    }

    public String getSitoWeb() {
        return sitoWeb;
    }

    public void setNome(String nome) {
        if(!nome.trim().isEmpty())
            this.nome = nome;
        else
            throw new IllegalArgumentException("Nome non valido");
    }

    public void setIndirizzo(String indirizzo) {
        if(!indirizzo.trim().isEmpty())
            this.indirizzo = indirizzo;
        else
            throw new IllegalArgumentException("Indirizzo non valido");
    }

    public void setEmail(String email) {
        if(!email.trim().isEmpty())
            this.email = email;
        else
            throw new IllegalArgumentException("Email non valida");
    }

    public void setResponsabile(String responsabile) {
        if(!responsabile.trim().isEmpty())
            this.responsabile = responsabile;
        else
            throw new IllegalArgumentException("Responsabile non valido");
    }

    public void setSitoWeb(String sitoWeb) {
        if(!sitoWeb.trim().isEmpty())
            this.sitoWeb = sitoWeb;
        else
            throw new IllegalArgumentException("Sito web non valido");
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

    public double calcolaStipendi(){
        double tot=0;
        Dipendente current = dipendenti.getFirst();
        while (current != null) {
            tot += current.calcolaPaga();
        }
        return tot;
    }

    public void esportaOrdinato(String filename, String t) throws IOException {
        Dipendente d;
        PrintWriter fout;
        StringBuilder s = new StringBuilder();
        for (int k = 0; k < dipendenti.size(); k++) {
            d = dipendenti.get(k);
            if (d.getClass().toString().contains("Impiegato") && (t.compareTo("Impiegato") == 0 || t.compareTo("impiegato")==0))  {
                s.append(d.toCsv());
                s.append('\n');
            }else if (d.getClass().toString().contains("Operaio") && (t.compareTo("Operaio") == 0 || t.compareTo("operaio")==0)) {
                s.append(d.toCsv());
                s.append('\n');
            }
            if(!s.isEmpty()){
                fout = new PrintWriter(new FileWriter(filename));
                fout.print(s);
                fout.close();
            }
            else
                throw new NoSuchElementException("Nessun dipendente di tale tipo trovato");


        }
    }
}