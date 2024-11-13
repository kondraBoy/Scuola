import java.util.Scanner;

/*Andrea Guarino 4BI
Letta una temperatura, si vuole classificarla scrivendo in output un messaggio secondo il seguente schema:
da negativo a 0: molto fredda
da 0 a 10: freddo
da 10 a 16: fresco
da 16 a 25: mite
da 25 a 32: caldo
da 32 in poi: molto caldo





*/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float temp;
        temp = input.nextFloat();
        classificaCaldo(temp);

    }

    public static void classificaCaldo(float temp) {

        if (temp < 0) {
            System.out.println("Molto freddo");
        } else {
            if (temp >= 0 && temp <10) {
                System.out.println("Freddo");
            } else {
                if (temp >= 10 && temp < 16) {
                    System.out.println("Fresco");
                } else {
                    if (temp >= 16 && temp < 25) {
                        System.out.println("Mite");
                    } else {
                        if (temp >= 25 && temp < 32) {
                            System.out.println("Caldo");
                        } else {
                            if (temp >= 32) {
                                System.out.println("Molto caldo");
                            }
                        }
                    }
                }
            }
        }
    }
}




