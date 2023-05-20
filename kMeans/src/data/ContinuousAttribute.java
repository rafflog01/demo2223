package data;
/* 
 * Classe concreta che modella un attributo numerico
*/
class ContinuousAttribute extends Attribute{

	//Attributi che rappresentano gli estremi dell'intervallo di valori che l'attributo puo' realmente assumere
	private double max;
	private double min;
	
	/*Inserico il super costruttore che ha come input nome identificativo numerico valore minimo e massimo dell'attributo 
	 * inizializza i membri aggiunti per etensione dopo aver invoca il costruttore della super classe
	 */
	ContinuousAttribute(String name, int index, double min, double max) {
		super(name, index);
		this.min= min;
		this.max= max;
	}
	//Calcola e restiutuisce il valore normalizzato del paramaetro passato in input
	double getScaledValue(double v) {
		return (v-min)/(max-min); 
	}
	
}