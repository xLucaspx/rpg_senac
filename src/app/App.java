package app;

import java.util.Scanner;

import models.equipamento.Equipamento;
import models.inimigo.Inimigo;
import models.personagem.Personagem;
import views.MenuPrincipal;

public class App {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		boolean executa = true;
		boolean escolhaInvalida;
		int codigo;

		MenuPrincipal menu = new MenuPrincipal();

		while (executa) {
			do {
				System.out.println("\n[1] Novo personagem");
				System.out.println("[2] Novo inimigo");
				System.out.println("[3] Novo equipamento");
				System.out.print("O que você deseja criar? ");

				try {
					codigo = Integer.parseInt(s.nextLine());
					escolhaInvalida = (codigo < 1 || codigo > 3);

					if (escolhaInvalida)
						throw new IllegalArgumentException("Não há opção especificada para o código " + codigo);

				} catch (Exception e) {
					codigo = 0;
					escolhaInvalida = true;
					System.out.println("Valor inválido: " + e.getMessage());
				}
			} while (escolhaInvalida);

			switch (codigo) {
				case 1 -> {
					Personagem p = menu.criaPersonagem(s);
					System.out.println("\n" + p);
				}
				case 2 -> {
					Inimigo i = menu.criaInimigo(s);
					System.out.println("\n" + i);
				}
				case 3 -> {
					Equipamento e = menu.criaEquipamento(s);
					System.out.println("\n" + e);
				}
				default -> {
					throw new IllegalArgumentException("Opção inválida: " + codigo);
				}
			}

			executa = menu.continuar(s);
		}

		System.out.println("Programa encerrado!");
		s.close();
	}
}
