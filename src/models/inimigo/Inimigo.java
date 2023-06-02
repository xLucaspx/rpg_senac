package models.inimigo;

import models.Entidade;

public abstract class Inimigo extends Entidade {
	private int rewardXp; // não pode ser maior que 10x o nível
	// hp = 10 * nivel

	public Inimigo(String nome, int nivel, int rewardXp) {
		this.setNome(nome);
		this.setNivel(nivel);
		this.setHp(nivel * 10);
		this.setRewardXp(rewardXp);
	}

	public int getRewardXp() {
		return rewardXp;
	}

	private void setRewardXp(int rewardXp) {
		if (rewardXp > (this.getNivel() * 10)) {
			rewardXp = this.getNivel() * 10;
		}
		this.rewardXp = rewardXp;
	}
	
	@Override
	public String toString() {
		return String.format("%s\nReward XP: %d", super.toString(), this.getRewardXp());
	}
}
