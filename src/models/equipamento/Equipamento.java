package models.equipamento;

public abstract class Equipamento {
	private Material material;

	public Equipamento(Material material) {
		this.material = material;
	}

	public Material getMaterial() {
		return material;
	}
}
