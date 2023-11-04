package ownimple;

import owntda.OwnPilaTDA;

public class OwnPila implements OwnPilaTDA {
	private int arr[];
	private int indice;
	
	@Override
	public void inicializarPila() {
		arr = new int[100];
		indice = 0;
	}
	
	@Override
	public void apilar(int x) {
		arr[indice] = x;
		indice++;
	}
	
	@Override
	public void desapilar() {
		indice--;
	}
	
	@Override
	public int tope() {
		return arr[indice-1];
	}
	
	@Override
	public boolean pilaVacia() {
		return indice == 0;
	}
	
	
	@Override
	public String toString() {
		String str = "Pila:\n";
		
		// usare for solo aqui
		for (int i = indice-1; i>=0; i--) {
			str += "\t" + arr[i] + "\n";
		}
		
		return str;
	}
	
}