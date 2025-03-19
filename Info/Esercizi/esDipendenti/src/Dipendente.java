public abstract class Dipendente implements Comparable<Dipendente> , FileCSV{
    protected int mat;
    protected String nome,cog,data;

    public abstract String stampaDati();
    public abstract double calcolaPaga();

    public Dipendente(int mat, String nome, String cog, String data) throws IllegalArgumentException {
        setMat(mat);
        setNome(nome);
        setCog(cog);
        setData(data);
    }

    public Dipendente() {
        this.mat=0;
        this.nome="";
        this.cog="";
        this.data="";
    }
    public void setMat(int mat) {
        if(mat >= 0)
            this.mat = mat;
        else
            throw new IllegalArgumentException("Matricola non valida");
    }

    public void setNome(String nome) {
        if(nome != null)
            this.nome = nome;
        else
            throw new IllegalArgumentException("Nome non valido");
    }

    public void setCog(String cog) {
        if(cog != null)
            this.cog = cog;
        else
            throw new IllegalArgumentException("Cognome non valido");
    }

    public void setData(String data) {
        if(data != null)
            this.data = data;
        else
            throw new IllegalArgumentException("Data di nascita non valida");
    }

    public String getNome() {
        return nome;
    }

    public int getMat() {
        return mat;
    }

    public String getCog() {
        return cog;
    }

    public String getData() {
        return data;
    }

    @Override
    public int compareTo(Dipendente o) {
        int n;
        if(this.mat < o.mat)
            n = -1;
        else
            if(this.mat > o.mat)
                n = 1;
            else
                n = 0;
        return n;
    }
}
