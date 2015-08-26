### Onde obter ###
http://exemplos.googlecode.com/svn/trunk/ejb3/jpaDezoito/

Exemplos ([série](http://code.google.com/p/exemplos/wiki/ejbPersistence)): [ANTERIOR](http://code.google.com/p/exemplos/wiki/jpaDezessete) e [PRÓXIMO](http://code.google.com/p/exemplos/wiki/jpaDezenove).

# Introdução #
Uma figura ou arquivo de músico é persistido em um SGBD por meio do tipo BLOB (_Binary Large OBject_). Um texto longo também possui suporte por meio do tipo CLOB (_Character Large OBject_). Para ilustrar, foi criada a classe Curriculo, contendo como atributos uma foto e um texto longo, referente a alguma declaração geral do indivíduo caracterizado no currículo. A classe correspondente segue abaixo.

A foto emprega o tipo **byte[.md](.md)**, enquanto o texto longo é **char[.md](.md)**. Este último também poderia ser representado pelo tipo **String**. Há apenas uma anotação para ambos os casos: **@Lob**. O tipo do atributo em questão será empregado para designar qual o correspondente tipo do SGBD será empregado, se um BLOB ou CLOB.

```
package dezoito;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Curriculo {
	@Id
	@GeneratedValue
	private long id;
	
	@Lob
	private byte[] foto;
	
	@Lob
	private char[] declaracao;
	
	public Curriculo() {}
	
	public Curriculo(byte[] foto, String declaracao) {
		this.foto = foto;
		this.declaracao = declaracao.toCharArray();
	}
	
	public String getDeclaracao() {
		return new String(declaracao);
	}
	
	public byte[] getFoto() {
		return foto;
	}
}
```

Para criar uma instância de Curriculo e, em sentido inverso, obter dados de um currículo de tal forma que possa ser verificado que uma instância foi adequadamente criada, segue abaixo a classe CurriculoService. Esta classe oferece serviços para obter tanto a foto quanto o texto de um arquivo. Também permite persistir o conteúdo de uma instância de Curriculo por meio de dois arquivos, um especificado para guardar a foto e outro para guardar o texto (declaração). Será mais fácil compreender as aplicações e, posteriormente, investigar detalhes técnicos da classe abaixo.

```
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
```

Para a experimentação estão disponíveis dois arquivos: kyrios-wallpaper.jpg (foto) e robinson-crusoe.txt (texto). Este último é uma contribuição do Projeto Gutemberg e pode ser obtido gratuitamente em http://www.gutenberg.org/etext/521.

A aplicação abaixo cria uma instância de Curriculo onde a foto e o texto são obtidos, respectivamente, destes dois arquivos.

```
package dezoito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersisteCurriculoAplicacao {
	public static void main(String[] args) {
		persisteCurriculo("kyrios-wallpaper.jpg", "robinson-crusoe.txt");
	}

	public static void persisteCurriculo(String foto, String texto) {
		Curriculo curriculo = CurriculoService.newCurriculo(foto, texto);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDezoito");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(curriculo);

		tx.commit();
		em.close();
	}
}
```

Após persistida a instância, pode-se verificar com a execução do programa abaixo. Que assume que o programa acima foi executado satisfatoriamente. No programa abaixo é recuperada a instância persistida no programa acima e o conteúdo dos atributos foto e texto dão origem a dois arquivos: outro.jpg e outro.txt, respectivamente. Desta forma, pode-se verificar que a criação da instância, a posterior persistência no SGBD, a recuperação dela e a criação de outros arquivos correspondentes aos primeiros, foram executados de forma satisfatória.

```
package dezoito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ObtemCurriculoAplicacao {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDezoito");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// Supõe a existência de instância com id de valor 1
		Curriculo curriculo = (Curriculo) em.find(Curriculo.class, 1L);

		tx.commit();
		em.close();
		
		CurriculoService.salvarCurriculoEm(curriculo, "outro.jpg", "outro.txt");
	}
}
```