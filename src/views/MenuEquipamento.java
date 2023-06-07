package views;

import static java.util.Map.entry;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import models.equipamento.Arco;
import models.equipamento.Equipamento;
import models.equipamento.Escudo;
import models.equipamento.Espada;
import models.equipamento.Material;
import models.equipamento.Tamanho;
import models.equipamento.TipoEquipamento;
import models.equipamento.TipoEscudo;
import models.equipamento.TipoEspada;

class MenuEquipamento extends Menu {
	private HashMap<Integer, TipoEquipamento> mapTipos = new HashMap<>(Equipamento.getTiposDisponiveis()); 
	private HashMap<Integer, Material> mapMateriais = new HashMap<>(Equipamento.getMateriaisDisponiveis());
	
	public Equipamento criaEquipamento(Scanner s) {
		TipoEquipamento tipo = escolheTipo(s);
		Material material = escolheMaterial(s);
		
		switch (tipo) {
			case ARCO -> {
				Tamanho tamanho = escolheTamanho(s, tipo);
				boolean composto = escolheBoolean(s, "O arco é composto? ");
				return new Arco(material, tamanho, composto);
			}
			case ESPADA -> {
				Tamanho tamanho = escolheTamanho(s, tipo);
				TipoEspada tipoEspada = escolheEspada(s);
				return new Espada(material, tamanho, tipoEspada);
			}
			case ESCUDO -> {
				TipoEscudo tipoEscudo = escolheEscudo(s);
				return new Escudo(material, tipoEscudo);
			}
			default -> {
				throw new IllegalArgumentException("Tipo inválido para equipamento: " + tipo);
			}
		}
	}
	
	private TipoEquipamento escolheTipo(Scanner s) {
		int codigo;
		boolean escolhaInvalida;
		
		do {
			this.criaMenu(mapTipos);
			System.out.print("Escolha o tipo do equipamento: ");
			
			try {
				codigo = Integer.parseInt(s.nextLine());
				escolhaInvalida = (codigo < 1 || codigo > this.mapTipos.size());
				
				if (escolhaInvalida)
					throw new IllegalArgumentException("Não há equipamento especificado para o código " + codigo);
				
			} catch (Exception e) {
				codigo = 0;
				escolhaInvalida = true;
				System.out.println("Valor inválido: " + e.getMessage());
			}
		} while (escolhaInvalida);
		
		return mapTipos.get(codigo);
	}

	private Material escolheMaterial(Scanner s) {
		int codigo;
		boolean escolhaInvalida;
		
		do {
			this.criaMenu(mapMateriais);
			System.out.print("Escolha o material do equipamento: ");
			
			try {
				codigo = Integer.parseInt(s.nextLine());
				escolhaInvalida = (codigo < 1 || codigo > this.mapMateriais.size());
				
				if (escolhaInvalida)
					throw new IllegalArgumentException("Não há material especificado para o código " + codigo);
				
			} catch (Exception e) {
				codigo = 0;
				escolhaInvalida = true;
				System.out.println("Valor inválido: " + e.getMessage());
			}
		} while (escolhaInvalida);
		
		return mapMateriais.get(codigo);
	}
	
	private Tamanho escolheTamanho(Scanner s, TipoEquipamento equipamento) {
		int codigo;
		boolean escolhaInvalida;
		HashMap<Integer, Tamanho> mapTamanhos = new HashMap<>(
				Map.ofEntries(entry(1, Tamanho.SHORT), entry(2, Tamanho.LONG)));

		do {
			this.criaMenu(mapTamanhos);
			System.out.print(String.format("Escolha o tamanho para o equipamento %s: ", equipamento));

			try {
				codigo = Integer.parseInt(s.nextLine());
				escolhaInvalida = (codigo < 1 || codigo > mapTamanhos.size());

				if (escolhaInvalida)
					throw new IllegalArgumentException("Não há tamanho especificado para o código " + codigo);

			} catch (Exception e) {
				codigo = 0;
				escolhaInvalida = true;
				System.out.println("Valor inválido: " + e.getMessage());
			}
		} while (escolhaInvalida);

		return mapTamanhos.get(codigo);
	}
	
	private TipoEspada escolheEspada(Scanner s) {
		int codigo;
		boolean escolhaInvalida;
		HashMap<Integer, TipoEspada> mapTipos = new HashMap<>(
				Map.ofEntries(entry(1, TipoEspada.NORMAL), entry(2, TipoEspada.DUPLA)));

		do {
			this.criaMenu(mapTipos);
			System.out.print("Escolha o modelo da sua espada: ");

			try {
				codigo = Integer.parseInt(s.nextLine());
				escolhaInvalida = (codigo < 1 || codigo > mapTipos.size());

				if (escolhaInvalida)
					throw new IllegalArgumentException("Não há modelo especificado para o código " + codigo);

			} catch (Exception e) {
				codigo = 0;
				escolhaInvalida = true;
				System.out.println("Valor inválido: " + e.getMessage());
			}
		} while (escolhaInvalida);

		return mapTipos.get(codigo);
	}
	
	private TipoEscudo escolheEscudo(Scanner s) {
		int codigo;
		boolean escolhaInvalida;
		HashMap<Integer, TipoEscudo> mapTipos = new HashMap<>(
				Map.ofEntries(entry(1, TipoEscudo.LEVE), entry(2, TipoEscudo.PESADO)));

		do {
			this.criaMenu(mapTipos);
			System.out.print("Escolha o modelo do seu escudo: ");

			try {
				codigo = Integer.parseInt(s.nextLine());
				escolhaInvalida = (codigo < 1 || codigo > mapTipos.size());

				if (escolhaInvalida)
					throw new IllegalArgumentException("Não há modelo especificado para o código " + codigo);

			} catch (Exception e) {
				codigo = 0;
				escolhaInvalida = true;
				System.out.println("Valor inválido: " + e.getMessage());
			}
		} while (escolhaInvalida);

		return mapTipos.get(codigo);
	}
}
