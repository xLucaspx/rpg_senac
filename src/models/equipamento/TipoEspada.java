package models.equipamento;

public enum TipoEspada {
	// normal e dupla
	NORMAL(0), DUPLA(1);

	private int tipoEspada;

	private TipoEspada(int tipoEspada) {
		this.tipoEspada = tipoEspada;
	}

	public int getTipoEscudo() {
		return tipoEspada;
	}
}