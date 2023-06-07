package views;

import java.util.Scanner;

import models.equipamento.Equipamento;
import models.inimigo.Inimigo;
import models.personagem.Personagem;

public class MenuPrincipal extends Menu {
	private static MenuPersonagem menuPersonagem = new MenuPersonagem();
	private static MenuInimigo menuInimigo = new MenuInimigo();
	private static MenuEquipamento menuEquipamento = new MenuEquipamento();
	
	public Personagem criaPersonagem(Scanner s) {
		return menuPersonagem.criaPersonagem(s);
	}
	
	public Inimigo criaInimigo(Scanner s) {
		return menuInimigo.criaInimigo(s);
	}
	
	public Equipamento criaEquipamento(Scanner s) {
		return menuEquipamento.criaEquipamento(s);
	}
	
	public boolean continuar(Scanner s) {
		return escolheBoolean(s, "Deseja criar mais alguma coisa? ");
	}
}
