import java.util.StringTokenizer;

public class Quadrilateri extends Figura{
    private float l1,l2;
    public Quadrilateri(){
        setL1(4);
        setL2(6);
    }

    public Quadrilateri(float l1, float l2){
        setL1(l1);
        setL2(l2);
    }

    public float getL1() {
        return l1;
    }

    public float getL2() {
        return l2;
    }

    public void setL1(float l1) {
        if(l1>0)
            this.l1 = l1;
        else if(l1==0 || l1 < 0)
            throw new IllegalArgumentException("Non si può avere un lato con misura 0");
    }

    public void setL2(float l2) {
        if (l2 > 0)
            this.l2 = l2;
        else if (l2 == 0 || l2 < 0)
            throw new IllegalArgumentException("Non si può avere un lato con misura 0");
    }

    @Override
    public float area() {
        return l1 * l2;
    }

    @Override
    public float perimetro() {
        return 2 * (l1 + l2);      }

    @Override
    public String toCsv() {
        return "quadrilatero;" + l1 + ";" + l2 + ";\n";
    }

    @Override
    public void fromCsv(String csv) {
        StringTokenizer tokenizer = new StringTokenizer(csv, ";");
        if (tokenizer.countTokens() == 3 && tokenizer.nextToken().equals("quadrilatero")) {
            setL1(Float.parseFloat(tokenizer.nextToken()));
            setL2(Float.parseFloat(tokenizer.nextToken()));
        } else {
            throw new IllegalArgumentException("Formato CSV non valido per Quadrilateri.");
        }
    }

    @Override
    public String toString() {
        return "Quadrilatero: lato1=" + l1 + ", lato2=" + l2 + ", area=" + area() + ", perimetro=" + perimetro();
    }

}

