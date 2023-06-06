package models.inimigo;

import static java.util.Map.entry;

import java.util.Collections;
import java.util.Map;

import models.Fraqueza;
import models.Raca;
import models.personagem.Classe;

public class MortoVivo extends Inimigo {
	private static Map<Integer, Raca> racasDisponiveis = Map.ofEntries(entry(1, Raca.ESQUELETO), entry(2, Raca.ZUMBI),
			entry(3, Raca.SOMBRA));

	private Fraqueza fraqueza;

	public MortoVivo(String nome, int nivel, int rewardXp, Raca raca, Fraqueza fraqueza) {
		super(nome, nivel, rewardXp, Classe.MORTO_VIVO);
		this.setRaca(raca);
		this.fraqueza = fraqueza;
	}

	@Override
	public void setRaca(Raca raca) {
		if (racasDisponiveis.containsValue(raca)) {
			super.setRaca(raca);
			return;
		}
		throw new IllegalArgumentException(
				String.format("As raças permitidas para Morto-Vivo são: %s", racasDisponiveis.values()));
	}

	public Fraqueza getFraqueza() {
		return fraqueza;
	}

	public static Map<Integer, Raca> getRacasDisponiveis() {
		return Collections.unmodifiableMap(racasDisponiveis);
	}

	@Override
	public String toString() {
		return String.format("%s\nFraqueza: %s", super.toString(), this.getFraqueza());
	}
}
