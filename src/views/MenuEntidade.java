package views;

import java.util.Scanner;

import models.Raca;
import models.personagem.Classe;

public abstract class MenuEntidade extends Menu {
	protected abstract Classe escolheClasse(Scanner s);

	protected abstract Raca escolheRaca(Scanner s, Classe c);

	protected abstract String escolheNome(Scanner s);
}
