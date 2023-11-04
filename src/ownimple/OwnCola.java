package ownimple;

import owntda.OwnColaTDA;

public class OwnCola implements OwnColaTDA {
	int[] arr;
	int indice;
	
	@Override
	public void inicializarCola() {
		arr = new int[100];
		indice = 0;
	}

	@Override
	public void acolar(int x) {
		for (int i=indice-1; i>=0; i--) {
			arr[i+1] = arr[i];
		}
		arr[0] = x;
		indice++;
	}

	@Override
	public void desacolar() {
		indice--;
	}

	@Override
	public int primero() {
		return arr[indice-1];
	}

	@Override
	public boolean colaVacia() {
		return indice==0;
	}

}
