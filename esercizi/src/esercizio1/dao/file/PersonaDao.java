package esercizio1.dao.file;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import esercizio1.model.Persona;

public class PersonaDao {
	private List<Persona> listaPersone = new ArrayList<Persona>();
	private String NOMEFILE="C:/Users/ricky/Documents/Prova.xml";

	@SuppressWarnings("unchecked")
	public PersonaDao() {
		try {
			listaPersone=(List<Persona>) carica(NOMEFILE);
		}catch (Exception e) {
			e.printStackTrace();
			listaPersone = new ArrayList<Persona>();
		}
	}

	private void salva(Object f, String fileName) {
		try {
			XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
			encoder.writeObject(f);
			encoder.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Object carica(String fileName) throws FileNotFoundException {
		XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)));
		Object ret=dec.readObject();
		dec.close();
		return ret;
	}

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
		salva(listaPersone, NOMEFILE);
	}

	public void cancellaPersona(Persona p) {
		listaPersone.remove(p);
		salva(listaPersone, NOMEFILE);
	}

	public void aggiornaPersona(Persona p) {
		listaPersone.remove(p);
		listaPersone.add(p);
		salva(listaPersone, NOMEFILE);
	}

}
