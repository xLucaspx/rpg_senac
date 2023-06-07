package views;

import static java.util.Map.entry;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import models.Fraqueza;
import models.Raca;
import models.inimigo.Animal;
import models.inimigo.Humanoide;
import models.inimigo.Inimigo;
import models.inimigo.Monstro;
import models.inimigo.MortoVivo;
import models.personagem.Classe;
import models.personagem.Personagem;

class MenuInimigo extends MenuEntidade {
	private HashMap<Integer, Classe> mapClasses = new HashMap<>(Inimigo.getClassesDisponiveis());
	private HashMap<Integer, Raca> mapRacasAnimal = new HashMap<>(Animal.getRacasDisponiveis());
	private HashMap<Integer, Raca> mapRacasMonstro = new HashMap<>(Monstro.getRacasDisponiveis());
	private HashMap<Integer, Raca> mapRacasHumanoide = new HashMap<>(Humanoide.getRacasDisponiveis());
	private HashMap<Integer, Raca> mapRacasMortoVivo = new HashMap<>(MortoVivo.getRacasDisponiveis());

	public Inimigo criaInimigo(Scanner s) {
		Classe classe = escolheClasse(s);
		Raca raca = escolheRaca(s, classe);
		String nome = escolheNome(s);
		int nivel = escolheNivel(s, nome);
		int rewardXp = escolheRewardXp(s, nivel, nome);

		switch (classe) {
			case ANIMAL -> {
				return new Animal(nome, nivel, rewardXp, raca);
			}
			case MONSTRO -> {
				boolean voador = this.escolheBoolean(s, (nome + " pode voar? "));
				return new Monstro(nome, nivel, rewardXp, raca, voador);
			}
			case HUMANOIDE -> {
				boolean ranged = escolheBoolean(s, (nome + " possui ataque a distância? "));
				return new Humanoide(nome, nivel, rewardXp, raca, ranged);
			}
			case MORTO_VIVO -> {
				Fraqueza fraqueza = escolheFraqueza(s, nome);
				return new MortoVivo(nome, nivel, rewardXp, raca, fraqueza);
			}
			default -> {
				throw new IllegalArgumentException("Classe inválida para inimigo: " + classe);
			}
		}
	}

	@Override
	protected Classe escolheClasse(Scanner s) {
		int codigo;
		boolean escolhaInvalida;

		do {
			this.criaMenu(this.mapClasses);
			System.out.print("Escolha a classe do inimigo: ");

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
		HashMap<Integer, Raca> mapRacas;

		switch (c) {
			case ANIMAL -> {
				mapRacas = this.mapRacasAnimal;
			}
			case MONSTRO -> {
				mapRacas = this.mapRacasMonstro;
			}
			case HUMANOIDE -> {
				mapRacas = this.mapRacasHumanoide;
			}
			case MORTO_VIVO -> {
				mapRacas = this.mapRacasMortoVivo;
			}
			default -> {
				throw new IllegalArgumentException("Classe inválida para inimigo: " + c);
			}
		}

		do {
			this.criaMenu(mapRacas);
			System.out.print("Escolha a raça do inimigo: ");

			try {
				codigo = Integer.parseInt(s.nextLine());
				escolhaInvalida = (codigo < 1 || codigo > mapRacas.size());

				if (escolhaInvalida)
					throw new IllegalArgumentException("Não há raça especificada para o código " + codigo);

			} catch (Exception e) {
				codigo = 0;
				escolhaInvalida = true;
				System.out.println("Valor inválido: " + e.getMessage());
			}
		} while (escolhaInvalida);

		return mapRacas.get(codigo);
	}

	@Override
	protected String escolheNome(Scanner s) {
		String nome;
		do {
			System.out.print("\nDigite o nome do inimigo: ");
			nome = s.nextLine();
		} while (nome.isBlank() || nome.isBlank());

		return nome.trim();
	}

	private int escolheNivel(Scanner s, String nome) {
		int nivel;
		int nivelMaximo = (Personagem.getNivelMinimo() > 0 ? (Personagem.getNivelMinimo() * 2) : 1);
		boolean escolhaInvalida = false;
		

		do {
			System.out.print(String.format("\nDigite o nível de %s: ", nome));

			try {
				nivel = Integer.parseInt(s.nextLine());
				 escolhaInvalida = (nivel > nivelMaximo || nivel < 1);

				 if (escolhaInvalida)
						throw new IllegalArgumentException(
								"O nível de um inimigo não pode ser menor que 1 ou maior que 2x o nível do personagem mais forte; " +
								"caso nenhum personagem tenha sido criado, o nível do inimigo deve ser 1.\nValor máximo permitido: "
								+ nivelMaximo);
				 
			} catch (Exception e) {
				escolhaInvalida = true;
				nivel = 1;
				System.out.println("Valor inválido: " + e.getMessage());
			}
		} while (escolhaInvalida);

		return nivel;
	}

	private int escolheRewardXp(Scanner s, int nivel, String nome) {
		int rewardXp;
		boolean escolhaInvalida;

		do {
			System.out.print(String.format("\nDigite a recompensa em XP para quem derrotar %s: ", nome));

			try {
				rewardXp = Integer.parseInt(s.nextLine());
				escolhaInvalida = rewardXp > (nivel * 10) || rewardXp < 1;

				if (escolhaInvalida)
					throw new IllegalArgumentException("A recompensa não pode ser menor que 1 ou maior que 10x o nível do inimigo!\nValor máximo permitido: "
							+ (nivel * 10));

			} catch (Exception e) {
				escolhaInvalida = true;
				rewardXp = nivel * 10;
				System.out.println("Valor inválido: " + e.getMessage());
			}
		} while (escolhaInvalida);

		return rewardXp;
	}

	private Fraqueza escolheFraqueza(Scanner s, String nome) {
		int codigo;
		boolean escolhaInvalida;
		HashMap<Integer, Fraqueza> mapFraquezas = new HashMap<>(
				Map.ofEntries(entry(1, Fraqueza.FOGO), entry(2, Fraqueza.GELO), entry(3, Fraqueza.LUZ)));

		do {
			this.criaMenu(mapFraquezas);
			System.out.print(String.format("Escolha a fraqueza de %s: ", nome));

			try {
				codigo = Integer.parseInt(s.nextLine());
				escolhaInvalida = (codigo < 1 || codigo > mapFraquezas.size());

				if (escolhaInvalida)
					throw new IllegalArgumentException("Não há fraqueza especificada para o código " + codigo);

			} catch (Exception e) {
				codigo = 0;
				escolhaInvalida = true;
				System.out.println("Valor inválido: " + e.getMessage());
			}
		} while (escolhaInvalida);

		return mapFraquezas.get(codigo);
	}
}
