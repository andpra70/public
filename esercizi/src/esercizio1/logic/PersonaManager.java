package esercizio1.logic;

import java.util.List;

import esercizio1.dao.db.PersonaDb;
import esercizio1.dao.db.PersonaDbOracle;
import esercizio1.model.Persona;

public class PersonaManager {

	private PersonaDbOracle personaDb ;

	public PersonaManager() throws Exception {
		personaDb = new PersonaDbOracle();
		personaDb.connetti();
		
		Persona p=new Persona();
		p.setNome("b");
		p.setCognome("b");
		p.setCodiceFisc("cf");
		p.setAltezza(0d);
		p.setPeso(0d);
		personaDb.inserisciPersona(p);
		//personaDb.createDataBase();
	}

	public Persona creaPersona() {
		Persona p = new Persona();
		return p;
	}

	public List<Persona> listaPersone() {
		return personaDb.listaPersone();
	}

	/**
	 * trova una persona per cf esattamente uguale
	 * 
	 * @param cf
	 * @return
	 */
	public Persona trovaPersonaPerCodiceFiscale(String cf) {
		return personaDb.trovaPersonaPerCodiceFiscale(cf);
	}

	/**
	 * trova la prima persona per cognome iniziale
	 * 
	 * @param cognomeLike
	 * @return

	public Persona trovaPersonaPerCognomeLike(String cognomeLike) {
		return personaDb.trovaPersonaPerCognomeLike(cognomeLike);
	}
	 */
	public void inserisciPersona(Persona p) {
		personaDb.inserisciPersona(p);
	}

	public void cancellaPersona(Persona p)  {
		personaDb.cancellaPersona(p);
	}

	public void aggiornaPersona(Persona p)  {
		personaDb.modificaPersona(p);
	}
	public void disconnettidb(){
		personaDb.disconnetti();
	}
}
