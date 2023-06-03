package models.equipamento;

public enum Tamanho {
	// short e long
	SHORT("Short"), LONG("Long");

	private String tamanho;

	private Tamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public String toString() {
		return this.tamanho;
	}
}
