import java.util.StringTokenizer;

public class Operaio extends Dipendente implements FileCSV{
    private double pagaOra;
    private int orePermesso;
    private int oreStraordinario;

    public Operaio(int mat, String nome, String cog, String data, double pagaOra, int orePermesso, int oreStraordinario) throws IllegalArgumentException {
        super(mat, nome, cog, data);
        setPagaOra(pagaOra);
        setOrePermesso(orePermesso);
        setOreStraordinario(oreStraordinario);
    }

    @Override
    public String stampaDati() {
        return "Matricola: "+mat+" Nome: "+nome+" Cognome: "+cog+" Ore lavorate: "+(160-orePermesso+oreStraordinario);
    }

    @Override
    public double calcolaPaga() {
        double paga;
        if(orePermesso == oreStraordinario)
            paga = 160*pagaOra;
        else
            if(orePermesso > oreStraordinario)
                paga = 160*pagaOra - orePermesso*pagaOra;
            else
                paga = 160*pagaOra + (oreStraordinario-orePermesso)*pagaOra*1.3;
        return paga;
    }

    public void setOrePermesso(int orePermesso) {
        if(orePermesso >= 0)
            this.orePermesso = orePermesso;
        else
            throw new IllegalArgumentException("Ore permesso non valide");
    }

    public void setOreStraordinario(int oreStraordinario) {
        if(oreStraordinario >= 0)
            this.oreStraordinario = oreStraordinario;
        else
            throw new IllegalArgumentException("Ore straordinario non valide");
    }

    public void setPagaOra(double pagaOra) {
        if(pagaOra >= 0)
            this.pagaOra = pagaOra;
        else
            throw new IllegalArgumentException("Paga oraria non valida");
    }

    public double getPagaOra() {
        return pagaOra;
    }

    public int getOrePermesso() {
        return orePermesso;
    }

    public int getOreStraordinario() {
        return oreStraordinario;
    }

    @Override
    public void fromCsv(String csv) {
        StringTokenizer strtok = new StringTokenizer(csv, ",");
        mat = Integer.parseInt(strtok.nextToken());
        nome = strtok.nextToken();
        cog = strtok.nextToken();
        data = strtok.nextToken();
        pagaOra = Double.parseDouble(strtok.nextToken());
        orePermesso = Integer.parseInt(strtok.nextToken());
        oreStraordinario = Integer.parseInt(strtok.nextToken());
    }

    @Override
    public String toCsv() {
        return mat+";"+nome+";"+cog+";"+data+";"+pagaOra+";"+orePermesso+";"+oreStraordinario;
    }
}
