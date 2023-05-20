package mining;

import data.Data;
import data.OutOfRangeSampleSize;
import data.Tuple;

public class ClusterSet {
	//Attributi
	private Cluster C[];
	int i=0; 					//posizione valida per la memorizzazione di un nuovo cluster in C
	
	//Metodi
	//Numero di cluster da generare
	ClusterSet(int k){
		this.C=new Cluster[k];
	}
	
	void add(Cluster c) {
		C[this.i]=c;
		this.i++;
	}
	
	Cluster get(int i) {
		return C[i];
	}
	
	//sceglie i centroidi, crea un cluster per ogni centroide e lo memorizza in C
	void initializeCentroids(Data data) throws OutOfRangeSampleSize {
		int centroidIndexes[]=data.sampling(C.length);
		for(int i=0;i<centroidIndexes.length;i++){
			Tuple centroidI=data.getItemSet(centroidIndexes[i]);
			add(new Cluster(centroidI));
			}
		}
	
	/*Calcola la distanza tra la tupla riferita da tuple ed il centroide di ciascun cluster in C 
	 * e restituisce il cluster più vicino
	 */
	Cluster nearestCluster(Tuple tuple) {
		double minDistance=tuple.getDistance(get(0).getCentroid());
		Cluster nearest= get(0);
		for(int i=0;i<C.length;i++) {
			if (tuple.getDistance(get(i).getCentroid())<minDistance) {
				minDistance= tuple.getDistance(get(i).getCentroid());
				nearest=get(i);
			}
			}
		return nearest;
		}
	/*Identifica e restituisce il cluster a cui la tupla rappresenta l'esempio identificato da id
	 * Se la tupla non è inclusa in nessun cluster restituisce null
	 */
	Cluster currentCluster(int id) {
		for(int i=0;i<C.length;i++) {
			if(C[i].contain(id)) {
				return C[i];
			}
		}
		return null;
		}
	
	//calcola il nuovo centroide per ciascun cluster in C
	void updateCentroids(Data data) {
		for(int i=0;i<C.length;i++) {
			C[i].computeCentroid(data);
		}
		}
	
	//Restituisce una stringa fatta da ciascun centroide dell’insieme dei cluster
	public String toString(){
		String strCentroid=new String();
		for(int i=0;i<C.length;i++) {
			strCentroid=strCentroid+C[i].getCentroid();
		}
	return strCentroid;
	}
	
	//Restituisce una stringa che descriva lo stato di ciascun cluster in C
	public String toString(Data data ){
		String str="";
		for(int i=0;i<C.length;i++){
			if (C[i]!=null){
				str+=i+":"+C[i].toString(data)+"\n";
				}
			}
		return str;
		}
	}