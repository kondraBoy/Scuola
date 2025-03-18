import java.io.*;
public class ABR<T extends Comparable<T>> {
    private Node<T> root;

    public ABR(){
        root = null;
    }

    public void add(T value) throws Exception{
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
    private void addRec(Node<T> subRoot, Node<T> nodo) throws Exception {
        if (nodo.getKey().compareTo(subRoot.getKey()) > 0) {
            if (subRoot.getRight() == null)
                subRoot.setRight(nodo);
            else
                addRec(subRoot.getRight(), nodo);
        } else if (nodo.getKey().compareTo(subRoot.getKey()) < 0) {
            if (subRoot.getLeft() == null)
                subRoot.setLeft(nodo);
            else
                addRec(subRoot.getLeft(), nodo);
        } else {
            throw new Exception("Chiave duplicata: " + nodo.getKey());
        }
    }

    public Long search(T key) {
        return searchRec(root, key);
    }

    private Long searchRec(Node<T> subRoot, T key) {
        Long address = null;
        if (subRoot != null) {
            int cmp = key.compareTo(subRoot.getKey());
            if (cmp == 0) {
                address = subRoot.getAddress();
            } else if (cmp < 0) {
                address = searchRec(subRoot.getLeft(), key);
            } else {
                address = searchRec(subRoot.getRight(), key);
            }
        }
        return address;
    }

    public void exportABR(RandomAccessFile raf) throws IOException {
        exportRec(raf, root);
    }

    private void exportRec(RandomAccessFile raf, Node<T> node) throws IOException {
        if (node != null) {
            raf.writeUTF(node.getKey().toString());
            raf.writeLong(node.getAddress());
            exportRec(raf, node.getLeft());
            exportRec(raf, node.getRight());
        }
    }

    public void importABR(RandomAccessFile raf) throws IOException {
        while (raf.getFilePointer() < raf.length()) {
                T key = (T) raf.read(T); //Non so come fare, T non permette di ottenere il peso in byte
                long address = raf.readLong();
                add(key, address);
            }
        }
    }

}

