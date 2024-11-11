import java.util.Scanner;

/*Andrea Guarino 4BI
Leggere una sequenza di numeri interi. Terminare la lettura quando si incontra un valore pari a 9999.
 Determinare quanti sono stati i valori pari e i valori dispari.

*/
public class Main {
    public static void main(String[] args) {
        int num,countPari=0,countDispari=0;
        Scanner input = new Scanner(System.in);
        do{
            num = input.nextInt();
            if(num!=9999){
                if(num%2==0){
                    countPari++;
                }else
                    countDispari++;
            }
        }while(num!=9999);
        System.out.println("Il numero di numeri pari inseriti è: "+ countPari);
        System.out.println("Il numero di numeri dispari inseriti è: "+ countDispari);
    }
}