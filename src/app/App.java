package app;

import models.Fraqueza;
import models.Raca;
import models.equipamento.Arco;
import models.equipamento.Escudo;
import models.equipamento.Espada;
import models.equipamento.Material;
import models.equipamento.Tamanho;
import models.equipamento.TipoEscudo;
import models.equipamento.TipoEspada;
import models.inimigo.Animal;
import models.inimigo.Humanoide;
import models.inimigo.Monstro;
import models.inimigo.MortoVivo;
import models.personagem.Barbaro;
import models.personagem.Druida;
import models.personagem.Mago;

public class App {
	public static void main(String[] args) {
		Escudo smallShield = new Escudo(Material.MADEIRA, TipoEscudo.LEVE);
		Escudo bigShield = new Escudo(Material.FERRO, TipoEscudo.PESADO);

		Espada shortSword = new Espada(Material.BRONZE, Tamanho.SHORT, TipoEspada.DUPLA);
		Espada bigSword = new Espada(Material.ACO, Tamanho.LONG, TipoEspada.NORMAL);

		Arco shortBow = new Arco(Material.CRISTAL, Tamanho.SHORT, false);
		Arco longBow = new Arco(Material.OURO, Tamanho.LONG, true);

		Barbaro p1 = new Barbaro("Rurtmos Maximus", Raca.HUMANO);
		p1.setForca(16);
		p1.setVitalidade(14);
		p1.setEquipamento(0, bigShield);
		p1.setEquipamento(1, bigSword);

		Druida p2 = new Druida("Luvon", Raca.ELFO);
		p2.setDestreza(15);
		p2.setCarisma(15);
		p2.setEquipamento(0, longBow);

		Mago p3 = new Mago("Unior Brondrak", Raca.ANAO);
		p3.setEnergia(12);
		p3.setInteligencia(18);
		p3.setEquipamento(0, shortSword);

		Animal i1 = new Animal("Rhotan", 2, 15, Raca.LOBO);

		Monstro i2 = new Monstro("Zulfem Zulak", 1, 18, Raca.TROLL, false);

		MortoVivo i3 = new MortoVivo("Grieveshade", 3, 35, Raca.SOMBRA, Fraqueza.LUZ);

		Humanoide i4 = new Humanoide("Jerd", 3, 25, Raca.GOBLIN, true);
		i4.setEquipamento(shortBow);

		System.out.println(p1.addXp(500) + "\n");
		System.out.println(p2.addXp(2500) + "\n");
		System.out.println(p1 + "\n");
		System.out.println(p2 + "\n");
		System.out.println(p3 + "\n");
		System.out.println(i1 + "\n");
		System.out.println(i2 + "\n");
		System.out.println(i3 + "\n");
		System.out.println(i4 + "\n");
	}
}
