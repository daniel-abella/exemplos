package p07;

import java.util.Arrays;

public class MegaSena {
	private Long id;
	private short jogo;
	private byte[] dezenas;
	
	public String toString() {
		return jogo + " " + Arrays.toString(dezenas);
	}
	
	public byte[] getDezenas() {
		return dezenas;
	}
	public void setDezenas(byte[] dezenas) {
		this.dezenas = dezenas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public short getJogo() {
		return jogo;
	}
	public void setJogo(short jogo) {
		this.jogo = jogo;
	}
}
