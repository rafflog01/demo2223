package data;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utility.ArraySet;

//Modella l'insieme di transazioni (o tuple)
public class Data {
		
		//matrice dove ogni riga modella una transazione	
		private Object data [][];
		
		//cardinalita' dell'insieme di transazioni che corrisponde al numero delle righe in data[][]
		private int numberOfExamples;
		
		//vettore degli attributi in ciascuna tupla(schema della tabella di dati)
		private Attribute attributeSet[];
		
	    public int distinctTuples;
		
		//Costruttore
		public Data(){
			
			//data
			
			data = new Object [14][5];

			data[0][0]=new String ("sunny");    
			data[1][0]=new String ("sunny");
		    data[2][0]=new String ("overcast");    
		    data[3][0]=new String ("rain");
		    data[4][0]=new String ("rain");    
		    data[5][0]=new String ("rain");
		    data[6][0]=new String ("overcast");    
		    data[7][0]=new String ("sunny");
		    data[8][0]=new String ("sunny");    
		    data[9][0]=new String ("rain");
		    data[10][0]=new String ("sunny");   
		    data[11][0]=new String ("overcast");
		    data[12][0]=new String ("overcast");    
		    data[13][0]=new String ("rain");
		        
		    data[0][1]=new String ("hot");
		    data[1][1]=new String ("hot");    
		    data[2][1]=new String ("hot");
		    data[3][1]=new String ("mild");    
		    data[4][1]=new String ("cool");
		    data[5][1]=new String ("cool");    
		    data[6][1]=new String ("cool");
		    data[7][1]=new String ("mild");    
		    data[8][1]=new String ("cool");
		    data[9][1]=new String ("mild");
		    data[10][1]=new String ("mild");
		    data[11][1]=new String ("mild");    
		    data[12][1]=new String ("hot");
		    data[13][1]=new String ("mild");    
		    
		    data[0][2]=new String ("high");    
		    data[1][2]=new String ("high");
		    data[2][2]=new String ("high");    
		    data[3][2]=new String ("high");
		    data[4][2]=new String ("normal");    
		    data[5][2]=new String ("normal");
		    data[6][2]=new String ("normal");    
		    data[7][2]=new String ("high");
		    data[8][2]=new String ("normal");    
		    data[9][2]=new String ("normal");
		    data[10][2]=new String ("normal");    
		    data[11][2]=new String ("high");
		    data[12][2]=new String ("normal");    
		    data[13][2]=new String ("high");
		        
		    data[0][3]=new String ("weak");    
		    data[1][3]=new String ("strong");
		    data[2][3]=new String ("weak");    
		    data[3][3]=new String ("weak");
		    data[4][3]=new String ("weak");    
		    data[5][3]=new String ("strong");
		    data[6][3]=new String ("strong");
		    data[7][3]=new String ("weak");    
		    data[8][3]=new String ("weak");
		    data[9][3]=new String ("weak");    
		    data[10][3]=new String ("strong");
		    data[11][3]=new String ("strong");    
		    data[12][3]=new String ("weak");
		    data[13][3]=new String ("strong");    
		    
		    data[0][4]=new String ("no");
		    data[1][4]=new String ("no");    
		    data[2][4]=new String ("yes");
		    data[3][4]=new String ("yes");    
		    data[4][4]=new String ("yes");
		    data[5][4]=new String ("no");    
		    data[6][4]=new String ("yes");
		    data[7][4]=new String ("no");    
		    data[8][4]=new String ("yes");
		    data[9][4]=new String ("yes");    
		    data[10][4]=new String ("yes");
		    data[11][4]=new String ("yes");    
		    data[12][4]=new String ("yes");
		    data[13][4]=new String ("no");


			
			// numberOfExamples
			
			numberOfExamples=14;		 
			 
			
			//explanatory Set
			
			attributeSet = new Attribute[5];

			// TO DO : avvalorare ciascune elemento di attributeSet con un oggetto della classe DiscreteAttribute che modella il corrispondente attributo (e.g. outlook, temperature,etc)
			//outlook
			
			String outLookValues[]=new String[3];
			outLookValues[0]="overcast";
			outLookValues[1]="rain";
			outLookValues[2]="sunny";
			attributeSet[0] = new DiscreteAttribute("Outlook",0, outLookValues);
			
			//Temperature
			String temperatureValues[]=new String[3];
			temperatureValues[0]="cool";
			temperatureValues[1]="hot";
			temperatureValues[2]="mild";
			attributeSet[1] = new DiscreteAttribute("Temperature",1, temperatureValues);
			
			//Humidity
			String humidityValues[]=new String[2];
			humidityValues[0]="high";
			humidityValues[1]="normal";
			attributeSet[2] = new DiscreteAttribute("Humidity",2, humidityValues);
			
			//Wind
			String windValues[]=new String[2];
			windValues[0]="strong";
			windValues[1]="weak";
			attributeSet[3] = new DiscreteAttribute("Wind",3, windValues);
			
			//PlayTennis
			String playtennisValues[]=new String[2];
			playtennisValues[0]="no";
			playtennisValues[1]="yes";
			attributeSet[4] = new DiscreteAttribute("PlayTennis",4, playtennisValues);

			distinctTuples=countDistinctTuples();
		}
		
