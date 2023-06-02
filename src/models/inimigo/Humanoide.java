package models.inimigo;

import models.Raca;
import models.equipamento.Equipamento;

public class Humanoide extends Inimigo {
	// raça: goblin, kobold, bugbear
	private boolean rangedAttack;
	private Equipamento equipamento; // apenas 1 dos equipamentos disponíveis

	public Humanoide(String nome, int nivel, int rewardXp, Raca raca, boolean rangedAttack) {
		super(nome, nivel, rewardXp);
		this.setRaca(raca);
		this.rangedAttack = rangedAttack;
	}

	@Override
	public void setRaca(Raca raca) {
		if (raca.equals(Raca.GOBLIN) || raca.equals(Raca.KOBOLD) || raca.equals(Raca.BUGBEAR)) {
			super.setRaca(raca);
			return;
		}
		throw new IllegalArgumentException(
				String.format("As raças permitidas para Humanoide são: %s, %s e %s", Raca.GOBLIN, Raca.KOBOLD, Raca.BUGBEAR));
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

	@Override
	public String toString() {
		return String.format("%s\nRanged Attack: %b\nEquipamento: %s", super.toString(), this.hasRangedAttack(),
				(this.getEquipamento() != null ? this.getEquipamento() : "Não possui"));
	}
}
