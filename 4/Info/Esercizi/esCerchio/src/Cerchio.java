public class Cerchio {
    private double raggio;
    private double centroX;
    private double centroY;


    public double area(){
        double area;
        area = Math.pow(this.raggio,2) * Math.PI;
        return area;
    }

    public double perimetro(){
        double perimetro;
        perimetro = 2 * this.raggio * Math.PI;
        return perimetro;
    }

    public boolean appartiene(double px, double py) {
        boolean appart;
        double distanza = Math.sqrt(Math.pow(px - centroX, 2) + Math.pow(py - centroY, 2));
        if(distanza==this.raggio){
            appart = true;
        }else
            appart = false;
        return appart;
    }

    public int quadrante(double x, double y) {
        int n;
        if (x > 0 && y > 0) {
            n=1;
        } else if (x < 0 && y > 0) {
            n=2;
        } else if (x < 0 && y < 0) {
            n=3;
        } else if (x > 0 && y < 0) {
            n=4;
        } else if (x == 0 && y != 0) {
            n=5; //asse Y
        } else if (y == 0 && x != 0) {
            n=6; //asse X
        } else {
            n=8; //Origine
        }
        return n;
    }

    private boolean checkRaggio(double raggio){
        boolean check = true;
        if(raggio<0) {
            System.out.println("Il raggio inserito non e corretto");
            check = false;
        }
        return check;
    }


    //SETTER
    public void setRaggio(double raggio) {
        if (checkRaggio(raggio))
            this.raggio = raggio;
        else
            System.out.println("Il raggio non e corretto");
    }


    public void setCentro(double centroX, double centroY) {
        this.centroY = centroY;
        this.centroX = centroX;
    }

    //GETTER
    public double getRaggio() {
        return raggio;
    }

    public double getCentroX() {
        return centroX;
    }

    public double getCentroY() {
        return centroY;
    }
    //COSTRUTTORI
    public Cerchio(){
        setRaggio(5);
        setCentro(0,0);
    }

    public Cerchio(double raggio,double centroX,double centroY){
        setRaggio(raggio);
        setCentro(centroX,centroY);
    }

    public Cerchio(Cerchio a){
        setRaggio(a.raggio);
        setCentro(a.centroX,a.centroY);
    }
}
