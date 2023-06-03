package views;

import java.util.HashMap;
import java.util.Scanner;

import models.Raca;
import models.personagem.Barbaro;
import models.personagem.Classe;
import models.personagem.Druida;
import models.personagem.Mago;
import models.personagem.Personagem;

public class MenuPersonagem extends Menu {
	private Scanner s;
	private HashMap<Integer, Object> mapClasses = new HashMap<>(Personagem.getClassesDisponiveis());
	private HashMap<Integer, Object> mapRacas = new HashMap<>(Personagem.getRacasDisponiveis());

	public MenuPersonagem() {
		this.s = new Scanner(System.in);
	}

	public Personagem criaPersonagem() {
		Raca raca = escolheRaca();
		Classe classe = escolheClasse();
		String nome = escolheNome();

		s.close();

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
			throw new IllegalArgumentException("Ocorreu um erro ao tentar instanciar a classe " + classe);
		}
		}
	}

	private Classe escolheClasse() {
		int codigo;
		boolean escolhaInvalida;

		do {
			this.criaMenu(this.mapClasses);
			System.out.print("Escolha a classe: ");

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

		return (Classe) mapClasses.get(codigo);
	}

	@Override
	protected Raca escolheRaca() {
		int codigo;
		boolean escolhaInvalida;

		do {
			this.criaMenu(this.mapRacas);
			System.out.print("Escolha a raça: ");

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

		return (Raca) this.mapRacas.get(codigo);
	}

	@Override
	protected String escolheNome() {
		System.out.print("\nDigite o nome do personagem: ");
		String nome = s.nextLine();

		return nome;
	}
}
