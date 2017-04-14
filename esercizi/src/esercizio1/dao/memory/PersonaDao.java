package esercizio1.dao.memory;

import java.util.ArrayList;
import java.util.List;

import esercizio1.model.Persona;

public class PersonaDao {
	private List<Persona> listaPersone = new ArrayList<Persona>();

	public List<Persona> listaPersone() {
		return listaPersone;
	}

	/**
	 * trova una persona per cf esattamente uguale
	 * 
	 * @param cf
	 * @return
	 */
	public Persona trovaPersonaPerCodiceFiscale(String cf) {
		for (Persona p : listaPersone) {
			if (cf.equals(p.getCodiceFisc())) {
				return p;
			}
		}
		return null;
	}

	/**
	 * trova la prima persona per cognome iniziale
	 * 
	 * @param cognomeLike
	 * @return
	 */
	public Persona trovaPersonaPerCognomeLike(String cognomeLike) {
		for (Persona p : listaPersone) {
			if (p.getCognome().startsWith(cognomeLike)) {
				return p;
			}
		}
		return null;
	}

	public void inserisciPersona(Persona p) {
		listaPersone.add(p);
	}

	public void cancellaPersona(Persona p) {
		listaPersone.remove(p);
	}

	public void aggiornaPersona(Persona p) {
		listaPersone.remove(p);
		listaPersone.add(p);
	}

}
