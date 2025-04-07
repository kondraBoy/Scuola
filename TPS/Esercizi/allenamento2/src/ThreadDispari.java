public class ThreadDispari extends Thread {
    private final ContatoreCondiviso contatore;

    public ThreadDispari(ContatoreCondiviso contatore) {
        this.contatore = contatore;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int valore = contatore.stampaDispari();
                if (valore == -1) break;
                System.out.println("Thread B (Dispari): " + valore);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

