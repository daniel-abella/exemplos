package exemplo2;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.icesoft.faces.component.selectinputtext.SelectInputText;

public class Lista {
	private List<SelectItem> dados = new ArrayList<SelectItem>();
	private List<SelectItem> selecionados = new ArrayList<SelectItem>();
	
	public Lista() {
		for (int i = 0; i < 10000; i++)
			dados.add(new SelectItem(Integer.toString(i), Integer.toString(i)));
	}
	
	public void atualize(ValueChangeEvent evento) {
		selecionados.clear();
		String texto = (String) evento.getNewValue();
		int maxElementos = ((SelectInputText) evento.getComponent()).getRows();
		
		int posicao = Integer.parseInt(texto);
		if (posicao < 0)
			return;
		
		for (int i = 0; i < maxElementos; i++) 
			selecionados.add(dados.get(posicao + i));
	}
	
	public List<SelectItem> getSelecionados() {
		return selecionados;
	}
}
