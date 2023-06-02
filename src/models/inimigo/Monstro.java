package models.inimigo;

import models.Raca;

public class Monstro extends Inimigo {
	// raça: troll, limo sangrento, meio dragão
	private boolean voador;

	public Monstro(String nome, int nivel, int rewardXp, Raca raca, boolean voador) {
		super(nome, nivel, rewardXp);
		this.setRaca(raca);
		this.voador = voador;
	}

	@Override
	public void setRaca(Raca raca) {
		if (raca.equals(Raca.TROLL) || raca.equals(Raca.LIMO_SANGRENTO) || raca.equals(Raca.MEIO_DRAGAO)) {
			super.setRaca(raca);
			return;
		}
		throw new IllegalArgumentException(String.format("As raças permitidas para Monstro são: %s, %s e %s", Raca.TROLL,
				Raca.LIMO_SANGRENTO, Raca.MEIO_DRAGAO));
	}

	public boolean isVoador() {
		return this.voador;
	}

	@Override
	public String toString() {
		return String.format("%s\nVoador: %b", super.toString(), this.isVoador());
	}
}
