package esercizio1.logic;

import java.util.List;

import esercizio1.dao.file.PersonaDao;
import esercizio1.model.Persona;

public class PersonaManager {

	private PersonaDao personaDao = new PersonaDao();

	public PersonaManager() {

	}

	public Persona creaPersona() {
		Persona p = new Persona();
		return p;
	}

	public List<Persona> listaPersone() {
		return personaDao.listaPersone();
	}

	/**
	 * trova una persona per cf esattamente uguale
	 * 
	 * @param cf
	 * @return
	 */
	public Persona trovaPersonaPerCodiceFiscale(String cf) {
		return personaDao.trovaPersonaPerCodiceFiscale(cf);
	}

	/**
	 * trova la prima persona per cognome iniziale
	 * 
	 * @param cognomeLike
	 * @return
	 */
	public Persona trovaPersonaPerCognomeLike(String cognomeLike) {
		return personaDao.trovaPersonaPerCognomeLike(cognomeLike);
	}

	public void inserisciPersona(Persona p) {
		personaDao.inserisciPersona(p);
	}

	public void cancellaPersona(Persona p) {
		personaDao.cancellaPersona(p);
	}

	public void aggiornaPersona(Persona p) {
		personaDao.aggiornaPersona(p);
	}

}
