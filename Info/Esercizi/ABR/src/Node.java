public class Node <T extends Comparable<T>> {
    private T key;
    private long address;
    private Node<T> left, right;

    public Node(T key){
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public T getKey(){
        return key;
    }

    public void setLeft(Node<T> left){
        this.left = left;
    }

    public Node<T> getLeft(){
        return left;
    }

    public void setRight(Node<T> right){
        this.right = right;
    }

    public Node<T> getRight(){
        return right;
    }

    public long getAddress() {
        return address;
    }
}