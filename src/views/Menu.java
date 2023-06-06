package views;

import java.util.HashMap;
import java.util.Scanner;

import models.Raca;
import models.personagem.Classe;

public abstract class Menu {

	protected abstract Classe escolheClasse(Scanner s);

	protected abstract Raca escolheRaca(Scanner s, Classe c);

	protected abstract String escolheNome(Scanner s);

	protected boolean escolheBoolean(Scanner s, String mensagem) {
		int codigo;
		boolean escolhaInvalida;

		do {
			System.out.println("\n[1] Sim\n[2] Não");
			System.out.println(mensagem);

			try {
				codigo = Integer.parseInt(s.nextLine());
				escolhaInvalida = (codigo < 1 || codigo > 2);

				if (escolhaInvalida)
					throw new IllegalArgumentException("Não há opção especificada para o código " + codigo);
			} catch (Exception e) {
				codigo = 0;
				escolhaInvalida = true;
				System.out.println("Valor inválido: " + e.getMessage());
			}
		} while (escolhaInvalida);

		return codigo == 1;
	}

	protected <V> void criaMenu(HashMap<Integer, V> params) {
		System.out.println(); // quebra de linha
		
		for (HashMap.Entry<Integer, V> param : params.entrySet()) {
			System.out.println(String.format("[%d] %s", param.getKey(), param.getValue()));
		}
	}
}
