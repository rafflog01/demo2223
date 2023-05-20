package data;

import utility.ArraySet;

//modella generico item
public abstract class Item {
	
	//Attributi
	
	//Attributo coinvolto
	private Attribute attribute;

	//Valore assegnato all'attributo
	private Object value;
	
	//Metodi
	
	//Item inizializza i valori
	Item(Attribute attribute, Object value){
		this.attribute= attribute;
		this.value= value;
	}
	
	//Restituisce attribute
	Attribute getAttribute() {
		return attribute;
	}
	
	//Restituisce value
	Object getValue() {
		return value;
	}
	
	//Restituisce value
	public String toString(){
		String s=new String();
		return s=s+value;
	}
	
	abstract double distance(Object a);
	
	public void update(Data data, ArraySet clusteredData) {
		value=data.computePrototype(clusteredData, attribute);
	}
}
