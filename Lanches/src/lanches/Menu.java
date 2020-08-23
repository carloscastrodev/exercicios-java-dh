package lanches;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static void run() {
		Cardapio cardapio = new Cardapio();
		Lanche lanche = null;
		Boolean done = false;
		System.out.println("***DIGITE SEMPRE O NÚMERO REFERENTE A OPÇÃO ESCOLHIDA***");
		System.out.println("***DIGITE 0 PARA CANCELAR O PEDIDO***\n");
		System.out.println("Escolha um tipo de lanche: ");
		System.out.println("[1] Sanduiche  |  [2] Massa  |  [3] Bolo");
		Scanner input = new Scanner(System.in);

		while (!done) {
			Integer escolhaTipo = Integer.parseInt(input.nextLine());

			if (escolhaTipo == 1) {
				System.out.println("Você escolheu sanduíche.");
				System.out.println("Escolha até 10 ingredientes. Digite 0 para finalizar o pedido.");
				List<String> ingredientes = new ArrayList<String>();
				cardapio.mostraIngredientesSanduiche();

				while (true) {
					if (ingredientes.size() >= 10) {
						System.out.println("\n10 ingredientes foram selecionados. Finalizando pedido.\n");
						break;
					}

					Integer escolhaIngrediente = Integer.parseInt(input.nextLine());

					if (escolhaIngrediente == 0) {
						System.out.println("\nFinalizando pedido!\n");
						break;
					}

					if (escolhaIngrediente > cardapio.nEscolhasSanduiche() - 1) {
						System.out.println("\nESCOLHA INVÁLIDA\n");
					} else {
						System.out.println(
						        "Você escolheu adicionar " + cardapio.getIngredienteSanduiche(escolhaIngrediente));
						ingredientes.add(cardapio.getIngredienteSanduiche(escolhaIngrediente));
					}
				}

				lanche = new Sanduiche(3.50, ingredientes);
				done = true;

			} else if (escolhaTipo == 2) {

				System.out.println("Você escolheu massa.");
				System.out.println("Escolha um molho para sua massa.");
				cardapio.mostraMolhosMassa();
				String molho;

				while (true) {
					Integer escolhaIngrediente = Integer.parseInt(input.nextLine());

					if (escolhaIngrediente > cardapio.nEscolhasMolho() - 1) {
						System.out.println("\nESCOLHA INVÁLIDA\n");
					} else {
						System.out.println("Você escolheu adicionar " + cardapio.getMolhoMassa(escolhaIngrediente));
						molho = cardapio.getMolhoMassa(escolhaIngrediente);
						break;
					}
				}

				lanche = new Massa(5, molho);
				done = true;

			} else if (escolhaTipo == 3) {

				System.out.println("Você escolheu bolo.");

				String massa;
				String recheio;
				String cobertura;
				System.out.println("Escolha o tipo de massa do bolo.");
				cardapio.mostraMassasBolo();
				while (true) {
					Integer escolhaIngrediente = Integer.parseInt(input.nextLine());

					if (escolhaIngrediente > cardapio.nEscolhasMassa() - 1) {
						System.out.println("\nESCOLHA INVÁLIDA\n");
					} else {
						System.out.println("Você escolheu adicionar " + cardapio.getMassaBolo(escolhaIngrediente));
						massa = cardapio.getMassaBolo(escolhaIngrediente);
						break;
					}
				}

				System.out.println("Escolha o recheio do bolo.");
				cardapio.mostraRecheiosBolo();
				while (true) {
					Integer escolhaIngrediente = Integer.parseInt(input.nextLine());

					if (escolhaIngrediente > cardapio.nEscolhasRecheio() - 1) {
						System.out.println("\nESCOLHA INVÁLIDA\n");
					} else {
						System.out.println("Você escolheu adicionar " + cardapio.getRecheioBolo(escolhaIngrediente));
						recheio = cardapio.getRecheioBolo(escolhaIngrediente);
						break;
					}
				}

				System.out.println("Escolha a cobertura do bolo.");
				cardapio.mostraCoberturasBolo();
				while (true) {
					Integer escolhaIngrediente = Integer.parseInt(input.nextLine());

					if (escolhaIngrediente > cardapio.nEscolhasCobertura() - 1) {
						System.out.println("\nESCOLHA INVÁLIDA\n");
					} else {
						System.out.println("Você escolheu adicionar " + cardapio.getCoberturaBolo(escolhaIngrediente));
						cobertura = cardapio.getCoberturaBolo(escolhaIngrediente);
						break;
					}
				}

				lanche = new Bolo(10, massa, recheio, cobertura);
				done = true;

			} else if (escolhaTipo == 0) {

				System.out.println("Você escolheu cancelar o pedido.");
				break;

			} else {
				System.out.println("Escolha uma opção válida.");
			}
		}

		if (done) {

			System.out.println("\nDigite a distância em KM até sua localização");
			float dist = Float.parseFloat(input.nextLine());
			cardapio.realizaPedido(lanche, dist);
		}
		input.close();

	}
}
