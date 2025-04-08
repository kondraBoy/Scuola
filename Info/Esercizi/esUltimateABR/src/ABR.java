public class ABR {
    private Node root;

    public ABR() {
        this.root = null;
    }

    public void add(int key){
        Node newNode = new Node(key);
        if(root == null){
            root = newNode;
        } else {
            addRec(root, newNode);
        }
    }
    
    private void addRec(Node root, Node newNode) {
        if(newNode.getKey() < root.getKey()){
            if(root.getLeft() == null){
                root.setLeft(newNode);
            } else {
                addRec(root.getLeft(), newNode);
            }
        } else {
            if(root.getRight() == null){
                root.setRight(newNode);
            } else {
                addRec(root.getRight(), newNode);
            }
        }
    }

    public Node search(int key) {
        return searchRec(root, key);
    }

    private Node searchRec(Node root, int key) {
        if(root == null || root.getKey() == key){
            return root;
        }
        if(key < root.getKey()){
            return searchRec(root.getLeft(), key);
        }
        return searchRec(root.getRight(), key);
    }

}