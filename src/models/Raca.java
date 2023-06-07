package models;

public enum Raca {
	TROLL("Troll"), LIMO_SANGRENTO("Limo Sangrento"), MEIO_DRAGAO("Meio-Dragão"), ESQUELETO("Esqueleto"), ZUMBI("Zumbi"),
	SOMBRA("Sombra"), GOBLIN("Goblin"), KOBOLD("Kobold"), BUGBEAR("Bugbear"), ARANHA_GIGANTE("Aranha-gigante"),
	LOBO("Lobo"), CAVALO("Cavalo"), ANAO("Anão"), HUMANO("Humano"), ELFO("Elfo");

	private String raca;

	private Raca(String raca) {
		this.raca = raca;
	}

	@Override
	public String toString() {
		return raca;
	}
}
