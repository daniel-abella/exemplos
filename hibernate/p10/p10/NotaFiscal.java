package p10;

import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {
	private Long id;

	private List<ItemNotaFiscal> itens = new ArrayList<ItemNotaFiscal>();

	private NotaFiscal() {
	}

	public NotaFiscal(ItemNotaFiscal item) {
		itens.add(item);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemNotaFiscal> getItens() {
		return itens;
	}

	public void setItens(List<ItemNotaFiscal> itens) {
		this.itens = itens;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		String divisoria = "\n------------------------";
		sb.append(divisoria).append("\nITEM   QUANT DESCRIÇÃO");
		int i = 0;
		for (ItemNotaFiscal inf : itens)
			sb.append(String.format("\n%4d: %6d %-15s", ++i, inf
					.getQuantidade(), inf.getProduto().getNome()));
		sb.append(divisoria).append("\nTotal de itens: " + itens.size());
		return sb.toString();
	}
}
