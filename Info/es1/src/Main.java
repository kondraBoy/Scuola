import java.util.Scanner;

/*Andrea Guarino 4BI*/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float prz;
        prz=input.nextFloat();
        float przSconto=prezzoScontato(prz);
        System.out.println("Il prezzo scontato è: " + przSconto);
*/    }
    public static float prezzoScontato(float prezzo){
        float prezzoSconto;
        if(prezzo<=500){
            prezzoSconto=prezzo-(prezzo/100*20);
        }else{
            prezzoSconto=prezzo-(prezzo/100*25);
        }
        return prezzoSconto;
    }

}


