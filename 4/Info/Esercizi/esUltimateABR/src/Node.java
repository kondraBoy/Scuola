public class Node {
    private int key;
    private long address;
    private Node left, right;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public int getKey(){
        return key;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public Node getLeft(){
        return left;
    }

    public void setRight(Node right){
        this.right = right;
    }

    public Node getRight(){
        return right;
    }

    public long getAddress() {
        return address;
    }
}