package lanches;

import java.util.ArrayList;
import java.util.Arrays;

public class Massa extends Lanche {
	private String molho;

	public Massa(float preco, String molho) {
		super(preco);
		this.molho = molho;
	}

	public String getMolho() {
		return molho;
	}

	public void setMolho(String molho) {
		this.molho = molho;
	}

	@Override
	public ArrayList<String> getIngredients() {
		return new ArrayList<String>(Arrays.asList(molho));
	}
}
