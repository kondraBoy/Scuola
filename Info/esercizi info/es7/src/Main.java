/*Andrea Guarino 4BI
Scrivi una funzione che dati due punti A e B, restituisce la misura della distanza tra A e B.
*/
public class Main {
    public static void main(String[] args) {
        distanza();
    }
    public static void distanza(){
        int aX,aY,bX,bY;
        double distanza;
        aX=Input.leggiInt(0, Integer.MAX_VALUE,"Inserire coordinata X del punto A");
        aY=Input.leggiInt(0, Integer.MAX_VALUE,"Inserire coordinata Y del punto A");
        bX=Input.leggiInt(0, Integer.MAX_VALUE,"Inserire coordinata X del punto B");
        bY=Input.leggiInt(0, Integer.MAX_VALUE,"Inserire coordinata Y del punto B");
        distanza = Math.sqrt(Math.pow(aX - bX, 2) + Math.pow(aY - bY, 2));
        System.out.println("La distanza tra A e B è: " + distanza);
    }
}