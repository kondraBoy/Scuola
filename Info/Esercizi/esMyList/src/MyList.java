public class MyList<T> {
    private Nodo<T> first;

    public MyList() {
        this.first = null;
    }

    public boolean add(T obj){
        if(obj == null){
            throw new NullPointerException("Not accepted null object");
        }else{
            Nodo<T> newNode = new Nodo<>(obj);
            if(first==null){
                this.first = newNode;
            }else{
                this.first.setNode(newNode);
            }
    }

    public void addFirst(T obj){ //richiama add
       int n;
    }

    public void addLast(T obj){
        int n;
    }

    public void clear(){
        int n;
    }

    public boolean contains{
        int n;
    }
}
