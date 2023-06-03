package views;

import java.util.HashMap;

import models.Raca;

public abstract class Menu {

	protected abstract Raca escolheRaca();

	protected abstract String escolheNome();

	protected void criaMenu(HashMap<Integer, Object> params) {
		System.out.println(); // quebra de linha!

		for (HashMap.Entry<Integer, Object> param : params.entrySet()) {
			System.out.println(String.format("[%d] %s", param.getKey(), param.getValue()));
		}
	}
}
