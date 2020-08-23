package lanches;

import java.util.ArrayList;

public abstract class Lanche {
	private double preco;

	public Lanche(double preco) {
		this.setPreco(preco);
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public abstract ArrayList<String> getIngredients();

}
