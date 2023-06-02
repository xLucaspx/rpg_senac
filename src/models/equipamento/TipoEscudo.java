package models.equipamento;

public enum TipoEscudo {
	// leve e pesado
	LEVE(0), PESADO(1);

	private int tipoEscudo;

	private TipoEscudo(int tipoEscudo) {
		this.tipoEscudo = tipoEscudo;
	}

	public int getTipoEscudo() {
		return tipoEscudo;
	}
}