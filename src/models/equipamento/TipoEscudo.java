package models.equipamento;

public enum TipoEscudo {
	// leve e pesado
	LEVE("Leve"), PESADO("Pesado");

	private String tipoEscudo;

	private TipoEscudo(String tipoEscudo) {
		this.tipoEscudo = tipoEscudo;
	}

	@Override
	public String toString() {
		return this.tipoEscudo;
	}
}