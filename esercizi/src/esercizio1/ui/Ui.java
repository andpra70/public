package esercizio1.ui;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import esercizio1.logic.PersonaManager;
import esercizio1.model.Persona;

public class Ui {

	private PersonaManager manager ;

	public Ui() throws Exception {
		manager = new PersonaManager();
	}
	/**
	 * mostra la lista delle persone su console
	 */
	public void mostraListaPersone() {
		List<Persona> lista = manager.listaPersone();
		if( lista.isEmpty() ) {
			System.out.println("non ci sono persone");
		}
		Collections.sort(lista);
		for (Persona p : lista) {
			System.out.println(p);
		}
	}

	/**
	 * legge i campi della persona da console e valorizza la persona
	 * 
	 * @param p
	 */
	private void leggiPersona(Persona p) {
		System.out.println("Inserisci il Nome della persona: ("+p.getNome()+")"); 
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String nome = input.nextLine();
		p.setNome(nome.toUpperCase());
		System.out.println("Inserisci il Cognome della persona: ("+p.getCognome()+")");
		input = new Scanner(System.in);
		String cognome = input.nextLine();
		p.setCognome(cognome.toUpperCase());
		String code;
		for (;;) {
			System.out.println("Inserisci il codice fiscale: ("+p.getCodiceFisc()+")");
			input = new Scanner(System.in);
			code = input.nextLine();
			p.setCodiceFisc(code.toUpperCase());
			break;
			/*
			if (code.length() == 16) {
				break;
			} else {
				System.out.println("Errore. Il codice fiscale deve essere lungo 16 caratteri");
			}
			 */
		}
		System.out.println("Inserisci L'altezza della persona: ("+p.getAltezza()+")");
		input = new Scanner(System.in);
		double h = input.nextDouble();
		p.setAltezza(h);
		System.out.println("Inserisci il peso della persona: ("+p.getPeso()+")");
		input = new Scanner(System.in);
		double w = input.nextDouble();
		p.setPeso(w);		
	}

	/**
	 * inserisce la persona
	 * 
	 */
	public void inserisciPersona() {
		Persona p = manager.creaPersona();
		leggiPersona(p);
		manager.inserisciPersona(p);
	}

	private Persona cercaPersona() {
		System.out.println("Cerca Persona : Inserisci iniziale cf:");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String cf = input.nextLine();
		Persona p = manager.trovaPersonaPerCodiceFiscale(cf);
		if (p == null) {
			System.out.println("non trovo persona con cf=" + cf);
		}
		return p;
	}

	/**
	 * modifica una persone
	 * @throws SQLException 
	 */
	public void modificaPersona(){
		Persona p = cercaPersona();
		if (p != null) {
			leggiPersona(p);
			manager.aggiornaPersona(p);
		}
	}

	/**
	 * modifica una persone
	 * @throws SQLException 
	 */
	public void cancellaPersona() {
		Persona p = cercaPersona();
		if (p != null) {
			manager.cancellaPersona(p);
		}
	}

	public void goal(){
		for (;;) {
			System.out.println("Premi: \n 1)Per visualizzare la lista delle persone\n 2)Per inserire una persona\n "
					+ "3)Per cancellare una persona\n 4)Per modificare una persona\n 5) Per uscire dal programma");

			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			int dato = input.nextInt();
			switch (dato) {
			case 1:
				mostraListaPersone();
				break;
			case 2:
				inserisciPersona();
				break;
			case 3:
				cancellaPersona();
				break;
			case 4:
				modificaPersona();
				break;
			case 5:// QUIT
				manager.disconnettidb();
				return;
			default:
				System.out.println("Errore. Inserisci un numero da 1 a 5");
				break;
			}
		}
	}

}
