package data;
//Rappresenta una tupla come sequenza di attributo-valore
public class Tuple {
	
	//Attributi
	private Item[] tuple;
	
	//Metodi
	//costruisce oggetto riferito da tuple
	public Tuple(int size){
		this.tuple=new Item[size];
	}
	
	// restituisce tuple.length
	 public int getLength(){
		return tuple.length;
	}
	
	//restituisce l'item in posizione i
	public Item get(int i) {
		return tuple[i];
	}
	
	//memorizza c in tuple[i]
	void add(Item c, int i) {
		tuple[i]=c;
	}

	//determina la distanza tra la tupla riferita da obj e la tupla corrente
	public double getDistance(Tuple obj) {
		double distanc=0.0;
		for (int i=0;i<obj.getLength();i++) {
			distanc= distanc+get(i).distance(obj.get(i).getValue());
		}
		return distanc;
	}
	
	public double avgDistance(Data data, int[] clusteredData){
		double p=0.0,sumD=0.0;
		for(int i=0;i<clusteredData.length;i++){
			double d= getDistance(data.getItemSet(clusteredData[i]));
			sumD+=d;
			}
		p=sumD/clusteredData.length;
		return p;
		}
	}
