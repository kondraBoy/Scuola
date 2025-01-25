import java.util.Date;
import java.util.StringTokenizer;

public class PacchettoAzionario implements FileCSV {
    private String nome;
    private double prezzo;
    private int quantita;
    private Date data;

    public PacchettoAzionario(String nome, double prezzo, int quantita, Date data) {
        setNome(nome);
        setPrezzo(prezzo)
        setQuantita(quantita);
        setData(data);
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome non valido");
        }else {
            this.nome = nome;
        }
    }
    public void setPrezzo(double prezzo) {
        if (prezzo < 0) {
            throw new IllegalArgumentException("Prezzo non valido");
        }else {
            this.prezzo = prezzo;
        }
    }

    public void setQuantita(int quantita) {
        if (quantita < 0) {
            throw new IllegalArgumentException("Quantità non valida");
        }else {
            this.quantita = quantita;
        }
    }

    public void setData(Date data) {
        if (data == null) {
            throw new IllegalArgumentException("Data non valida");
        }else {
            this.data = data;
        }
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public Date getData() {
        return data;
    }

    @Override
    public void fromCSV(String csv) {
        StringTokenizer strtok = new StringTokenizer(csv, ";");
        if (strtok.countTokens() != 4) {
            throw new IllegalArgumentException("CSV non valido");
        }else {
            setNome(strtok.nextToken());
            setPrezzo(Double.parseDouble(strtok.nextToken()));
            setQuantita(Integer.parseInt(strtok.nextToken()));
            setData(new Date(strtok.nextToken()));
        }
    }

    @Override
    public String toCSV() {
        return nome + ";" + prezzo + ";" + quantita + ";" + data.getDate();
    }
}
