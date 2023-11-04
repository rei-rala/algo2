package tdaLocal;

public interface ColaPrioridadTDA {
	void inicializarCola();
	void acolarPrioridad(int x, int prioridad); //cola inicializada
	void desacolar(); //cola inicializada y no vac�a
	int primero(); //cola inicializada y no vac�a
	int prioridad(); //cola inicializada y no vac�a
	boolean colaVacia(); //cola inicializada

}
