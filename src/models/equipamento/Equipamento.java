package models.equipamento;

import static java.util.Map.entry;

import java.util.Collections;
import java.util.Map;

public abstract class Equipamento {
	private static Map<Integer, Material> materiaisDisponiveis = Map.ofEntries(entry(1, Material.MADEIRA),
			entry(2, Material.PEDRA), entry(3, Material.FERRO), entry(4, Material.ACO), entry(5, Material.BRONZE),
			entry(6, Material.PRATA), entry(7, Material.OURO), entry(8, Material.PLATINA), entry(9, Material.CRISTAL));
	private static Map<Integer, TipoEquipamento> tiposDisponiveis = Map.ofEntries(entry(1, TipoEquipamento.ARCO),
			entry(2, TipoEquipamento.ESPADA), entry(3, TipoEquipamento.ESCUDO));

	private Material material;
	private TipoEquipamento tipoEquipamento; 
	public Equipamento(Material material, TipoEquipamento tipo) {
		this.material = material;
		this.tipoEquipamento = tipo;
	}

	public Material getMaterial() {
		return material;
	}
	
	public TipoEquipamento getTipoEquipamento() {
		return tipoEquipamento;
	}

	public static Map<Integer, Material> getMateriaisDisponiveis() {
		return Collections.unmodifiableMap(materiaisDisponiveis);
	}
	
	public static Map<Integer, TipoEquipamento> getTiposDisponiveis() {
		return Collections.unmodifiableMap(tiposDisponiveis);
	}
}
