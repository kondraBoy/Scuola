import java.io.*;
import java.util.*;

public class ABR<T extends Comparable & FileCSV> {
    private Node<T> root;

    public ABR() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void add(T value) {
        root = addRecursive(root, value);
    }

    private Node<T> addRecursive(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(addRecursive(current.getRight(), value));
        }

        public void importFromCsv(String filePath) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                T value = (T) new Node<T>().fromCsv(line);
                add(value);
            }
            reader.close();
        }

        public void exportToCsv(String filePath) throws IOException {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            exportToCsvRecursive(root, writer);
            writer.close();
        }

        private void exportToCsvRecursive(Node<T> node, BufferedWriter writer) throws IOException {
            if (node != null) {
                writer.write(node.toCsv());
                writer.newLine();
                exportToCsvRecursive(node.getLeft(), writer);
                exportToCsvRecursive(node.getRight(), writer);
            }
        }
    }
