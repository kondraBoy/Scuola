import java.util.StringTokenizer;
public class Triangoli extends Figura{
    private float l1, l2, l3;

    public Triangoli(float l1, float l2, float l3) {
        if (!doExist(l1, l2, l3)) {
            throw new IllegalArgumentException("I lati forniti non possono formare un triangolo.");
        }
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    public void setL1(float l1) {
        if (l1 <= 0) {
            throw new IllegalArgumentException("Il lato deve essere maggiore di 0.");
        }
        if (!doExist(l1, this.l2, this.l3)) {
            throw new IllegalStateException("Non esiste un triangolo con questi lati.");
        }
        this.l1 = l1;
    }

    public void setL2(float l2) {
        if (l2 <= 0) {
            throw new IllegalArgumentException("Il lato deve essere maggiore di 0.");
        }
        if (!doExist(this.l1, l2, this.l3)) {
            throw new IllegalStateException("Non esiste un triangolo con questi lati.");
        }
        this.l2 = l2;
    }

    public void setL3(float l3) {
        if (l3 <= 0) {
            throw new IllegalArgumentException("Il lato deve essere maggiore di 0.");
        }
        if (!doExist(this.l1, this.l2, l3)) {
            throw new IllegalStateException("Non esiste un triangolo con questi lati.");
        }
        this.l3 = l3;
    }



    public float area() {
        double semiPerimetro = perimetro() / 2;
        super.area = (float) Math.sqrt(semiPerimetro * (semiPerimetro - l1) * (semiPerimetro - l2) * (semiPerimetro - l3));
        return super.area;
    }



    public float perimetro() {
        float perimetro = l1 + l2 + l3;
        super.perimetro = perimetro;
        return super.perimetro;
    }

    public static boolean doExist(double a, double b, double c) {
        if (a + b <= c) {
            return false;
        }
        if (a + c <= b) {
            return false;
        }
        if (b + c <= a) {
            return false;
        }
        return true;
    }

    @Override
    public void fromCsv(String csv) {
        StringTokenizer tokenizer = new StringTokenizer(csv, ",");
        if (tokenizer.countTokens() == 4 && tokenizer.nextToken().equals("triangolo")) {
            setL1(Float.parseFloat(tokenizer.nextToken()));
            setL2(Float.parseFloat(tokenizer.nextToken()));
            setL3(Float.parseFloat(tokenizer.nextToken()));
            if (!doExist(l1, l2, l3)) {
                throw new IllegalArgumentException("I lati non possono formare un triangolo.");
            }
        } else {
            throw new IllegalArgumentException("Formato CSV non valido per Triangolo.");
        }
    }

    @Override
    public String toCsv() {
        return "triangolo;" + l1 + ";" + l2 + ";" + l3 + ";\n";
    }

    @Override
    public String toString() {
        return "Triangolo: lato1=" + l1 + ", lato2=" + l2 + ", lato3=" + l3 + ", area=" + area() + ", perimetro=" + perimetro();
    }
}


