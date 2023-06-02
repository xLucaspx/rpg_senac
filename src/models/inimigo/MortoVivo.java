package models.inimigo;

import models.Fraqueza;
import models.Raca;

public class MortoVivo extends Inimigo {
	// raça: esqueleto, zumbi, sombra
	private Fraqueza fraqueza;

	public MortoVivo(String nome, int nivel, int rewardXp, Raca raca, Fraqueza fraqueza) {
		super(nome, nivel, rewardXp);
		this.setRaca(raca);
		this.fraqueza = fraqueza;
	}

	@Override
	public void setRaca(Raca raca) {
		if (raca.equals(Raca.ESQUELETO) || raca.equals(Raca.ZUMBI) || raca.equals(Raca.SOMBRA)) {
			super.setRaca(raca);
			return;
		}
		throw new IllegalArgumentException(
				String.format("As raças permitidas para Morto-Vivo são: %s, %s e %s", Raca.ESQUELETO, Raca.ZUMBI, Raca.SOMBRA));
	}

	public Fraqueza getFraqueza() {
		return fraqueza;
	}

	@Override
	public String toString() {
		return String.format("%s\nFraqueza: %s", super.toString(), this.getFraqueza());
	}
}
