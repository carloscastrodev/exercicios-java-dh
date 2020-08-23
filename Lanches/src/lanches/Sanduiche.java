package lanches;

import java.util.ArrayList;
import java.util.List;

public class Sanduiche extends Lanche {
	private List<String> ingredientes;

	public Sanduiche(double preco, List<String> ingredientes) {
		super(preco);
		this.setIngredientes(ingredientes);
	}

	public List<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<String> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public ArrayList<String> getIngredients() {
		return (ArrayList<String>) ingredientes;
	}
}
