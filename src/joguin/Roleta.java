package joguin;
import java.util.Random;

import javax.swing.JOptionPane;
public class Roleta{
	public static void showArray(double[] arr) {
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
	public static int[] playGen(int n) { //Cria um array de n jogadas para serem analisadas inicialmente
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
	public static int[] verifyProb(int[] plays) { //Verifica quantas vezes a mesma coluna foi sorteada nas rodadas

		double prob[] = new double[3];
		double x=0; double y =0; double z=0;
		int seque[] = {0,0,0};
		int tam = plays.length;
		for(int i = 0; i < tam;i++) {
			if(plays[i] == 1) {
				x+=1.0;
			}
			else {
				if(plays[i] == 2) {
					y+=1.0;
				}
				else {
					z+=1.0;
				}
			}	
		}
		x=x/tam;
		prob[0] = x;
		
		y=y/tam;
		prob[1] = y;
		z=z/tam;
		prob[2] = z;
		bubbleSort(prob);
		for(int i =0;i<3;i++) {
			if(i == 0) {
				if(prob[i] == x) {
					seque[i]= 1;
				}
				else {
					if(prob[i] == y) {
						seque[i]= 2;
					}
					else {
						seque[i]= 3;
					}
				}
			}
			else {
				if(prob[i] == x && prob[i-1] != x) {
					seque[i]= 1;
				}
				else {
					if(prob[i] == y && prob[i-1] != y) {
						seque[i]= 2;
					}
					else {
						seque[i]= 3;
					}
				}
			}
		}
		return seque;
	}
	public static int[] player(int seque[]) {
		int play[] = {0,0};
		play[0] = seque[0];
		play[1] = seque[1];
		
		return play;
		
	}
	public static boolean isWin(int lastPlayGen,int play[]) {
		boolean status = false;
		for(int i = 0; i<2;i++) {
			if(play[0] == lastPlayGen || play[1] == lastPlayGen) {
				status = true;
			}
			
		}
		return status;
	}
	public static void main(String[] args) {
		int countWin = 0;
		int countLoss = 0;
		int entrada = Integer.parseInt( JOptionPane.showInputDialog("insira um número de rodadas"));
		int i = 0;
		int seque[] = new int[3];
		int jogada[] = new int [2];
		int roll[] = new int[3];
		roll = playGen(roll.length);
		while( i < entrada) {
			seque = verifyProb(roll);
			jogada = player(seque);
			newPlay(roll);
			if(isWin(roll[roll.length-1],jogada)){
				countWin +=1;
			}
			else {countLoss+=1;}
			i++;
		}
		System.out.println("Número de Wins: "+countWin+ "\nNúmero de Loss: "+countLoss);
	
	}
}
