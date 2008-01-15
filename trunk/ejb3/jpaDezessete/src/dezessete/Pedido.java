package dezessete;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pedido {
	@Id
	@GeneratedValue
	private long id;
	
	@Enumerated(EnumType.ORDINAL)
	private EstadoPedido estado;
	
	@Enumerated(EnumType.STRING)
	private EstadoPedido estadoInicial;
	
	public Pedido() {}
	
	public Pedido(EstadoPedido corrente, EstadoPedido inicial) {
		estado = corrente;
		estadoInicial = inicial;
	}
}
