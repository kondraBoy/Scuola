public class Main {
    public static void main(String[] args) {
        ContatoreCondiviso contatore = new ContatoreCondiviso();
        Thread t1 = new ThreadPari(contatore);
        Thread t2 = new ThreadDispari(contatore);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

