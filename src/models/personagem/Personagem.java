package models.personagem;

import static java.util.Map.entry;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import models.Entidade;
import models.Raca;
import models.equipamento.Equipamento;

public abstract class Personagem extends Entidade {
	private static Map<Integer, Classe> classesDisponiveis = Map.ofEntries(entry(1, Classe.BARBARO),
			entry(2, Classe.DRUIDA), entry(3, Classe.MAGO));
	private static Map<Integer, Raca> racasDisponiveis = Map.ofEntries(entry(1, Raca.ANAO), entry(2, Raca.ELFO),
			entry(3, Raca.HUMANO));
	
	private static int nivelMinimo = 0;

	private int xp;
	private int limiteXp;
	/*
	 * Deveremos ter elementos para controle de nível, e de experiência (que sempre
	 * terá um limite de ((1000 x nível do personagem) + 1000) após o segundo nível,
	 * iniciando por pelo valor 0 de experiência. Ao se ganhar experiência, a mesma
	 * obedecerá ao cálculo anterior para que haja aumento de nível.
	 */
	// pontosDeVida: nível * 1.25;
	// poderDeAtaque: nível * 0.95
	private List<Equipamento> equipamentos = Arrays.asList(new Equipamento[2]); // até 2 equipamentos por personagem

	public Personagem(String nome, Raca raca, Classe classe) {
		super(nome, classe);
		this.setRaca(raca);
		this.levelUp();
	}

	private int levelUp() {
		int newLevel = this.getNivel() + 1;
		int limiteXp = newLevel > 1 ? (newLevel * 1000) + 1000 : 1000;
		int hp = (int) (newLevel * 1.25);
		int dano = (int) (newLevel * 0.95);

		this.setNivel(newLevel);
		this.setLimiteXp(limiteXp);
		this.setHp(hp > 0 ? hp : 1);
		this.setDanoAtaque(dano > 0 ? dano : 1);

		if (newLevel > Personagem.nivelMinimo) {
			setNivelMinimo(newLevel);
		}
		
		return newLevel;
	}

	public int getXp() {
		return xp;
	}

	private void setXp(int xp) {
		this.xp = xp;
	}

	public int getLimiteXp() {
		return limiteXp;
	}

	private void setLimiteXp(int limiteXp) {
		this.limiteXp = limiteXp;
	}

	public String addXp(int xp) {
		int limite = this.getLimiteXp();
		int somaXp = this.xp + xp;

		boolean levelUp = false;

		while (somaXp >= limite) {
			xp = somaXp - limite;
			this.levelUp();
			levelUp = true;
			limite = this.getLimiteXp();
			somaXp = xp;
		}

		this.setXp(xp);

		String retorno = String.format("Nível: %d\nXP: %d de %d", this.getNivel(), this.getXp(), this.getLimiteXp());

		if (levelUp) {
			return String.format("Level Up!\n%s\nHP: %d\nDano: %d", retorno, this.getHp(), this.getDanoAtaque());
		}
		return retorno;
	}

	public List<Equipamento> getEquipamentos() {
		return Collections.unmodifiableList(this.equipamentos);
	}

	public void setEquipamento(int slot, Equipamento equipamento) {
		this.equipamentos.set(slot, equipamento);
	}

	public Equipamento removeEquipamento(int index) {
		return this.equipamentos.remove(index);
	}

	public static Map<Integer, Classe> getClassesDisponiveis() {
		return Collections.unmodifiableMap(classesDisponiveis);
	}

	public static Map<Integer, Raca> getRacasDisponiveis() {
		return Collections.unmodifiableMap(racasDisponiveis);
	}
	
	public static int getNivelMinimo() {
		return nivelMinimo;
	}
	
	private static void setNivelMinimo(int nivelMinimo) {
		Personagem.nivelMinimo = nivelMinimo;
	}

	@Override
	public String toString() {
		return String.format("%s\nClasse: %s\nDano: %d\nXP: %d\nLimite XP: %d", super.toString(), this.getClasse(),
				this.getDanoAtaque(), this.getXp(), this.getLimiteXp());
	}
}
