package tps.tp03;

import main.auxiliares.Auxiliares;
import ownimple.OwnCola;
import ownimple.OwnPila;

import tps.tp01.TP01_02;

public class TP03_01 {
	public static void ej01_a() {
		OwnPila p1 = new OwnPila();
		p1.inicializarPila();

		p1.apilar(1);
		p1.apilar(2);
		p1.apilar(3);
		p1.apilar(1);

		Auxiliares.fpln("La pila es capicua? %b", esCapicua(p1));
	}

	public static void ej01_b() {
		OwnPila p1 = new OwnPila();
		p1.inicializarPila();

		p1.apilar(3);
		p1.apilar(1);
		p1.apilar(2);
		p1.apilar(2);
		p1.apilar(1);
		p1.apilar(1);
		p1.apilar(2);

		quitarDuplicados(p1);
		Auxiliares.pln(p1);
	}

	public static void ej01_c() {
		var o = new OwnPila();
		var m1 = new OwnPila();
		var m2 = new OwnPila();

		o.inicializarPila();
		m1.inicializarPila();
		m2.inicializarPila();

		o.apilar(1);
		o.apilar(2);
		o.apilar(3);
		o.apilar(4);

		repartirPilaMitades(o, m1, m2);

		Auxiliares.pln(m1);
		Auxiliares.pln(m2);
	}

	public static void ej01_d() {
		var p = new OwnPila();

		p.inicializarPila();
		p.apilar(3);
		p.apilar(1);
		p.apilar(2);
		p.apilar(2);
		p.apilar(2);
		p.apilar(99);
		p.apilar(99);

		Auxiliares.pln("Pila inicial");
		Auxiliares.pln(p);
		
		Auxiliares.pln("Pila SOLO DUPLICADOS");
		var n = obtenerDuplicados(p);
		Auxiliares.pln(n);
	}

	// ej01_a
	public static boolean esCapicua(OwnPila origen) {
		boolean esCapicua = true;

		OwnPila copiaInvertida = TP01_02.copiarPila(origen);
		TP01_02.invertirPila(copiaInvertida);

		while (esCapicua && !copiaInvertida.pilaVacia() && !origen.pilaVacia()) {
			esCapicua = copiaInvertida.tope() == origen.tope();

			copiaInvertida.desapilar();
			origen.desapilar();
		}

		// Dado el shortcircuit en linea 29
		// Solo hara falta chequear la ultima condicion de dicho while
		// En esta linea tmb "se aplica" shortcircuit
		return esCapicua && origen.pilaVacia();
	}

	// ej01_b
	public static void quitarDuplicados(OwnPila origen) {
		OwnPila apilando = new OwnPila();
		apilando.inicializarPila();

		while (!origen.pilaVacia()) {
			int valorOrigen = origen.tope();
			var copiaApilando = TP01_02.copiarPila(apilando);
			boolean existe = false;

			while (!existe && !copiaApilando.pilaVacia()) {
				int valorCopia = copiaApilando.tope();

				existe = valorCopia == valorOrigen;
				copiaApilando.desapilar();
			}

			if (!existe) {
				apilando.apilar(valorOrigen);
			}

			origen.desapilar();
		}

		TP01_02.pasarPila(apilando, origen);
	}

	// ej01_c
	public static void repartirPilaMitades(OwnPila origen, OwnPila mitad1, OwnPila mitad2) {
		var invertida = TP01_02.invertirPila(origen);
		int conteo = TP01_02.contarPila(invertida);
		int index = 0;

		while (!invertida.pilaVacia()) {
			int valor = invertida.tope();

			if (index >= conteo / 2) {
				mitad1.apilar(valor);
			} else {
				mitad2.apilar(valor);
			}

			invertida.desapilar();
			index++;
		}

	}

	// ej01_d
	public static OwnPila obtenerDuplicados(OwnPila origen) {
		var result = new OwnPila();
		result.inicializarPila();
		
		var origenSinDuplicados = TP01_02.copiarPila(origen);
		quitarDuplicados(origenSinDuplicados);
		
		while (!origenSinDuplicados.pilaVacia()) {
			var copiaIterativaOrigen = TP01_02.copiarPila(origen);
			
			var valor = origenSinDuplicados.tope();
			int apariciones = 0;
			
			while (!copiaIterativaOrigen.pilaVacia()) {
				var valorIteracionCopia = copiaIterativaOrigen.tope();
				if (valorIteracionCopia == valor) {
					apariciones++;
				}
				
				copiaIterativaOrigen.desapilar();
			}
			
			if (apariciones>1) {
				result.apilar(valor);
			}
			
			origenSinDuplicados.desapilar();
		}
		
		return result;
	}
}
