package symboltable;

import java.util.*;
import ast.definiciones.Definicion;

public class SymbolTable {
	
	private int scope = 0;
	private List<Map<String, Definicion>> table;

	public SymbolTable()  {
		this.table = new ArrayList<>();
		this.table.add(new HashMap<>());
	}

	/**
	 * Metodo que se usa al entrar en un nuevo ambito.
	 * Incrementa la variable que contabiliza el ambito actual en una unidad
	 * y agrega una nueva tabla se simbolos para el nuevo nivel de ambito
	 */
	public void set() {
		scope++;
		this.table.add(new HashMap<>());
	}

	/**
	 * Metodo que se usa al salir de un ambito.
	 * Elimina la tabla de simbolos correspondiente al nivel de ambito del que salimos
	 * y decrementa la variable que contabiliza el ambito actual en una unidad
	 */
	public void reset() {
		this.table.remove(scope);
		scope--;
	}

	/**
	 * Inserta la definicion en el ambito actual.
	 * @param definicion, la definicion a insertar en el ambito actual.
	 * @return false si ya hay una definicion registrada en ese mismo ambito.
	 * true si se ha registrado la definicion con exito.
	 */
	public boolean insert(Definicion definicion) {
		// Comprobacion de que no haya definiciones duplicadas en mismo ambito
		if(findInCurrentScope(definicion.getNombre())) {
			return false;
		}
		definicion.setScope(scope);
		this.table.get(scope).put(definicion.getNombre(), definicion);
		return true;
	}

	/**
	 * Busca y retorna la definicion asociada al id recibido por parametro
	 * @param id, el id de la definicion a buscar
	 * @return null si no existe una definicion registrada para el id recibido.
	 * La definicion registrada para el id recibido.
	 */
	public Definicion find(String id) {
		for(int nivelAmbito = this.table.size() - 1; nivelAmbito > -1; nivelAmbito--) {
			if(this.table.get(nivelAmbito).get(id) != null) {
				return this.table.get(nivelAmbito).get(id);
			}
		}
		return null;
	}

	//package-protected for testing pourposes
	boolean findInCurrentScope(String id) {
		return this.table.get(scope).containsKey(id);
	}
}
