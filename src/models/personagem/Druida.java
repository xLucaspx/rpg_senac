package models.personagem;

import models.Raca;

public class Druida extends Personagem {
	private int destreza;
	private int carisma;

	public Druida(String nome, Raca raca) {
		super(nome, raca);
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getCarisma() {
		return carisma;
	}

	public void setCarisma(int carisma) {
		this.carisma = carisma;
	}

	@Override
	public String toString() {
		return String.format("%s\nDestreza: %d\nCarisma: %d", super.toString(), this.getDestreza(), this.getCarisma());
	}
}
