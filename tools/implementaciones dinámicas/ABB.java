package impleLocal;

import tdaLocal.ABBTDA;

public class ABB implements ABBTDA {
	private class NodoABB {
		int info;
		ABBTDA hijoIzq;
		ABBTDA hijoDer;
	} 
	private NodoABB raiz;

	public void inicializarArbol(){
		raiz = null;
	}

	public int raiz(){
		return raiz.info;
	}

	public boolean arbolVacio(){
		return (raiz == null);
	}

	public ABBTDA hijoDer(){
		return raiz.hijoDer;
	}

	public ABBTDA hijoIzq(){
		return raiz.hijoIzq;
	}

	private int mayor(ABBTDA a){
		if (a.hijoDer().arbolVacio())
			return a.raiz(); //llegamos
		else
			return mayor(a.hijoDer()); //no llegamos todavía
	}

	private int menor(ABBTDA a){
		if (a.hijoIzq().arbolVacio())
			return a.raiz(); //llegamos
		else
			return menor(a.hijoIzq()); //no llegamos todavía
	}

	 
	public void agregarElem(int x){
		if (raiz == null){ //caso de árbol vacío
			raiz = new NodoABB();
			raiz.info = x;
			raiz.hijoIzq = new ABB();
			raiz.hijoIzq.inicializarArbol();
			raiz.hijoDer = new ABB();
			raiz.hijoDer.inicializarArbol();
		} else if (raiz.info > x) //caso de árbol izquierdo
			raiz.hijoIzq.agregarElem(x);
		else if (raiz.info < x) //caso de árbol derecho
			raiz.hijoDer.agregarElem(x);
	}

	public void eliminarElem(int x){
		if (raiz != null) { //verificación de árbol no vacío
			if (raiz.info == x && raiz.hijoIzq.arbolVacio() && raiz.hijoDer.arbolVacio()){
				raiz = null;
			} else if (raiz.info == x && !raiz.hijoIzq.arbolVacio()) {
				raiz.info = mayor(raiz.hijoIzq); //reemplazamos con el mayor de los menores
				raiz.hijoIzq.eliminarElem(raiz.info);
			} else if (raiz.info == x && raiz.hijoIzq.arbolVacio()){
				raiz.info = menor(raiz.hijoDer); //reemplazamos con el menor de los mayores
				raiz.hijoDer.eliminarElem(raiz.info);
			} else if (raiz.info < x){ //seguimos buscando por los mayores (derecha)
				raiz.hijoDer.eliminarElem(x);
			} else {
				raiz.hijoIzq.eliminarElem(x); //seguimos buscando por los menores (izquierda)
			}
		}
	}
} 
