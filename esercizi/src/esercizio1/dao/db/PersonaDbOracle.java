package esercizio1.dao.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import esercizio1.model.Persona;

public class PersonaDbOracle {
	// private List<Persona> listaPersone = new ArrayList<Persona>();
	private String codiceFisc = null;
	// driver e url db
	private final String driver = "oracle.jdbc.driver.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	// credenziali accesso
	private String user = "test";
	private String psw = "test";
	// connection, statement, query
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt;
	private String query = null;

	public PersonaDbOracle() {
	}

	public void connetti() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, psw);
		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void disconnetti() {
		try {
			if (stmt != null && conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

	public void createDataBase() throws Exception {
		// creo database se non esiste!
		stmt = conn.createStatement();
		query = "CREATE DATABASE PERSONE";
		stmt.executeUpdate(query);
		stmt.close();

		//
		stmt = conn.createStatement();
		query = "CREATE TABLE PERSONE.PERSONA (" + "Nome VARCHAR(30) NOT NULL," + "Cognome VARCHAR(30) NOT NULL,"
				+ "CodiceFisc VARCHAR(16) NOT NULL," + "Altezza DOUBLE NOT NULL," + "Peso DOUBLE NOT NULL,"
				+ "PRIMARY KEY (CodiceFisc));";
		stmt.executeUpdate(query);
		stmt.close();
	}

	public List<Persona> listaPersone()  {
		try {
			List<Persona> listaPersone = new ArrayList();
			stmt = conn.createStatement();
			query = "SELECT * FROM PERSONA";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Persona p = new Persona();
				p.setNome(rs.getString("Nome"));
				p.setCognome(rs.getString("Cognome"));
				p.setCodiceFisc(rs.getString("CodiceFisc"));
				p.setAltezza(rs.getDouble("Altezza"));
				p.setPeso(rs.getDouble("Peso"));
				listaPersone.add(p);
			}
			rs.close();
			stmt.close();
			return listaPersone;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public Persona trovaPersonaPerCodiceFiscale(String cf)  {
		for (Persona p : listaPersone()) {
			if (cf.equals(p.getCodiceFisc())) {
				codiceFisc = p.getCodiceFisc();
				return p;
			}
		}
		return null;
	}
	
	private String nextId() {
		try {
			String ret="";
			
			String query = "select seq.nextval as id from dual";
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				ret=rs.getString("id");
			}
			stmt.close();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void inserisciPersona(Persona p) {
		try {
			String id=nextId();
			
			String query = "INSERT INTO PERSONA (idPersona,NOME,COGNOME,CodiceFisc,Altezza,Peso) VALUES ( ? ,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1, id);
			pst.setString(2, p.getNome());
			pst.setString(3, p.getCognome());
			pst.setString(4, p.getCodiceFisc());
			pst.setDouble(5, p.getAltezza());
			pst.setDouble(6, p.getPeso());
			pst.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void cancellaPersona(Persona p) {
		try {
			stmt = conn.createStatement();
			query = "DELETE FROM PERSONA " + "WHERE idPersona = '" + p.getIdPersona() + "'";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void modificaPersona(Persona p) {
		try {
			String query = "UPDATE PERSONA SET Nome = ?, Cognome=? , codiceFisc=?, Altezza=? , Peso=? where idPersona=?";
			PreparedStatement pst=conn.prepareStatement(query);
			pst.setString(1, p.getNome());
			pst.setString(2, p.getCognome());
			pst.setString(3, p.getCodiceFisc());
			pst.setDouble(4, p.getAltezza());
			pst.setDouble(5, p.getPeso());
			pst.setString(6, p.getIdPersona());
			pst.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}