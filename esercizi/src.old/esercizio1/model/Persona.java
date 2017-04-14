package esercizio1.model;

import java.util.*;

public class Persona implements Comparable<Persona> { // Creazione classe
	private String nome;
	private String cognome;
	private String codiceFisc;
	private Double altezza;
	private Double peso;
	private Date dataNascita;
	
	public Persona() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFisc() {
		return codiceFisc;
	}

	public void setCodiceFisc(String codiceFisc) {
		this.codiceFisc = codiceFisc;
	}

	public Double getAltezza() {
		return altezza;
	}

	public void setAltezza(Double altezza) {
		this.altezza = altezza;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	
	public Date getDataNascita() {
		return dataNascita;
	}
	
	public Long getEta() {
		Date oggi=new Date();
		long msecsDal1970=oggi.getTime()-dataNascita.getTime();
		return msecsDal1970/86400000L;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public int compareTo(Persona p) { // Ordinamento per Cognome
		return cognome.compareTo(p.cognome);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFisc == null) ? 0 : codiceFisc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (codiceFisc == null) {
			if (other.codiceFisc != null)
				return false;
		} else if (!codiceFisc.equals(other.codiceFisc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", codiceFisc=" + codiceFisc + ", altezza=" + altezza
				+ ", peso=" + peso + ", dataNascita=" + dataNascita + "]";
	}
	
	
}
