package p10;

import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {
	private Long id;
	private List<ItemNotaFiscal> itens = new ArrayList<ItemNotaFiscal>();
	
	private NotaFiscal() {}
	
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
}
