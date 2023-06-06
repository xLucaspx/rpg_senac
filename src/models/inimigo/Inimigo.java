package models.inimigo;

import static java.util.Map.entry;

import java.util.Collections;
import java.util.Map;

import models.Entidade;
import models.personagem.Classe;

public abstract class Inimigo extends Entidade {
	private static Map<Integer, Classe> classesDisponiveis = Map.ofEntries(entry(1, Classe.ANIMAL),
			entry(2, Classe.MONSTRO), entry(3, Classe.HUMANOIDE), entry(4, Classe.MORTO_VIVO));

	private int rewardXp; // não pode ser maior que 10x o nível
	// hp = 10 * nivel

	public Inimigo(String nome, int nivel, int rewardXp, Classe classe) {
		super(nome, classe);
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

	public static Map<Integer, Classe> getClassesDisponiveis() {
		return Collections.unmodifiableMap(classesDisponiveis);
	}

	@Override
	public String toString() {
		return String.format("%s\nReward XP: %d", super.toString(), this.getRewardXp());
	}
}
