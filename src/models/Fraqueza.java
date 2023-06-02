package models;

public enum Fraqueza {
	// luz, fogo, gelo
	LUZ("Luz"), FOGO("Fogo"), GELO("Gelo");

	private String fraqueza;

	private Fraqueza(String fraqueza) {
		this.fraqueza = fraqueza;
	}

	@Override
	public String toString() {
		return this.fraqueza;
	}
}
