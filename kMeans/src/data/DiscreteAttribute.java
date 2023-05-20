package data;
import java.util.TreeSet;
import java.util.Iterator;
import utility.ArraySet;

/*
 * La classe concreta DiscreteAttribute estende la classe Attribute 
 * e rappresenta un attributo discreto (categorico)
 */
class DiscreteAttribute extends Attribute implements Iterable<String>{
	//array di oggetti String, uno per ciascun valore del dominio memorizzati seguendo un ordine lessicografico
	private TreeSet<String> values[];
	
	/*Costruttore con input nome dell'attributo identificativo numerico e array di stringhe rappresentanti il dominio dell'attributo
	 * esso invoca il costruttore della classe madre (superclasse)
	 */
	DiscreteAttribute(String name,int index, String values[]) {
		super(name,index);
		this.values=new TreeSet[values.length];
	}
	
	//Restituisce la dimensione di value tramite length()
	int getNumberOfDistinctValues() {
		return values.length;
	}

	/*
	//Restituisce values[i]
	TreeSet<String> getValue(int i) {
		return values[i];
		}
*/
	//restituisce il numero di occorenze del valore discreto(intero)
	int frequency(Data data, ArraySet idList, String v) {
		int frq=0;
		int[] u=idList.toArray();
		for(int i=0; i<data.getNumberOfAttributes();i++) {
			for(int j=0;j<u.length;j++){
			    if(data.getAttributeValue(u[j],i).equals(v)) {
			    	frq++;	
			    }
		    }
		}
		return frq;
		}

	@Override
	public Iterator<String> iterator() {
		Iterator iterator = new Iterator() {
			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public Object next() {
				return null;
			}
		};
		return iterator;
	}
}