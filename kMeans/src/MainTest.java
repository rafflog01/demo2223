import java.util.Scanner;
import mining.KMeansMiner;
import data.Data;
import data.OutOfRangeSampleSize;
import keyboardinput.Keyboard;

public class MainTest {
	public static void main(String[] args) throws OutOfRangeSampleSize {
		System.out.println();
		boolean continues = true;
		do {
			Scanner scanner = new Scanner(System.in);
			Data data = new Data();
			System.out.println(data);
			System.out.println("inserire k: ");
			int k = Keyboard.readInt();
			KMeansMiner kmeans = new KMeansMiner(k);
			try {
				int numIter = kmeans.kmeans(data);
				System.out.println("Numero di Iterazione:" + numIter);
				System.out.println(kmeans.getC().toString(data));
			} catch (OutOfRangeSampleSize e) {
				System.err.println("eccezione rilevata: " + e);
			} finally {
				String response;
				do {
					System.out.println("vuoi ripetere l'esecuzione?(y/n)");
					response = Keyboard.readString();
					switch (response) {
						case "y": {
							System.out.println("OK.");
							break;
						}
						case "n": {
							continues = false;
							System.out.println("OK. programma terminato");
							break;
						}
						default: {
							System.out.println("opzione non valida");
							break;
						}
					}
				} while (!response.equals("y") && !response.equals("n"));
			}
		} while (continues);
	}
}