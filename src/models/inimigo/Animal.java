package models.inimigo;

import static java.util.Map.entry;

import java.util.Collections;
import java.util.Map;

import models.Raca;
import models.personagem.Classe;

public class Animal extends Inimigo {
	private static Map<Integer, Raca> racasDisponiveis = Map.ofEntries(Map.entry(1, Raca.ARANHA_GIGANTE), entry(2, Raca.LOBO),
			entry(3, Raca.CAVALO));

	public Animal(String nome, int nivel, int rewardXp, Raca raca) {
		super(nome, nivel, rewardXp, Classe.ANIMAL);
		this.setRaca(raca);
	}

	@Override
	public void setRaca(Raca raca) {
		if (racasDisponiveis.containsValue(raca)) {
			super.setRaca(raca);
			return;
		}
		throw new IllegalArgumentException(
				String.format("As raças permitidas para Animal são: %s", racasDisponiveis.values()));
	}

	public static Map<Integer, Raca> getRacasDisponiveis() {
		return Collections.unmodifiableMap(racasDisponiveis);
	}
}
