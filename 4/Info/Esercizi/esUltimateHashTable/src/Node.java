public class Node {
    private int key;
    private long address;

    public Node(int key) {
        this.key = key;
    }

    public int getKey(){
        return key;
    }

    public long getAddress() {
        return address;
    }
}