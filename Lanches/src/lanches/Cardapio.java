package lanches;

import java.util.ArrayList;
import java.util.Arrays;

public class Cardapio {
	private Pedido pedido;
	private ArrayList<String> massasBolo = new ArrayList<String>(
	        Arrays.asList("Pão-de-ló", "Genoise", "Amanteigada", "Chiffon"));

	private ArrayList<String> recheiosBolo = new ArrayList<String>(Arrays.asList("Leite ninho", "Nutella",
	        "Chocolate aerado", "Chocolate branco", "Oreo", "Doce de leite", "Morango", "Abacaxi"));

	private ArrayList<String> coberturasBolo = new ArrayList<String>(Arrays.asList("Pasta americana", "Merengue",
	        "Chantili", "Ganache", "Glacê real", "Brigadeiro", "Buttercream", "Fondant"));

	private ArrayList<String> molhosMassa = new ArrayList<String>(Arrays.asList("Molho de atum", "Molho de tomate",
	        "Molho de queijo", "Molho bolonhesa", "Molho de frango cremoso", "Molho de gorgonzola",
	        "Molho de provolone", "Molho cremoso de legumes", "Molho de lentilhas", "Molho de beterraba"));

	private ArrayList<String> ingredientesSanduiche = new ArrayList<String>(Arrays.asList("Tomate", "Bacon",
	        "Hamburguer Artesanal", "Hamburguer de frango", "Hamburguer tradicional", "Alface", "Purê de batatas",
	        "Salsicha", "Ovo", "Batata palha", "Abacaxi", "Banana", "Cebola roxa", "Azeitona", "Maionese",
	        "Molho barbecue", "Ketchup", "Maionese temperada", "Mostarda", "Ervilha", "Milho"));

	public void realizaPedido(Lanche lanche, float distancia) {
		this.pedido = new Pedido(lanche);
		this.pedido.fechaPedido(distancia);
	}

	private void mostraIngredientes(ArrayList<String> ingredientes) {
		for (int i = 1; i <= ingredientes.size(); i++) {
			System.out.println(i + ". " + ingredientes.get(i - 1));
		}
	}

	public String getIngredienteSanduiche(int i) {
		return ingredientesSanduiche.get(i - 1);
	}

	public String getMolhoMassa(int i) {
		return molhosMassa.get(i - 1);
	}

	public String getRecheioBolo(int i) {
		return recheiosBolo.get(i - 1);
	}

	public String getCoberturaBolo(int i) {
		return coberturasBolo.get(i - 1);
	}

	public String getMassaBolo(int i) {
		return massasBolo.get(i - 1);
	}

	public void mostraMassasBolo() {
		mostraIngredientes(massasBolo);
	}

	public void mostraRecheiosBolo() {
		mostraIngredientes(recheiosBolo);
	}

	public void mostraCoberturasBolo() {
		mostraIngredientes(coberturasBolo);
	}

	public void mostraMolhosMassa() {
		mostraIngredientes(molhosMassa);
	}

	public void mostraIngredientesSanduiche() {
		mostraIngredientes(ingredientesSanduiche);
	}

	public int nEscolhasSanduiche() {
		return ingredientesSanduiche.size();
	}

	public int nEscolhasMolho() {
		return molhosMassa.size();
	}

	public int nEscolhasMassa() {
		return massasBolo.size();
	}

	public int nEscolhasCobertura() {
		return coberturasBolo.size();
	}

	public int nEscolhasRecheio() {
		return recheiosBolo.size();
	}
}
