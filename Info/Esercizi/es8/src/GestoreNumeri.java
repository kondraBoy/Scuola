public class GestoreNumeri {
    private int NMAX;
    private int vmin;
    private int vmax;
    private int numeri[];
    private boolean pari;
    private int lastNumero;






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
        media=somma/this.lastNumero;
        return media;
    }

    public String csvStringNumbers(){
        String csvString = this.numeri[0] + ";";
        for(int i=1;i<this.lastNumero;i++){
            csvString += this.numeri[i] + ";";
        }
        return csvString;
    }

    public boolean addNumber(int num){
        boolean check=false;
        if(this.pari==true && num%2==0){
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

    public int setNMAX(int NMAX) {
        if(!checkNMAX(NMAX)){
            return -1;
        }else
            this.NMAX=NMAX;
    }


    public boolean setVmin(int vmin){
        boolean check = true;
        if(vmin>this.vmax){
            check=false;
        }else{
            this.vmin=vmin;
        }
        return check;
    }

    public boolean setVmax(int vmax) {
        boolean check = true;
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

    //CHECKER
    private boolean checkNMAX(int NMAX){
        boolean check;
        if(NMAX<0){
            check = false;
        return check;
    }
}
