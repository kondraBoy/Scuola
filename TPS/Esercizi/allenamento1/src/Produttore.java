public class Produttore extends Thread {
    private final Buffer buffer;

    public Produttore(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (true) {
                buffer.put(i++);
                Thread.sleep(500); // Simula tempo di produzione
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
