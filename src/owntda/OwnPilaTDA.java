package owntda;

public interface OwnPilaTDA {
	/**
	 * Inicializa la pila
	 */
	void inicializarPila();
	
	/**
	 * Precondicion: Pila inicializada
	 * Añade un valor a la pila
	 */
	void apilar(int x);
	
	/**
	 * Precondicion: Pila inicializada
	 * Quita el valor tope de la pila
	 */
	void desapilar();
	
	/**
	 * Precondicion: Pila inicializada
	 * Obtiene el valor del tope de la pila
	 */
	int tope();
	
	/**
	 * Precondicion: Pila inicializada
	 * @return boolean verdadero si la pila no contiene valores
	 */
	boolean pilaVacia();
}
