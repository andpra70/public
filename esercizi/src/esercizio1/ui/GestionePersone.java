package esercizio1.ui;

public class GestionePersone {

	private Ui ui ;

	public GestionePersone() throws Exception {
		 ui = new Ui();
	}

	public void go(){
		ui.goal();
	}

	public static void main(String[] args) throws Exception{
		GestionePersone p = new GestionePersone();
		p.go();
	}

}
