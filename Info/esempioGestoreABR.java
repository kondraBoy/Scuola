public class Node{
	private long pos;
	private int cod; //String cod
	private Node right,left;
	
	
	//getter e setter
}

public class ABR{
	Node root;
	
	public ABR(){
		root = null;
	}
	
	public void add (int cod, long pos) throws Exception{
		if(root == null)
			root = new Node (cod,pos);
		else
			addRec(root,cod,pos);
	}
	
	private void addRec (Node subRoot,int cod,long pos) throws Exception{
		if(subRoot.getCod() > cod){
			if(subRoot.getLeft() == null)
				subRoot.setLeft(new Node (cod,pos));
			else
				addRec(subRoot.getLeft(),cod,pos);
		}
		if(subRoot.getCod() < cod){
			if(subRoot.getRight() == null)
				subRoot.setRight(new Node (cod,pos));
			else
				addRec(subRoot.getRight(),cod,pos)
		}else
			throw new IllegalArgumentException("Codice già presente");
		
	}
	
	public long search(int cod){  //restituisce l'attributo di posizione nel RAF
		if(root == null){
			throw new Exception ("Non sono presenti codici");
		}
		if(root.getCod() == cod){
			pos = root.getPos();
		}else
			pos = searchRec(root,cod);
		return pos;
	}
	
	private long searchRec(Node subRoot,int cod){
		long pos;
		if(subRoot.getCod() > cod){
			pos = searchRec(root.getLeft(),cod);
		else
			pos = searchRec(root.getRight(),cod);
		
		return pos;
	}
}

public class Gestore{
	private RandomAccessFile raf;
	private ABR abr;
	
	
	public Gestore(){
		try{
			raf = new RandomAccessFile("prodotti.dat","rw");
			ObjectInputStream ois = new ObjectInputStream (New FileInputStream("abr.dat"));
			abr = (ABR) ois.readObject();
		}catch(Exception){
			if(raf.lenght() > 0)
				loadABR();
			else
				abr = new ABR();
		}
	}
	
	private loadABR(){
		abr = new ABR();
		Prodotto p = null;
		raf.seek(0);
		while(raf.getFilePointer() < raf.lenght()){
			long posRead = raf.getFilePointer();
			p = p.read(raf);
			abr.add(p.getCod(),posRead);
		}
	}
	
	public void add(int cod, String name, double prz) throws Exception{
		Prodotto p = new Prodotto(cod,name,prz);
		raf.seek(raf.lenght());
		abr.add(cod,raf.getFilePointer());
		p.write(raf);
	}
	
	public Prodotto search(int cod) throws Exception{
		pos = abr.search(cod);
		raf.seek(pos);
		Prodotto p = p.read(raf);
		return p;
	}
	
}

public class Input(){
	//metodi standard
	
	public static String readStr(RandomAccessFile raf, int len){
		char[] str = new char[len];
		for(int i = 0; i< len; i++){
			str[i] = raf.readChar();
		}
		String s = new String(str);
		return s;
	}
	
	public static void writeStr(String s,RandomAccessFile raf, int len){
		StringBuilder builder = new StringBuilder(str);
		builder.setLenght(len);
		raf.writeChars(builder.toString());
	}
}

public class Prodotto{
	private int cod;
	private String name;
	private double prz;
	public static STRLEN = 20; 
	
	public void write(){
		
	}
	
	public void read(RandomAccessFile raf){
		raf.writeInt(cod);
		Input.writeStr(name,raf,STRLEN);
		raf.writeDouble(prz);
	}
	
	public void write(RandomAccessFile raf){
		cod = raf.readInt();
		name = Input.readStr(raf,STRLEN);
		prz = raf.readDouble();
	}
} 