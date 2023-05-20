package data;
/* 
 * Classe astratta che modella la entita' attributo
*/
abstract class Attribute {
	
	//Nome dell'attributo
	private String name;
	
	//Identificativo numerico dell'attributo
	private int index;
	
	//Costruttore Attribute
	protected Attribute(String name, int index) {
		this.name=name;
		this.index=index;
	}
	
	//Restituisce il nome dell'attributo
	String getName() {
		return name;
	}
	
	//Restituisce l'identificativo numerico dell'attributo
	int getIndex(){
		return index;
	}
	
	//Restituisce la stringa rappresentate lo stato dell'oggetto (override)
	public String toString() {
		System.out.println(name);
		System.out.println(index);
		return name;
	}
}
