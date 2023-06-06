package models.inimigo;

import static java.util.Map.entry;

import java.util.Collections;
import java.util.Map;

import models.Raca;
import models.equipamento.Equipamento;
import models.personagem.Classe;

public class Humanoide extends Inimigo {
	private static Map<Integer, Raca> racasDisponiveis = Map.ofEntries(entry(1, Raca.GOBLIN), entry(2, Raca.KOBOLD),
			entry(3, Raca.BUGBEAR));

	private boolean rangedAttack;
	private Equipamento equipamento; // apenas 1 dos equipamentos disponíveis

	public Humanoide(String nome, int nivel, int rewardXp, Raca raca, boolean rangedAttack) {
		super(nome, nivel, rewardXp, Classe.HUMANOIDE);
		this.setRaca(raca);
		this.rangedAttack = rangedAttack;
	}

	@Override
	public void setRaca(Raca raca) {
		if (racasDisponiveis.containsValue(raca)) {
			super.setRaca(raca);
			return;
		}
		throw new IllegalArgumentException(
				String.format("As raças permitidas para Humanoide são: %s", racasDisponiveis.values()));
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public boolean hasRangedAttack() {
		return this.rangedAttack;
	}

	public static Map<Integer, Raca> getRacasDisponiveis() {
		return Collections.unmodifiableMap(racasDisponiveis);
	}

	@Override
	public String toString() {
		return String.format("%s\nRanged Attack: %b\nEquipamento: %s", super.toString(), this.hasRangedAttack(),
				(this.getEquipamento() != null ? this.getEquipamento() : "Não possui"));
	}
}
