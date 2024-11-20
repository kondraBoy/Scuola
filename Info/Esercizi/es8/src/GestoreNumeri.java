public class GestoreNumeri {
    private final int NMAX = 100;
    private int vmin;
    private int vmax;
    private int numeri[];
    private boolean pari;
    private int lastNumero;




    //METODI
    public int findMAXorMin(int num){
        int number= this.numeri[0];
        if(num==1){
            for(int i=0;i<this.lastNumero;i++){
                if(this.numeri[i]>number)
                    number=this.numeri[i];
            }
        }
        if(num==2){
            for(int i=0;i<this.lastNumero;i++){
                if(this.numeri[i]<number)
                    number=this.numeri[i];
            }
        }
        if(num!=1 && num!=2)
            number=-1;
        return number;
    }

    public double mediaNumbers(){
        int somma=0;
        double media=-1;
        for(int i=0;i<this.lastNumero;i++){
            somma=+this.numeri[i];
        }
        media=(double)somma/this.lastNumero;
        return media;
    }

    public String csvStringNumbers(){
        String csvString = "";
        for(int i=0;i<this.lastNumero;i++){
            csvString += this.numeri[i] + ";";
        }
        return csvString;
    }

    public boolean addNumber(int num){
        boolean check=false;
        if(this.pari==true && num%2==0 && num>=this.vmin && num<=this.vmax){
            this.numeri[this.lastNumero]=num;
            check=true;
            this.lastNumero++;
        }
        return check;
    }


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
    public void GestoreNumeri(GestoreNumeri a){
        setVmin(a.vmin);
        setVmax(a.vmax);
        setPari(a.pari);
        this.numeri = new int[NMAX];
    }

    //SETTER




    public void setVmin(int vmin){
        if(vmin>this.vmax)
            this.vmin = 0;
        else
            this.vmin = vmin;
    }

    public void setVmax(int vmax) {
        if(vmax < this.vmin)
            this.vmax = 200;
        else
            this.vmax = vmax;
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
