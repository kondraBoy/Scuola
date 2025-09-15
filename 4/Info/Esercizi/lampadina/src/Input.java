import java.util.InputMismatchException;
import java.util.Scanner;
public class Input {
    public static int leggiInt (int vmin, int vmax,String msg){
        int n=0;
        boolean err;
        do{
            System.out.println(msg);
            Scanner input = new Scanner(System.in);
            err = false;
            try {
                n = input.nextInt();
                input.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Ciò che hai inserito non è un numero");
                err = true;
            }
            if(n<vmin || n>vmax)
                System.out.println("Errore");
        }while((n<vmin || n>vmax) || err);
        return n;
    }

    public static char leggiChar (char vmin, char vmax,String msg){
        char c='.';
        boolean err;
        do{
            System.out.println(msg);
            Scanner input = new Scanner(System.in);
            err = false;
            try {
                c = input.nextLine().charAt(0);
                input.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Ciò che hai inserito non è un carattere");
                err = true;
            }
            if(c<vmin || c>vmax)
                System.out.println("Errore");
        }while((c<vmin || c>vmax) || err);
        return c;
    }

    public static float leggiFloat (float vmin, float vmax,String msg){
        float n=0;
        boolean err;
        do{
            System.out.println(msg);
            Scanner input = new Scanner(System.in);
            err = false;
            try {
                n = input.nextFloat();
                input.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Ciò che hai inserito non è un numero decimale");
                err = true;
            }
            if(n<vmin || n>vmax)
                System.out.println("Errore");
        }while((n<vmin || n>vmax) || err);
        return n;
    }

    public static Double leggiDouble (double vmin, double vmax,String msg){
        double n=0;
        boolean err;
        do{
            System.out.println(msg);
            Scanner input = new Scanner(System.in);
            err = false;
            try {
                n = input.nextFloat();
                input.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Ciò che hai inserito non è un numero decimale");
                err = true;
            }
            if(n<vmin || n>vmax)
                System.out.println("Errore");
        }while((n<vmin || n>vmax) || err);
        return n;
    }

    public static String leggiStr(String msg) {
        String s="";
        boolean err;
        do{
            System.out.println(msg);
            Scanner input = new Scanner(System.in);
            err = false;
            try {
                s = input.nextLine();
                input.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Ciò che hai inserito non è una Stringa");
                err = true;
            }
            if(s.trim().isEmpty())
                System.out.println("Errore");
        }while(s.trim().isEmpty() || err);
        return s;
    }

}
