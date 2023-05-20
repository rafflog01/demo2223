package mining;

import data.Data;
import data.OutOfRangeSampleSize;

//implementazione algoritmo kmeans
public class KMeansMiner {
	//Attributi
	private ClusterSet C;
	
	//Metodi
	public KMeansMiner(int k){
		this.C=new ClusterSet(k);
	}
	public ClusterSet getC() {
		return this.C;
	}
	
	public int kmeans(Data data) throws OutOfRangeSampleSize {
		int numberOfIterations=0;
		//STEP 1 Scelta casuale di centroidi per k clusters
		C.initializeCentroids(data);
		boolean changedCluster=false;
		do{
			numberOfIterations++;
		//STEP 2 Assegnazione di ciascuna riga della matrice in data al cluster avente centroide più vicino all'esempio
			changedCluster=false;
			for(int i=0;i<data.getNumberOfExamples();i++){
				Cluster nearestCluster = C.nearestCluster( data.getItemSet(i));
				Cluster oldCluster=C.currentCluster(i);
				boolean currentChange=nearestCluster.addData(i);
				if(currentChange)
					changedCluster=true;
		//rimuovo la tupla dal vecchio cluster
				if(currentChange && oldCluster!=null)
		//il nodo va rimosso dal suo vecchio cluster
					oldCluster.removeTuple(i);
				}
		//STEP 3 Calcolo dei nuovi centroidi per ciascun cluster
			C.updateCentroids(data);
			}
		while(changedCluster);
		return numberOfIterations;
		}
	}
