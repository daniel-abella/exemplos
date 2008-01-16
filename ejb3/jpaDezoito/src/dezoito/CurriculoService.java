package dezoito;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CurriculoService {
	public static Curriculo newCurriculo(String fotoFile, String textoFile) {
		File arquivo = new File(fotoFile);
		byte[] ramFoto = new byte[(int) arquivo.length()];
		try {	
			FileInputStream fis = new FileInputStream(arquivo);
			byte[] buffer = new byte[1024 * 4];
			int bytesLidos = -1;
			int inicio = 0;
			while ((bytesLidos = fis.read(buffer)) != -1) {
				System.arraycopy(buffer, 0, ramFoto, inicio, bytesLidos);
				inicio += bytesLidos;
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return new Curriculo(ramFoto,"");
	}
	
	public static void criaCopiaCurriculo(Curriculo curriculo, String fotoFile, String textoFile) {
		try {			
			FileOutputStream fos = new FileOutputStream(fotoFile);
			fos.write(curriculo.getFoto());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Pequen experimentação
	public static void main(String[] args) {
		Curriculo curriculo = CurriculoService.newCurriculo("wp1.jpg", "texto.txt");
		CurriculoService.criaCopiaCurriculo(curriculo, "wp2.jpg", "");
	}
}
