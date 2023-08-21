package joguin;
import java.util.Random;
public class Roleta{
	public static void showArray(double[] arr) {
		
		
		
	}
	public static void showArray(int[] arr) { // Mostra um array
		String print = "Array: {";
		for(int i=0;i<arr.length;i++) {
			if(i == arr.length-1) {
				print+= arr[i];
			}
			else {
				print+= arr[i];
				print+= ",";
			}
		}
		print+= "}";
		System.out.println(print);	
	}
	public static void bubbleSort(double[] arr) {
		double value = 0;
		for(int i = 0;i< arr.length-1;i++) {
			for(int j = 0; j < arr.length-1;j++) {
				value = arr[j+1];
				if(arr[j] > arr[j+1]) {
					arr[j+1] = arr[j];
					arr[j] = value;	
				}
			}
		}
	}
	public static void bubbleSort(int[] arr) { //Ordena um array
		int value = 0;
		for(int i = 0;i< arr.length-1;i++) {
			for(int j = 0; j < arr.length-1;j++) {
				value = arr[j+1];
				if(arr[j] > arr[j+1]) {
					arr[j+1] = arr[j];
					arr[j] = value;	
				}
			}
		}
	}
	public static int[] playGen(int n) { //Cria um array de jogadas inicialmente
		int plays[] = new int[n];
		Random rand = new Random();
		
		for(int i =0;i<plays.length;i++) {
			plays[i] = rand.nextInt(3)+1;
		}
		return plays;
	}
	public static void newPlay(int[] plays) { // Joga na roleta uma vez e adiciona ao array de jogadas no final
		Random rand = new Random();
		for(int i = 0;i< plays.length-1;i++) {
				plays[i] = plays[i+1];
		}
		plays[plays.length-1] = rand.nextInt(3)+1;
	}
	
	public static double[] verifyProb(int[] plays) {
		
		
		return x;
	}
	public static void main(String[] args) {
		int arr[] = {};
		showArray(arr);
		bubbleSort(arr);
		showArray(arr);
	}
}
