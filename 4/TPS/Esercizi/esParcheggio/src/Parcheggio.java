public class Parcheggio {
    private int numPosti;
    private int maxPosti;

    public int getNumPosti() {
        return numPosti;
    }

    public void setNumPosti(int numPosti) {
        if(numPosti < 0)
            throw new IllegalArgumentException("Posti mancanti");
        else
            this.numPosti = numPosti;
    }

    public Parcheggio(){
        setNumPosti(0);
    }

    public void entra(){
        numPosti--;
    }

    public void esce(){
        numPosti++;
    }

    public void setMaxPosti(int maxPosti) {
        if(maxPosti < 0)
            throw new IllegalArgumentException("Posti mancanti");
        else
            this.numPosti = numPosti;
    }
}
