import java.util.Scanner;

/*Andrea Guarino 4BI
L'indice di massa corporea si calcola
IMC = massa corporea / altezza^2.
Secondo l'Organizzazione Mondiale della Sanità l'IMC, o indice di massa corporea, è raggruppabile in 4 categorie:
sottopeso (IMC al di sotto di 19)
normale (IMC compreso tra 19 e 24)
sovrappeso (IMC compreso tra 25 e 30)
obesità (IMC al di sopra di 30).




*/
public class Main{
    public static void main (String []args){
        Scanner input = new Scanner(System.in);
        System.out.println("Inserire la propria massa in kg");
        float massa= input.nextFloat();
        System.out.println("Inserire la propria altezza in metri");
        float altezza= input.nextFloat();
        float imc = calcoloIMC(massa,altezza);
        stampaStatus(imc);
    }

    public static float calcoloIMC(float massa, float altezza){
        return massa/(altezza*altezza);
    }

    public static void stampaStatus(float imc){
        if(imc < 19){
            System.out.println("Il tuo IMC è : " + imc + " Sei sottopeso");
        }
        if(imc>= 19 && imc<=24){
            System.out.println("Il tuo IMC è : " + imc + " Sei normale");
        }
        if(imc>24 && imc<30){
            System.out.println("Il tuo IMC è : " + imc + " Sei sovrappeso");
        }
        if(imc>= 30){
            System.out.println("Il tuo IMC è : " + imc + " Sei obeso");
        }
    }
}