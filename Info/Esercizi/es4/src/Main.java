/*Andrea Guarino 4BI
Scrivi un algoritmo che legga una sequenza di voti (tra 1 e 10). Quando viene inserito 0, viene stampata la media dei voti inseriti.


*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float voto;
        float somma = 0;
        int count = 0;

        do {
            System.out.print("Inserisci un voto (1-10) o 0 per terminare: ");
            voto = input.nextFloat();
            if (voto >= 1 && voto <= 10) {
                somma += voto;
                count++;
            } else if (voto != 0) {
                System.out.println("Voto non valido. Inserisci un voto tra 1 e 10.");
            }
        } while (voto != 0);
        if (count == 0) {
            System.out.println("Media non effettuabile");
        } else {
            float media = somma / count;
            System.out.println("La media dei voti inseriti è: " + media);
        }
    }
}
