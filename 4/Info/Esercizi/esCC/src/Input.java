
import java.util.Scanner;
public class Input {
    public static int leggiInt (int vmin, int vmax,String msg){
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println(msg);
        do{
            n=input.nextInt();
            if(n<vmin || n>vmax)
                System.out.println("Errore");
        }while(n<vmin || n>vmax);
        return n;
    }

    public static char leggiChar (char vmin, char vmax,String msg){
        char c;
        Scanner input = new Scanner(System.in);
        System.out.println(msg);
        do{
            c=input.next().charAt(0);
            if(c<vmin || c>vmax)
                System.out.println("Errore");
        }while(c<vmin || c>vmax);
        return c;
    }

    public static float leggiFloat (float vmin, float vmax,String msg){
        float n;
        Scanner input = new Scanner(System.in);
        System.out.println(msg);
        do{
            n=input.nextFloat();
            if(n<vmin || n>vmax)
                System.out.println("Errore");
        }while(n<vmin || n>vmax);
        return n;
    }

    public static Double leggiDouble (double vmin, double vmax,String msg){
        double n;
        Scanner input = new Scanner(System.in);
        System.out.println(msg);
        do{
            n=input.nextDouble();
            if(n<vmin || n>vmax)
                System.out.println("Errore");
        }while(n<vmin || n>vmax);
        return n;
    }

    public static String leggiStr(String msg) {
        String s;
        Scanner input = new Scanner(System.in);
        System.out.println(msg);
        do {
            s = input.next();
            if (s.trim().isEmpty()) {
                System.out.println("Errore");
            }
        } while (s.trim().isEmpty());
        return s;
    }

}
