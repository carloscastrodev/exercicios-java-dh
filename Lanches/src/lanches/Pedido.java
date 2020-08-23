package lanches;

public class Pedido {
	private Lanche lanche;

	public Pedido(Lanche lanche) {
		this.lanche = lanche;
	}

	public String getNomeLanche() {
		return lanche.getClass().getCanonicalName();
	}

	public void setLanche(Lanche lanche) {
		this.lanche = lanche;
	}

	public void fechaPedido(double distancia) {
		double preco;
		int tempoPreparo;
		if (this.lanche instanceof Sanduiche) {
			preco = lanche.getPreco() + this.lanche.getIngredients().size() * 2;
			tempoPreparo = 15;
		} else if (this.lanche instanceof Bolo) {
			preco = lanche.getPreco() + this.lanche.getIngredients().size() * 4;
			tempoPreparo = 10;
		} else if (this.lanche instanceof Massa) {
			preco = lanche.getPreco() + this.lanche.getIngredients().size() * 5;
			tempoPreparo = 30;
		} else {
			System.out.println("Não oferecemos esse tipo de lanche");
			return;
		}

		System.out.println("Você comprou " + lanche.getClass().getSimpleName() + " com os seguintes ingredientes: ");
		for (String ingrediente : this.lanche.getIngredients()) {
			System.out.println(ingrediente);
		}
		System.out.println("O preço total é de R$" + preco);
		Double tempoEntrega = tempoPreparo + distancia * 10;
		System.out.println("Tempo aproximado para entrega: " + tempoEntrega.intValue() + " minutos.");

	}
}
