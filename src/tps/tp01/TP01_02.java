package tps.tp01;

import main.auxiliares.Auxiliares;
import ownimple.OwnPila;
import owntda.OwnPilaTDA;

public class TP01_02 {
	
	static void ej02_f(OwnPilaTDA p) {
		Auxiliares.pln(TP01_02.promedioPila(p));
	}
	
	static void ej02_e(OwnPilaTDA p) {
		Auxiliares.pln(TP01_02.sumarPila(p));
	}
	
	static void ej02_d(OwnPilaTDA p) {
		Auxiliares.pln(TP01_02.contarPila(p));
	}

	static void ej02_c(OwnPila p) {
		TP01_02.invertirPila(p);
		Auxiliares.pln(p.tope());
	}
	
	static void ej02_b(OwnPilaTDA p) {
		p.apilar(10);
		p.apilar(100);
		
		
		var pilaCopia = TP01_02.copiarPila(p);
		
		System.out.println("Tope de pilas");
		
		System.out.println("Origen " + p.tope());
		System.out.println("Copia  " + pilaCopia.tope());
	}
	
	static void ej02_a(OwnPila p) {	
		p.apilar(69);
		p.apilar(420);
		
		var pilaNueva = new OwnPila();
		pilaNueva.inicializarPila();
		
		OwnPilaTDA invertido = TP01_02.invertirPila(p);
		
		System.out.println(invertido.tope()); // Deberia ser 69
		System.out.println("La pila anterior esta vacia? %s".formatted(p.pilaVacia())); // Deberia ser true
	}
	// FIN EJERCICIOS
	
	// INICIO metodos
	public static int sumarPila(OwnPilaTDA pilaOrigen) {
		int suma = 0;
		var pilaAux = copiarPila(pilaOrigen);

		while (!pilaAux.pilaVacia()) {
			int v = pilaAux.tope();
			
			suma += v;
			pilaAux.desapilar();
		}
		
		return suma;
	}
	
	public static int contarPila(OwnPilaTDA pilaOrigen) {
		int cantidad = 0;
		var pilaAux = copiarPila(pilaOrigen);
		
		while (!pilaAux.pilaVacia()) {
			pilaAux.desapilar();
			cantidad++;
		}
		
		return cantidad;
	}
	
	/**
	 * 
	 * @param pilaOrigen
	 * @return nueva OwnPila invertida
	 */
	public static void pasarPila(OwnPila pilaOrigen, OwnPila pilaDestino) {		
		while (!pilaOrigen.pilaVacia()) {
			int tope = pilaOrigen.tope();
			pilaDestino.apilar(tope);
			pilaOrigen.desapilar();
		}
	}
	
	public static OwnPila copiarPila(OwnPilaTDA pilaOrigen) {
		var nuevaPila = new OwnPila();
		nuevaPila.inicializarPila();
		
		var pilaAux = new OwnPila();
		pilaAux.inicializarPila();
		
		while (!pilaOrigen.pilaVacia()) {
			int tope = pilaOrigen.tope();
			nuevaPila.apilar(tope);
			pilaAux.apilar(tope);
			pilaOrigen.desapilar();
		}
		
		while (!pilaAux.pilaVacia()) {
			pilaOrigen.apilar(pilaAux.tope());
			pilaAux.desapilar();
		}
		
		return nuevaPila;
	}
	
	public static OwnPila invertirPila(OwnPila pilaInvertir) {
		var pilaAuxN = new OwnPila();
		pilaAuxN.inicializarPila();
				
		while (!pilaInvertir.pilaVacia()) {
			int v = pilaInvertir.tope();
			pilaAuxN.apilar(v);
			
			pilaInvertir.desapilar();
		}
		
		// pilaInvertir = pasarPila(pilaInvertir); // O esto en lugar de los while
		
		return pilaAuxN;
	}

	
	public static double promedioPila(OwnPilaTDA p) {
		return sumarPila(p)/contarPila(p);
	}
}
