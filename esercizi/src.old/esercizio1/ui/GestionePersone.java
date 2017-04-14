package esercizio1.ui;

public class GestionePersone {

	private Ui ui = new Ui();

	public GestionePersone() {

	}

	public void go() {
		ui.goal();
	}

	public static void main(String[] args) {
		GestionePersone p = new GestionePersone();
		p.go();
	}

}
