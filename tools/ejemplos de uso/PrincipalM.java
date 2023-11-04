package uso;

import imple.Cola;
import tda.ColaPrioridadTDA;
import tda.ColaTDA;

public class PrincipalM {
	
	//Métodos Externos
	
	//precondición: origen inicializada
	public static ColaTDA copiarCola(ColaTDA origen) { //costo polinómico
		ColaTDA copia = new Cola(); //C
		copia.inicializarCola(); //C
		ColaTDA aux = new Cola(); //C
		aux.inicializarCola(); //C
		while(!origen.colaVacia()) { //no constante
			//C
			int elem = origen.primero(); //C
			aux.acolar(elem); //L
			origen.desacolar(); //C
		} //-> P
		while(!aux.colaVacia()) {
			//C
			int elem = aux.primero(); //C
			origen.acolar(elem); //L
			copia.acolar(elem); //L
			aux.desacolar(); //C
		} //-> P
		return copia;
	} //postcondición: cola origen no se destruye //-> Cs + P + P -> P
	
	//precondición: origen inicializada
	public static void pasarCPa2Colas(ColaPrioridadTDA origen) {
		ColaTDA valores = new Cola();
		valores.inicializarCola();
		ColaTDA prioridades = new Cola();
		prioridades.inicializarCola();
		while(!origen.colaVacia()) {
			/*es igual a:
			int valor = origen.primero();
			int prioridad = origen.prioridad();
			valores.acolar(valor);
			prioridades.acolar(prioridad);*/
			valores.acolar(origen.primero());
			prioridades.acolar(origen.prioridad());
			origen.desacolar();
		}
		//TODO seguir con lo que haga falta con las dos colas
	}//postcondición: origen se destruye

	public static void main(String[] args) {
		//acá se hacen las pruebas
		//se declaran los TDA, se los llena de datos, se llaman los métodos externos
		
		ColaTDA cola1 = new Cola();
		cola1.inicializarCola();
		cola1.acolar(25);
		cola1.acolar(83);
		cola1.acolar(0);
		cola1.acolar(2);
		ColaTDA copiaDeCola1 = copiarCola(cola1);
		//con la copia hacemos lo que tengamos que hacer
		
		/*while(!cola1.colaVacia()) { //no constante
			//C
			int elem = cola1.primero(); //C
		} //-> L*/ //ejemplo de ciclo infinito
		
		//ColaPrioridadTDA CPaux = new ColaPrioridad();
	}

}