		//restituisce il numero di esempi
		public int getNumberOfExamples(){
			return numberOfExamples;
		}
		
		//restituisce la cardinalità dell'insieme degli attributi
		public int getNumberOfAttributes(){
			return attributeSet.length;
		}
		
		/*restituisce il valore assunto in data dall'attributo in posizione attributeIndex,
		 *  nella riga in posizione exampleIndex
		 */
		public Object getAttributeValue(int exampleIndex, int attributeIndex){
			return data[exampleIndex][attributeIndex];
		}
		
		//restituisce lo schema dei dati
		Attribute[] getAttributeSchema() {
			return attributeSet;
		}
		
		//stringa che modella lo stato dell'oggetto e ci permette di creare la tabella
		public String toString(){
			String stringa= new String();
			for(int i=0;i<getNumberOfAttributes();i++) {
				stringa= stringa+attributeSet[i].getName()+",";
			}for(int j=0;j<getNumberOfExamples();j++) {
				stringa=stringa+"\n"+(j+1)+":";
				for(int x=0;x<getNumberOfAttributes();x++) {
					stringa=stringa+getAttributeValue(j,x)+",";
				}
			}
			return stringa;
		}
		
		public Tuple getItemSet(int index) {
			Tuple tuple=new Tuple(attributeSet.length);
			for(int i=0;i<attributeSet.length;i++)
			tuple.add(new DiscreteItem((DiscreteAttribute)attributeSet[i],(String)data[index][i]),i);
			return tuple;
			}
		
		public int[] sampling(int k) throws OutOfRangeSampleSize {
                if(k <= 0) {
					System.err.print("\nk<1\n");
					throw new OutOfRangeSampleSize();
				}
                if(k>distinctTuples) {
					System.err.print("\nk > delle tuple distinte\n");
					throw new OutOfRangeSampleSize();
				}
			int[] centroidIndexes =new int[k];
			//choose k random different centroids in data.
			
			Random rand=new Random();
			rand.setSeed(System.currentTimeMillis());
			for (int i=0;i<k;i++){
				boolean found=false;
				int c;
				do{
					found=false;
					c=rand.nextInt(getNumberOfExamples());
			// verify that centroid[c] is not equal to a centroide already stored in CentroidIndexes
					for(int j=0;j<i;j++)
						if(compare(centroidIndexes[j],c)){
							found=true;
							break;
							}
					}while(found);
				centroidIndexes[i]=c;
				}
			return centroidIndexes;
			}
		
		private boolean compare(int i, int j) {
			boolean flag=false;
			for(int x=0;x<getNumberOfAttributes();x++) {
				if(getAttributeValue(i,x)==getAttributeValue(j,x)) {
				flag=true;
				}else {
				flag=false;
				break;
			}
		}
		return flag;
		}
		
		
		Object computePrototype(ArraySet idList, Attribute attribute) {
			return computePrototype(idList, (DiscreteAttribute)attribute);
		}
		
		String computePrototype(ArraySet idList, DiscreteAttribute attribute) {
			//Data dataDummy=new Data();
			String prototype = new String();
			int greatestFreq = 0;
			for (int i = 0; i < attribute.getNumberOfDistinctValues(); i++) {
				if (attribute.frequency(this, idList, attribute.getValue(i)) > greatestFreq) {
					greatestFreq = attribute.frequency(this, idList, attribute.getValue(i));
					prototype = attribute.getValue(i);
				}
			}
			return prototype;
		}

	//Conta il numero di transazioni distinte memorizzate in data
		private int countDistinctTuples() {
			int distinctTuples=0;
			boolean flag[]= new boolean[getNumberOfExamples()];
			for (int i=0;i<getNumberOfExamples();i++) {
				if(flag[i]==true)
					continue;
				for(int j=i+1;j<getNumberOfExamples();j++) {
					if(compare(i,j))
						flag[j]=true;
				}
				distinctTuples++;
			}
			return distinctTuples;
			}
			
		//MAIN
		public static void main(String args[]){
			Data trainingSet=new Data();
			System.out.println(trainingSet);
		}
		private class Example implements Comparable<Example>{
			//array di Object che rappresentano la singola transizione(una riga della tabella)
			List<Object> example = new ArrayList<Object>();
			//aggiunge un oggetto alla lista
			void add (Object o) {
				example.add(o);
			 }
			//restituisce l'oggetto in posizione index
			Object get(int i) {
				return example.get(i);
			}

			//??????
			public int compareTo(Example ex) {
				//Se i valori sono uguali restituisce 0
				int i=0;
				if(this.get(i)==ex.get(i)){
					return 0;
				}
				else return 1;
			}
		}
}