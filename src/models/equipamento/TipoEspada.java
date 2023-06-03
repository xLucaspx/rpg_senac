package models.equipamento;

public enum TipoEspada {
	// normal e dupla
	NORMAL("Normal"), DUPLA("Dupla");

	private String tipoEspada;

	private TipoEspada(String tipoEspada) {
		this.tipoEspada = tipoEspada;
	}

	@Override
	public String toString() {
		return this.tipoEspada;
	}
}