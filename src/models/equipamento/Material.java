package models.equipamento;

public enum Material {
	MADEIRA("Madeira"), FERRO("Ferro"), ACO("Aço"), CRISTAL("Cristal"), PLATINA("Platina"), OURO("Ouro"), PRATA("Prata"),
	BRONZE("Bronze"), PEDRA("Pedra");

	private String material;

	private Material(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return this.material;
	}
}
