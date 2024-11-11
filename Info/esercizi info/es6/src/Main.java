
/*Andrea Guarino 4BI
Crea un programma organizzato a menu che permette di calcolare le aree di figure geometriche:
triangolo, rettangolo, rombo, trapezio, cerchio, poligono regolare.

Vincolo: utilizzare una funzione per ciascuna funzionalità.

*/
public class Main {
    public static void main(String[] args) {
        char sc;
        String s = Input.leggiStr("Inserisci stringa");
        System.out.println(s);
        do {
            menu();
            sc = Input.leggiChar('a','g',"Scelta: ");
            switch (sc) {
                case 'a': {
                    areaTriangolo();
                    break;
                }
                case 'b': {
                    areaRettangolo();
                    break;
                }
                case 'c': {
                    areaRombo();
                    break;
                }
                case 'd': {
                    areaTrapezio();
                    break;
                }
                case 'e': {
                    areaCerchio();
                    break;
                }
                case 'f': {
                    areaPoligonoRegolare();
                    break;
                }
            }
        }while(sc!='g');
    }

    public static void areaTriangolo(){
        float b,h,area;
        b=Input.leggiFloat(0,Float.MAX_VALUE,"Inserire la base del triangolo");
        h=Input.leggiFloat(0,Float.MAX_VALUE,"Inserire l'altezza del triangolo");
        area = (b*h/2);
        System.out.println("L'area del triangolo è: " + area);
    }

    public static void areaRettangolo(){
        float b,h,area;
        b=Input.leggiFloat(0,Float.MAX_VALUE,"Inserire la base del rettangolo");
        h=Input.leggiFloat(0,Float.MAX_VALUE,"Inserire l'altezza del rettangolo");
        area = (b*h);
        System.out.println("L'area del rettangolo è: " + area);
    }

    public static void areaRombo(){
        float d1,d2,area;
        d1=Input.leggiFloat(0,Float.MAX_VALUE,"Inserire la diagonale 1 del rombo");
        d2=Input.leggiFloat(0,Float.MAX_VALUE,"Inserire la diagonale 2 del rombo");
        area = (d1*d2)/2;
        System.out.println("L'area del rombo è: " + area);
    }

    public static void areaTrapezio(){
        float B,b,h,area;
        b=Input.leggiFloat(0,Float.MAX_VALUE,"Inserire la base minore");
        B=Input.leggiFloat(b,Float.MAX_VALUE,"Inserire la base maggiore");
        h=Input.leggiFloat(0,Float.MAX_VALUE,"Inserire l'altezza");
        area = ((b+B)*h)/2;
        System.out.println("L'area del trapezio è: " + area);
    }

    public static void areaCerchio(){
        float r;
        double area;
        r=Input.leggiFloat(0,Float.MAX_VALUE,"Inserire la base minore");
        area = r * r * Math.PI;
        System.out.println("L'area del cerchio è: " + area);
    }

    public static void areaPoligonoRegolare(){
        float a,p,area;
        a=Input.leggiFloat(0,Float.MAX_VALUE,"Inserire l'apotema");
        p=Input.leggiFloat(0,Float.MAX_VALUE,"Inserire il perimetro");
        area = p*a/2;
        System.out.println("L'area del poligono regolare è: " + area);
    }



    public static void menu(){
        System.out.println("a)Calcola area triangolo");
        System.out.println("b)Calcola area rettangolo");
        System.out.println("c)Calcola area rombo");
        System.out.println("d)Calcola area trapezio");
        System.out.println("e)Calcola area cerchio");
        System.out.println("f)Calcola area poligono regolare");
        System.out.println("g)Termine esecuzione");
    }

}