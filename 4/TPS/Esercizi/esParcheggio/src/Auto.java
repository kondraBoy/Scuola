public class Auto extends Thread{
    private String targa;

    public Auto(String targa){
        setTarga(targa);
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        if(targa.trim().isEmpty())
            throw new IllegalArgumentException("targa vuota");
        else{
            this.targa = targa;
            setName(targa);
        }
    }

    public void entra(){

    }
}
