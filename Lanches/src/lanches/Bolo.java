package lanches;

import java.util.ArrayList;
import java.util.Arrays;

public class Bolo extends Lanche {
	private String massa;
	private String recheio;
	private String cobertura;

	public Bolo(float preco, String massa, String recheio, String cobertura) {
		super(preco);
		this.massa = massa;
		this.recheio = recheio;
		this.cobertura = cobertura;
	}

	public String getMassa() {
		return massa;
	}

	public void setMassa(String massa) {
		this.massa = massa;
	}

	public String getRecheio() {
		return recheio;
	}

	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	@Override
	public ArrayList<String> getIngredients() {
		return new ArrayList<String>(Arrays.asList(massa, recheio, cobertura));
	}

}
