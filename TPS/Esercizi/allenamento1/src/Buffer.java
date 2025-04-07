import java.util.ArrayList;

public class Buffer {
    private ArrayList<Integer> buffer;

    public Buffer(){
        this.buffer = new ArrayList<>(5);
    }

    public synchronized void put(int value) throws InterruptedException {
        if(buffer.size() == 5){
            wait();
        }
        buffer.add(value);
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        if(buffer.isEmpty())
            wait();
        int value = buffer.remove(0);
        notifyAll();
        return value;
    }
}
