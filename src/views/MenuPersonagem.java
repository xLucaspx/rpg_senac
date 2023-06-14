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
		
		int pontosDisponiveis = 30;
		int valorAtributo;

		switch (classe) {
			case BARBARO -> {
				Barbaro b = new Barbaro(nome, raca);
				
				valorAtributo = defineAtributo(s, "Força", pontosDisponiveis);
				b.setForca(valorAtributo);
				pontosDisponiveis -= valorAtributo;
				b.setVitalidade(defineAtributo(s, "Vitalidade", pontosDisponiveis));
				
				return b;
			}
			case DRUIDA -> {
				Druida d = new Druida(nome, raca);
				
				valorAtributo = defineAtributo(s, "Destreza", pontosDisponiveis);
				d.setDestreza(valorAtributo);
				pontosDisponiveis -= valorAtributo;
				d.setCarisma(defineAtributo(s, "Carisma", pontosDisponiveis));
				
				return d;
			}
			case MAGO -> {
				Mago m = new Mago(nome, raca);
				
				valorAtributo = defineAtributo(s, "Energia", pontosDisponiveis);
				m.setEnergia(valorAtributo);
				pontosDisponiveis -= valorAtributo;
				m.setInteligencia(defineAtributo(s, "Inteligência", pontosDisponiveis));
				
				return m;
			}
			default -> {
				throw new IllegalArgumentException("Classe inválida para personagem: " + classe);
			}
		}
	}
	
	private int defineAtributo(Scanner s, String atributo, int pontosDisponiveis) {
		int valor;
		boolean escolhaInvalida;
		
		do {
			System.out.print(String.format("\nPontos disponíveis: %d\nQuantos pontos você quer atribuir para %s? ", pontosDisponiveis, atributo));
			
			try {
				valor = Integer.parseInt(s.nextLine());
				escolhaInvalida = (valor < 1 || valor > pontosDisponiveis);
				
				if (escolhaInvalida)
					throw new IllegalArgumentException("O valor deve estar entre 1 e " + pontosDisponiveis);
				
			} catch (Exception e) {
				valor = 0;
				escolhaInvalida = true;
				System.out.println("Valor inválido: " + e.getMessage());
			}
		} while (escolhaInvalida);
		
		return valor;
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
