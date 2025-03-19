import java.util.StringTokenizer;

//per ogni ora vengono decurtati 20€ dallo stipendio
public class Impiegato extends Dipendente implements FileCSV{
    private double salario;
    private int orePermesso;
    private final double dec = 20d;


    public Impiegato(int mat, String nome, String cog, String data, double salario, int orePermesso) throws IllegalArgumentException {
        super(mat, nome, cog, data);
        setSalario(salario);
        setOrePermesso(orePermesso);
    }

    @Override
    public String stampaDati() {
        return "Matricola: "+mat+" Nome: "+nome+" Cognome: "+cog+" Salario: "+salario;
    }

    @Override
    public double calcolaPaga() {
        double paga = salario;
        if(orePermesso > 0)
            paga = salario - orePermesso*dec;
        return paga;
    }

    public void setSalario(double salario) {
        if(salario >= 0)
            this.salario = salario;
        else
            throw new IllegalArgumentException("Salario non valido");
    }

    public void setOrePermesso(int orePermesso) {
        if(orePermesso >= 0)
            this.orePermesso = orePermesso;
        else
            throw new IllegalArgumentException("Ore permesso non valide");
    }

    public double getSalario() {
        return salario;
    }

    public int getOrePermesso() {
        return orePermesso;
    }

    @Override
    public void fromCsv(String csv) {
        StringTokenizer strtok = new StringTokenizer(csv, ",");
        mat = Integer.parseInt(strtok.nextToken());
        nome = strtok.nextToken();
        cog = strtok.nextToken();
        data = strtok.nextToken();
        salario = Double.parseDouble(strtok.nextToken());
        orePermesso = Integer.parseInt(strtok.nextToken());
    }

    @Override
    public String toCsv() {
        return mat+";"+nome+";"+cog+";"+data+";"+salario+";"+orePermesso;
    }
}
