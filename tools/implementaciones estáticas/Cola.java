package impleLocal;

import tdaLocal.ColaTDA;

public class Cola implements ColaTDA {

	private int[] arr;
	private int indice;

	@Override
	public void inicializarCola() { //costo costante
		arr = new int[100]; //C
		indice = 0; //C
	} //-> C + C = 2C -> C

	@Override
	public void acolar(int x) { //costo lineal
		for (int i=indice-1; i>=0; i--) { //ciclo -> no constante
			arr[i+1] = arr[i]; //C
		} //-> L
		arr[0] = x; //C
		indice++; //C
	} //-> L + C + C -> L

	@Override
	public void desacolar() { //costo costante
		indice--; //indice = indice-1 //indice -= 1 //C
	}

	@Override
	public int primero() { //costo costante
		return arr[indice-1]; //C
	}

	@Override
	public boolean colaVacia() { //costo costante
		return (indice == 0); //C
		/*if (indice == 0)
			return true;
		else
			return false;*/
	}

}
