package models.equipamento;

public class Escudo extends Equipamento {
	private TipoEscudo tipo;

	public Escudo(Material material, TipoEscudo tipo) {
		super(material, TipoEquipamento.ESCUDO);
		this.tipo = tipo;
	}

	public TipoEscudo getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return String.format("Escudo %s de %s", this.tipo, this.getMaterial());
	}
}
