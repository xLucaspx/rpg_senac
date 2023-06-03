package models.personagem;

import models.Raca;

public class Barbaro extends Personagem {
	private int forca;
	private int vitalidade;

	public Barbaro(String nome, Raca raca) {
		super(nome, raca, Classe.BARBARO);
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getVitalidade() {
		return vitalidade;
	}

	public void setVitalidade(int vitalidade) {
		this.vitalidade = vitalidade;
	}

	@Override
	public String toString() {
		return String.format("%s\nForça: %d\nVitalidade: %d", super.toString(), this.getForca(), this.getVitalidade());
	}
}
