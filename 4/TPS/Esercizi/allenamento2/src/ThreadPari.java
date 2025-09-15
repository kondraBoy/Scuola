public class ThreadPari extends Thread {
    private final ContatoreCondiviso contatore;

    public ThreadPari(ContatoreCondiviso contatore) {
        this.contatore = contatore;
    }

    @Override
    public void run() {
        synchronized (contatore){
            try {
                while (true) {
                    int valore = contatore.stampaPari();
                    if (valore == -1) break;
                    System.out.println("Thread A (Pari): " + valore);
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
