package models.inimigo;

import static java.util.Map.entry;

import java.util.Collections;
import java.util.Map;

import models.Raca;
import models.personagem.Classe;

public class Monstro extends Inimigo {
	private static Map<Integer, Raca> racasDisponiveis = Map.ofEntries(entry(1, Raca.TROLL),
			entry(2, Raca.LIMO_SANGRENTO), entry(3, Raca.MEIO_DRAGAO));

	private boolean voador;

	public Monstro(String nome, int nivel, int rewardXp, Raca raca, boolean voador) {
		super(nome, nivel, rewardXp, Classe.MONSTRO);
		this.setRaca(raca);
		this.voador = voador;
	}

	@Override
	public void setRaca(Raca raca) {
		if (racasDisponiveis.containsValue(raca)) {
			super.setRaca(raca);
			return;
		}
		throw new IllegalArgumentException(
				String.format("As raças permitidas para Monstro são: %s", racasDisponiveis.values()));
	}

	public boolean isVoador() {
		return this.voador;
	}

	public static Map<Integer, Raca> getRacasDisponiveis() {
		return Collections.unmodifiableMap(racasDisponiveis);
	}

	@Override
	public String toString() {
		return String.format("%s\nVoador: %b", super.toString(), this.isVoador());
	}
}
