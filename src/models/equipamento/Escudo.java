package models.equipamento;

public class Escudo extends Equipamento {
	private TipoEscudo tipo;

	public Escudo(Material material, TipoEscudo tipo) {
		super(material);
		this.tipo = tipo;
	}

	public TipoEscudo getTipo() {
		return tipo;
	}
}
