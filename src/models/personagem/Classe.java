package models.personagem;

public enum Classe {
	BARBARO("Bárbaro"), DRUIDA("Druida"), MAGO("Mago");

	private String classe;

	private Classe(String classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return this.classe;
	}
}
