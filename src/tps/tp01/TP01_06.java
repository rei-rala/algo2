package tps.tp01;

import ownimple.OwnCola;
import ownimple.OwnColaPrioridad;
import owntda.OwnColaPrioridadTDA;
import owntda.OwnColaTDA;
//import tda.ColaPrioridadTDA;

public class TP01_06 {
	public void pasarColaConPrioridad(OwnColaPrioridadTDA origen, OwnColaPrioridadTDA destino) {
		while (!origen.colaVacia()) {
			destino.acolarPrioridad(origen.primero(), origen.prioridad());
			origen.desacolar();
		}
	}
	
	public static OwnColaPrioridadTDA combinarColasPrioridad(OwnColaPrioridadTDA cp1, OwnColaPrioridadTDA cp2) {
		OwnColaPrioridadTDA destino = new OwnColaPrioridad();
		destino.inicializarCola();
		
		// Dada la comparacion al acolar (prioridad>=)
		// Se acola primero los valores de cp2		
		while (!cp1.colaVacia()) {
			destino.acolarPrioridad(cp1.primero(), cp1.prioridad());
			cp1.desacolar();
		}
		
		while (!cp2.colaVacia()) {
			destino.acolarPrioridad(cp2.primero(), cp2.prioridad());
			cp2.desacolar();
		}
		
		return destino;
	}
	
	public static OwnColaPrioridadTDA pasarColaPrioridadHacia2Colas(OwnColaPrioridadTDA origen) {
		OwnColaPrioridadTDA resultado = new OwnColaPrioridad();
		
		OwnColaTDA valores = new OwnCola();
		valores.inicializarCola();
		
		OwnColaPrioridadTDA CPaux = new OwnColaPrioridad();
		CPaux.inicializarCola();
		
		while (!origen.colaVacia()) {
			
			
			origen.desacolar();
		}
		
		return resultado;
	}
}
