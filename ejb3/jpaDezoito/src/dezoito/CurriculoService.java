package dezoito;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CurriculoService {
	public static Curriculo newCurriculo(String fotoFile, String textoFile) {
		byte[] foto = carregaArquivo(fotoFile);
		byte[] texto = carregaArquivo(textoFile);
		return new Curriculo(foto, new String(texto));
	}

	public static byte[] carregaArquivo(String nomeArquivo) {
		File arquivo = new File(nomeArquivo);
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
		return ramFoto;
	}

	public static void salvarCurriculoEm(Curriculo curriculo, String fotoFile,
			String textoFile) {
		criarArquivo(fotoFile, curriculo.getFoto());
		criarArquivo(textoFile, curriculo.getDeclaracao().getBytes());
	}

	public static void criarArquivo(String arquivoNome, byte[] bytes) {
		try {
			FileOutputStream fos = new FileOutputStream(arquivoNome);
			fos.write(bytes);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Pequen experimentação
	public static void main(String[] args) {
		Curriculo curriculo = CurriculoService.newCurriculo(
				"kyrios-wallpaper.jpg", "robinson-crusoe.txt");
		CurriculoService.salvarCurriculoEm(curriculo, "foto.jpg", "texto.txt");
	}
}
