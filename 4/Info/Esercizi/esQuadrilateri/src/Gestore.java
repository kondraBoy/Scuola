import java.util.LinkedList;

public class Gestore {
    private LinkedList<Figura> figure;

    public Gestore() {
        figure = new LinkedList<>();
    }

    public void add(Figura figura) {
        figure.add(figura);
    }

    public String toString(){
        String s="";
        for (Figura fig: figure){
            s+=fig.toString()+"\n";
        }
        return s;
    }

    public String elencoAree() {
        String s="";
        for (Figura fig: figure){
            s+=fig.getArea()+"\n";
        }
        return s;
    }
}
