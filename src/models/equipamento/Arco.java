package models.equipamento;

public class Arco extends Equipamento {
	private Tamanho tamanho;
	private boolean composto;

	public Arco(Material material, Tamanho tamanho, boolean composto) {
		super(material, TipoEquipamento.ARCO);
		this.tamanho = tamanho;
		this.composto = composto;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public boolean isComposto() {
		return composto;
	}

	@Override
	public String toString() {
		return String.format("Arco %s %s de %s", (this.composto ? "Composto" : "Inteiro"), this.tamanho,
				this.getMaterial());
	}
}
