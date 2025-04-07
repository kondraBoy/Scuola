public class Main {
    public static void main(String[] args) {
        ContatoreCondiviso contatore = new ContatoreCondiviso();
        Thread t1 = new ThreadPari(contatore);
        Thread t2 = new ThreadDispari(contatore);
        t1.start();
        t2.start();
    }
}
