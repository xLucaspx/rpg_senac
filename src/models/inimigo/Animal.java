package models.inimigo;

import models.Raca;

public class Animal extends Inimigo {
	// raça: aranha gigante, lobo, cavalo

	public Animal(String nome, int nivel, int rewardXp, Raca raca) {
		super(nome, nivel, rewardXp);
		this.setRaca(raca);
	}

	@Override
	public void setRaca(Raca raca) {
		if (raca.equals(Raca.ARANHA_GIGANTE) || raca.equals(Raca.LOBO) || raca.equals(Raca.CAVALO)) {
			super.setRaca(raca);
			return;
		}
		throw new IllegalArgumentException(
				String.format("As raças permitidas para Animal são: %s, %s e %s", Raca.ARANHA_GIGANTE, Raca.LOBO, Raca.CAVALO));
	}
}
