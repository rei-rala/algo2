package impleLocal;

import tdaLocal.ConjuntoTDA;
import tdaLocal.GrafoTDA;

public class GrafoDin implements GrafoTDA {
	private class NodoGrafo{
		int nodo ;
		NodoArista arista;
		NodoGrafo sigNodo;
	}

	private class NodoArista{
		int etiqueta;
		NodoGrafo nodoDestino;
		NodoArista sigArista;
	}
	
	private NodoGrafo origen;
	
	public void inicializarGrafo() {
		origen = null;
	}
	
	public void agregarVertice(int v) { //El vértice se inserta al inicio de la lista de nodos
		NodoGrafo aux = new NodoGrafo();
		aux.nodo = v;
		aux.arista = null ;
		aux.sigNodo = origen;
		origen = aux;
	}
	
	public void agregarArista(int v1, int v2, int peso ) {
		NodoGrafo n1 = vert2Nodo(v1); //Buscamos el nodo origen...
		NodoGrafo n2 = vert2Nodo(v2); //... y el nodo destino
		NodoArista aux = new NodoArista(); //La arista va al inicio de la lista...
		aux.etiqueta = peso; //... de aristas salientes de v1
		aux.nodoDestino = n2;
		aux.sigArista = n1.arista;
		n1.arista = aux;
	}
	
	private NodoGrafo vert2Nodo(int v) { //Dado un valor, busca el nodo correspondiente
		NodoGrafo aux = origen;
		while (aux != null && aux.nodo != v)
			aux = aux.sigNodo;
		return aux;
	}
	
	public void eliminarVertice(int v) {
		if (origen.nodo == v) //Es el origen
			origen = origen.sigNodo; //Se elimina el origen
		NodoGrafo aux = origen; //No es el origen; hay que buscarlo
		while (aux != null) { //Eliminamos aristas hacia v
			this.eliminarAristaNodo(aux, v);
			if (aux.sigNodo != null && aux.sigNodo.nodo == v)
				aux.sigNodo = aux.sigNodo.sigNodo; //Si es el nodo, lo elimina
			aux = aux.sigNodo; //Sigue eliminando aristas
		}
	}

	private void eliminarAristaNodo(NodoGrafo nodo, int v) {
		NodoArista aux = nodo.arista; //Elimina de nodo las aristas hacia v
		if (aux != null) {
			if (aux.nodoDestino.nodo == v) { //Hay que eliminar la primera arista
				nodo.arista = aux.sigArista;
			} else { //No es la primera; la buscamos
				while (aux.sigArista != null && aux.sigArista.nodoDestino.nodo != v)
					aux = aux.sigArista;
				if (aux.sigArista != null) { //Eliminamos la arista
					aux.sigArista = aux.sigArista.sigArista;
				}
			}
		}
	}
	
	public ConjuntoTDA vertices() {
		ConjuntoTDA c = new Conjunto();
		c.inicializarConjunto();
		NodoGrafo aux = origen;
		while (aux != null) {
			c.agregar(aux.nodo);
			aux = aux.sigNodo;
		}
		return c;
	}
	
	public void eliminarArista(int v1, int v2) {
		NodoGrafo n1 = vert2Nodo(v1);
		eliminarAristaNodo(n1, v2);
	}
	
	public boolean existeArista(int v1, int v2) {
		NodoGrafo n1 = vert2Nodo(v1);
		NodoArista aux = n1.arista;
		while (aux != null && aux.nodoDestino.nodo != v2) {
			aux = aux.sigArista;
		}
		//Solo si se encontro la arista buscada, aux no es null
		return aux != null;
	}
	
	public int pesoArista(int v1, int v2) {
		NodoGrafo n1 = vert2Nodo(v1);
		NodoArista aux = n1.arista;
		while (aux.nodoDestino.nodo != v2)
			aux = aux.sigArista; //Buscamos la arista
		return aux.etiqueta;
	}
}