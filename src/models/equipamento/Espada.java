package models.equipamento;

public class Espada extends Equipamento {
	private Tamanho tamanho;
	private TipoEspada tipo;
	
	public Espada(Material material, Tamanho tamanho, TipoEspada tipo) {
		super(material);
		this.tamanho = tamanho;
		this.tipo = tipo;
	}
	
	public Tamanho getTamanho() {
		return tamanho;
	}
	
	public TipoEspada getTipo() {
		return tipo;
	}
}
