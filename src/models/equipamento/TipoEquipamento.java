package models.equipamento;

public enum TipoEquipamento {
	ESPADA("Espada"), ESCUDO("Escudo"), ARCO("Arco");
	
	private String tipoEquipamento;
	
	private TipoEquipamento(String tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}
	
	@Override
	public String toString() {
		return tipoEquipamento;
	}
}
