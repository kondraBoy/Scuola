public class Node<T extends Comparable & FileCSV> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Node() {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    public void setValue(T value) {
        if (value == null)
            throw new NullPointerException("Non c'è nessun valore");
        else
            this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public T fromCsv(String csv) {

    }

    public String toCsv() {

    }
}