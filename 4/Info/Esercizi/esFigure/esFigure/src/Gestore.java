import java.io.*;
import java.util.*;

public class Gestore {
    private List<Figura> figure;

    public Gestore() {
        figure = new ArrayList<>();
    }


    public void add(Figura figura) {
        figure.add(figura);
    }


    public void esporta(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Figura figura : figure) {
            writer.write(figura.toCsv());
            writer.newLine();
        }
        writer.close();
    }

    public void importa(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("quadrilatero")) {
                Quadrilateri quadrilatero = new Quadrilateri(0, 0);
                quadrilatero.fromCsv(line);
                add(quadrilatero);
            } else if (line.startsWith("triangolo")) {
                Triangoli triangolo = new Triangoli(0, 0, 0);
                triangolo.fromCsv(line);
                add(triangolo);
            }
        }
        reader.close();
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Figura figura : figure) {
            sb.append(figura.toString()).append("\n");
        }
        return sb.toString();
    }


    public String elencoAree() {
        StringBuilder sb = new StringBuilder();
        for (Figura figura : figure) {
            sb.append(figura.getArea()).append("\n");
        }
        return sb.toString();
    }
}
