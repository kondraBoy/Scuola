public abstract class Figura implements FileCSV {
    protected float area;
    protected float perimetro;

    public abstract float area();

    public abstract float perimetro();

    public float getArea() {
        return area();
    }

    public float getPerimetro() {
        return perimetro();
    }


    public String toCsv() {
        return "";
    }

    public void fromCsv(String csv) {

    }
}
