import java.io.*;
public class ABR<T extends Comparable<T>> {
    private Node<T> root;

    public ABR(){
        root = null;
    }

    public void add(T value){
        Node<T> nodo = new Node<>(value);
        if(this.root == null){
            root = nodo;
            root.setLeft(null);
            root.setRight(null);
        }
        else{
            addRec(this.root, nodo);
        }
    }
    private void addRec(Node<T> subRoot, Node<T> nodo){
        if(nodo.getKey().compareTo(subRoot.getKey()) > 0){
            if(subRoot.getRight() == null)
                subRoot.setRight(nodo);
            else
                addRec(subRoot.getRight(), nodo);
        }            else {
            if(subRoot.getLeft() == null)
                subRoot.setLeft(nodo);
            else
                addRec(subRoot.getLeft(), nodo);
        }
    }
}