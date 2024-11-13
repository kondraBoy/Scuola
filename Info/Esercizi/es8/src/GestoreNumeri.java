public class GestoreNumeri {
    private final int NMAX = 100;
    private int vmin;
    private int vmax;
    private int numeri[];
    private boolean pari;
    private int lastNumero;















    //COSTRUTTORI

    public GestoreNumeri(){
       setVmin(0);
       setVmax(200);
       setPari(true);
       this.numeri = new int[NMAX];
    }

    public GestoreNumeri(int vmin, int vmax,boolean pari){
        setVmin(vmin);
        setVmax(vmax);
        setPari(pari);
        this.numeri = new int[NMAX];
    }
    public gestoreNumeri(GestoreNumeri a){
        setVmin(a.vmin);
        setVmax(a.vmax);
        setPari(a.pari);
        this.numeri = new int[NMAX];
    }

    //SETTER
    public boolean setVmin(int vmin){
        boolean check;
        if(vmin>this.vmax){
            check=false;
        }else{
            this.vmin=vmin;
        }
        return check;
    }

    public boolean setVmax(int vmax) {
        boolean check;
        if(vmax<0){
            check=false;
        }else{
            this.vmax=vmax;
        }
        return check;
    }

    public void setPari(boolean pari) {
        this.pari=pari;
    }

    //GETTER

    public int getVmax() {
        return vmax;
    }

    public int getVmin() {
        return vmin;
    }

    public boolean getPari(){
        return pari;
    }
}
