package escola;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class InscricaoTest {
	private Aluno aluno;
	
	@Before
	public void setUp() {
		aluno = new Aluno();
		aluno.setNome("Pedro");
		
		Inscricao inscricao = null;
		Calendar data = Calendar.getInstance();
		
		String[] cursos = { "PS", "SAS", "ER", "Java", "Ajax" };
		for (int i = 0; i < 5; i++) {
			inscricao = new Inscricao();
			inscricao.setCurso(new Curso(cursos[i]));
			
			// Toda inscrição iniciou-se há dez meses
			// Termina nos meses subseqüentes (um após o outro)
			data.add(Calendar.MONTH, -5);
			inscricao.setDataInicio(data);
			data.add(Calendar.MONTH, 6 + i);
			inscricao.setDataFim(data);
			
			aluno.adicionaCurso(inscricao);
		}
	}
	
	@Test
	public void testPeriodo() {
		assertEquals(5, aluno.cursosEmAndamento().length);
		
		// Termina todos os cursos
		Calendar umMesAtras = Calendar.getInstance();
		umMesAtras.add(Calendar.MONTH, -1);
		
		Iterator<Inscricao> inscricao = aluno.inscricoes();
		while (inscricao.hasNext()) 
			inscricao.next().setDataFim(umMesAtras);
		
		assertEquals(0, aluno.cursosEmAndamento().length);
	}
}
