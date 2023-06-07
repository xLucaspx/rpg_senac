package views;

import java.util.HashMap;
import java.util.Scanner;

import models.Raca;
import models.personagem.Barbaro;
import models.personagem.Classe;
import models.personagem.Druida;
import models.personagem.Mago;
import models.personagem.Personagem;

class MenuPersonagem extends MenuEntidade {
	private HashMap<Integer, Classe> mapClasses = new HashMap<>(Personagem.getClassesDisponiveis());
	private HashMap<Integer, Raca> mapRacas = new HashMap<>(Personagem.getRacasDisponiveis());

	public Personagem criaPersonagem(Scanner s) {
		Classe classe = escolheClasse(s);
		Raca raca = escolheRaca(s, classe);
		String nome = escolheNome(s);

		switch (classe) {
			case BARBARO -> {
				return new Barbaro(nome, raca);
			}
			case DRUIDA -> {
				return new Druida(nome, raca);
			}
			case MAGO -> {
				return new Mago(nome, raca);
			}
			default -> {
				throw new IllegalArgumentException("Classe inválida para personagem: " + classe);
			}
		}
	}

	@Override
	protected Classe escolheClasse(Scanner s) {
		int codigo;
		boolean escolhaInvalida;

		do {
			this.criaMenu(this.mapClasses);
			System.out.print("Escolha a classe do personagem: ");

			try {
				codigo = Integer.parseInt(s.nextLine());
				escolhaInvalida = (codigo < 1 || codigo > this.mapClasses.size());

				if (escolhaInvalida)
					throw new IllegalArgumentException("Não há classe especificada para o código " + codigo);

			} catch (Exception e) {
				codigo = 0;
				escolhaInvalida = true;
				System.out.println("Valor inválido: " + e.getMessage());
			}
		} while (escolhaInvalida);

		return mapClasses.get(codigo);
	}

	@Override
	protected Raca escolheRaca(Scanner s, Classe c) {
		int codigo;
		boolean escolhaInvalida;

		do {
			this.criaMenu(this.mapRacas);
			System.out.print("Escolha a raça do personagem: ");

			try {
				codigo = Integer.parseInt(s.nextLine());
				escolhaInvalida = (codigo < 1 || codigo > this.mapRacas.size());

				if (escolhaInvalida)
					throw new IllegalArgumentException("Não há raça especificada para o código " + codigo);

			} catch (Exception e) {
				codigo = 0;
				escolhaInvalida = true;
				System.out.println("Valor inválido: " + e.getMessage());
			}
		} while (escolhaInvalida);

		return this.mapRacas.get(codigo);
	}

	@Override
	protected String escolheNome(Scanner s) {
		String nome;
		do {
			System.out.print("\nDigite o nome do personagem: ");
			nome = s.nextLine();
		} while (nome.isBlank() || nome.isBlank());

		return nome.trim();
	}
}
