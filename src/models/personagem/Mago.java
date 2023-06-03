package models.personagem;

import models.Raca;

public class Mago extends Personagem {
	private int energia;
	private int inteligencia;

	public Mago(String nome, Raca raca) {
		super(nome, raca, Classe.MAGO);
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	@Override
	public String toString() {
		return String.format("%s\nEnergia: %d\nInteligência: %d", super.toString(), this.getEnergia(),
				this.getInteligencia());
	}
}
