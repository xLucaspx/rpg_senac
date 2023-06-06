package models;

import models.personagem.Classe;

public abstract class Entidade {
	private int nivel;
	private String nome;
	private Raca raca;
	private Classe classe;
	private int hp;
	private int danoAtaque;

	public Entidade(String nome, Classe classe) {
		this.nome = nome;
		this.classe = classe;
	}

	public int getNivel() {
		return nivel;
	}

	protected void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Raca getRaca() {
		return raca;
	}

	protected void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Classe getClasse() {
		return classe;
	}

	public int getHp() {
		return hp;
	}

	protected void setHp(int hp) {
		this.hp = hp;
	}

	public int getDanoAtaque() {
		return danoAtaque;
	}

	protected void setDanoAtaque(int danoAtaque) {
		this.danoAtaque = danoAtaque;
	}

	@Override
	public String toString() {
		return String.format("Nome: %s\nRaça: %s\nNível: %d\nHP: %d", this.getNome(), this.getRaca(), this.getNivel(),
				this.getHp());
	}
}
