package tps.tp01;

import main.auxiliares.Auxiliares;
import ownimple.OwnCola;
import ownimple.OwnPila;

public class TP01_04 {
	public static void ej04_a() {
		var c1 = new OwnCola();
		var c2 = new OwnCola();
		c1.inicializarCola();
		c2.inicializarCola();

		c1.acolar(1);
		c1.acolar(2);
		c1.acolar(3);
		c1.acolar(4);

		Auxiliares.pln(c1.primero());
		pasarColaACola(c1, c2);
		Auxiliares.pln(c2.primero());
	}

	public static void ej04_b() {
		var c = new OwnCola();
		c.inicializarCola();

		c.acolar(1);
		c.acolar(2);
		c.acolar(3);

		Auxiliares.pln(c.primero());
		var colaInvertida = invertirCola(c);
		Auxiliares.pln(colaInvertida.primero());
	}

	public static void ej04_c() {
		var c = new OwnCola();
		c.inicializarCola();
		c.acolar(1);
		c.acolar(5);
		c.acolar(10);
		
		Auxiliares.pln(String.format("Primer valor de la cola: %d", c.primero()));
		
		invertirColaSinPila(c);
		
		Auxiliares.pln(String.format("Primer valor de la cola inversa: %d", c.primero()));
	}
	
	public static void ej04_d() {
		var c1 = new OwnCola();
		var c2 = new OwnCola();

		c1.inicializarCola();
		c2.inicializarCola();

		c1.acolar(1);
		c1.acolar(2);
		c1.acolar(3);
		c1.acolar(4);
		c1.acolar(5);

		c2.acolar(1);
		c2.acolar(5);
		c2.acolar(7);

		boolean finalesCoincidentes = finalesColaCoinciden(c1, c2);
		Auxiliares.pln(String.format("Las colas finalizan igual: %b", finalesCoincidentes));
	}

	public static void ej04_e() {
		OwnCola colita = new OwnCola();
		colita.inicializarCola();

		colita.acolar(2);
		colita.acolar(1);
		colita.acolar(2);

		boolean esColaCapicua = esColaCapicua(colita);
		Auxiliares.pln(String.format("La cola es capicua: %b", esColaCapicua));
	}

	public static void ej04_f() {
		OwnCola c1 = new OwnCola();
		OwnCola c2 = new OwnCola();

		c1.inicializarCola();
		c2.inicializarCola();

		c1.acolar(1);
		c1.acolar(2);
		c1.acolar(3);

		c2.acolar(3);
		c2.acolar(2);
		c2.acolar(1);
		c2.acolar(0);

		var sonInversas = esColaInversa(c1, c2);

		Auxiliares.pln(String.format("Las colas son inversas: %b", sonInversas));

	}
	// --------------- FIN EJERCICIOS ---------------

	// --------------- INICIO METODOS ---------------
	
	
	public static OwnCola copiarCola(OwnCola origen) {
		// precondicion: Cola origen inicializada
		var auxiliar = new OwnCola();
		var copia = new OwnCola();
		
		while (!origen.colaVacia()) {
			int v = origen.primero();
			auxiliar.acolar(v);
			copia.acolar(v);
			
			origen.desacolar();
		}
		
		while (!auxiliar.colaVacia()) {
			origen.acolar(auxiliar.primero());
			auxiliar.desacolar();
		}
		
		return copia; 
	} //postcondicion: Cola origen no se destruye
	
	// ej
	public static OwnCola pasarColaACola(OwnCola origen, OwnCola objetivo) {
		while (!origen.colaVacia()) {
			int valor = origen.primero();
			origen.desacolar();

			objetivo.acolar(valor);
		}

		return objetivo;
	}

	public static OwnCola invertirCola(OwnCola origen) {
		var pilaAuxiliar = new OwnPila();
		pilaAuxiliar.inicializarPila();

		var resultado = new OwnCola();
		resultado.inicializarCola();

		while (!origen.colaVacia()) {
			pilaAuxiliar.apilar(origen.primero());
			origen.desacolar();
		}

		while (!pilaAuxiliar.pilaVacia()) {
			resultado.acolar(pilaAuxiliar.tope());
			pilaAuxiliar.desapilar();
		}

		return resultado;
	}
	
	// ej04_c
		public static void invertirColaSinPila(OwnCola origen) {
			if (origen.colaVacia()) {
				return;
			}

			// Obtengo el valor primero de la cola
			int valor = origen.primero();
			
			// lo retiro de la cola
			origen.desacolar();
			
			// Llamo recursivamente a invertirCola, esto tomara el siguiente valor de la cola
			// cuando llegue al final de la misma, continuara 
			invertirColaSinPila(origen);
			
			// En orden inverso proveniente de la recursividad, se reisertaran en la cola
			// El ultimo valor sera el que primero obtenga el return de "invertirColaSinPila"
			// Tras continuar, uno a uno llegaran al final de la funcion
			
			// Ejemplo: Cola 1 2 3 4
			// SE ALMACENAN linea 169 y SE VAN QUITANDO linea 172
			// 1*** 
			//  2**
			//   3*
			//    4
			//     cola vacia -> return linea 176 void (ln165), SE VAN INSERTANDO - linea 194)
			//    4
			//   3*
			//  2**
			// 1***
			
			origen.acolar(valor);
		}
		

	// ej04_d
	static boolean finalesColaCoinciden(OwnCola a, OwnCola b) {
		var colaInvertidaA = TP01_04.invertirCola(a);
		var colaInvertidaB = TP01_04.invertirCola(b);

		return colaInvertidaA.primero() == colaInvertidaB.primero();
	}

	// ej04_e
	public static boolean esColaCapicua(OwnCola origen) {
		boolean esCapicua = true;

		OwnCola colaAuxiliar = new OwnCola();
		OwnPila pilaAuxInvertir = new OwnPila();

		colaAuxiliar.inicializarCola();
		pilaAuxInvertir.inicializarPila();

		while (!origen.colaVacia()) {
			int valor = origen.primero();
			colaAuxiliar.acolar(valor);
			pilaAuxInvertir.apilar(valor);

			origen.desacolar();
		}

		while (esCapicua && !colaAuxiliar.colaVacia() && !pilaAuxInvertir.pilaVacia()) {
			esCapicua = colaAuxiliar.primero() == pilaAuxInvertir.tope();

			colaAuxiliar.desacolar();
			pilaAuxInvertir.desapilar();
		}

		return esCapicua && colaAuxiliar.colaVacia() && pilaAuxInvertir.pilaVacia();
	}

	// ej04_f
	public static boolean esColaInversa(OwnCola a, OwnCola b) {
		boolean esInversa = true; // Sera capicua desde inicio y se probará lo contrario

		OwnCola bInvertida = TP01_04.invertirCola(b);

		while (esInversa && !a.colaVacia() && !bInvertida.colaVacia()) {
			int valorA = a.primero();
			int valorB = bInvertida.primero();

			esInversa = valorA == valorB;

			a.desacolar();
			bInvertida.desacolar();
		}

		return esInversa && (a.colaVacia() && bInvertida.colaVacia());
	}

}
