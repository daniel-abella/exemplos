package trabalho;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class QueryAplicacao {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("trabalho");
		EntityManager em = emf.createEntityManager();

		List todaColuna = em.createNamedQuery("obterColunaNumero").getResultList();                                                   
		System.out.println("tudo de uma coluna: \n"+ todaColuna.toString());

		
		//imprime tudo
		List obtemall = em.createNamedQuery("obtemTudo").getResultList();   
		System.out.println("tudo: \n"+ obtemall.toString());

		//imprime o registro de determinado nome
		List obtemNomeAluno = em.createNamedQuery("obterNome").setParameter("nomep", "Aluno 2").getResultList(); 
		
		
		List cursoPorAluno = em.createNamedQuery("obtemCursosAluno").setParameter("matriculaaluno", (long)5).getResultList();
		System.out.println("o aluno de matricula 5 esta matriculado nos cursos: ");
		Iterator i2 = cursoPorAluno.iterator();   
		while (i2.hasNext()) {   
		  System.out.println(((Curso)i2.next()).getCodigo());   
		}  

		List alunosPorCurso = em.createNamedQuery("obtemAlunosCurso").setParameter("codigocurso", 5).getResultList();   
		System.out.println("Alunos matriculados no curso com codigo = 5: \n"+ alunosPorCurso.toString());

		List matriculaPorAluno = em.createNamedQuery("obtemAlunosMatricula").setParameter("matriculaaluno", (long)5).getResultList();   
		System.out.println("Aluno com matricula = 5: \n"+ matriculaPorAluno.toString());

		List matriculaEspecifica = em.createNamedQuery("obtemAlunosMatriculasEspecificas").getResultList();   
		System.out.println("Aluno com matriculas especificas: \n"+ matriculaEspecifica.toString());

		List matriculaEspecificaBetween = em.createNamedQuery("obtemAlunosMatriculasBetween").getResultList();   
		System.out.println("Aluno com matriculas especificas: \n"+ matriculaEspecificaBetween.toString());

		List obtemAlunos5 = em.createNamedQuery("obtemAlunosTermina5").getResultList();   
		System.out.println("Nome de aluno que termina com um caractere seguido de \"5\": \n"+ obtemAlunos5.toString());

		List obtemAlunosConjunto = em.createNamedQuery("obtemAlunosDeConjunto").getResultList();   
		System.out.println("Nome de alunos que pertencem ao conjunto: \n"+ obtemAlunosConjunto.toString());

		List obtemAlunosVaziosNulos = em.createNamedQuery("obtemAlunosNomesVaziosOuNulos").getResultList();   
		System.out.println("Nome de alunos com nome vazio ou null: \n"+ obtemAlunosVaziosNulos.toString());

		List obtemMatriculaMenos5 = em.createNamedQuery("obtemMatriculaMenos5").getResultList();   
		System.out.println("todos os alunos com matricula diferente de 5: \n"+ obtemMatriculaMenos5.toString());

		List obtemCONCAT = em.createNamedQuery("obtemCONCAT").getResultList();   
		System.out.println("obtem Aluno 5 com o CONCAT:\n"+ obtemCONCAT.toString());

		List obtemSubs = em.createNamedQuery("obtemSUBSTRING").getResultList();   
		System.out.println("obtem Substring:\n"+ obtemSubs.toString());

		List obtemTrim = em.createNamedQuery("obtemTRIMBOTH").getResultList();   
		System.out.println("obtem Trim e Both :\n"+ obtemTrim.toString());

		List obtemLower = em.createNamedQuery("obtemLOWER").getResultList();   
		System.out.println("obtem usando Lower:\n"+ obtemLower.toString());
		
		List obtemUpper = em.createNamedQuery("obtemUPPER").getResultList();   
		System.out.println("obtem usando Upper:\n"+ obtemUpper.toString());
		
		List obtemLength = em.createNamedQuery("obtemLENGTH").getResultList();   
		System.out.println("obtem Tamanho (Length):\n"+ obtemLength.toString());
		
		List obtemLocate = em.createNamedQuery("obtemLOCATE").getResultList();   
		System.out.println("obtem Locate :\n"+ obtemLocate.toString());
		

		List obtemAbs = em.createNamedQuery("obtemABS").getResultList();   
		System.out.println("obtem ABS :\n"+ obtemAbs.toString());
		

		List obtemSQRT = em.createNamedQuery("obtemSQRT").getResultList();   
		System.out.println("obtem SQRT:\n"+ obtemSQRT.toString());
		

		List obtemMod = em.createNamedQuery("obtemMOD").getResultList();   
		System.out.println("obtem MOD:\n"+ obtemMod.toString());
		

//		List obtemUpdate = em.createNamedQuery("obtemUPDATE").getResultList();   
//		System.out.println("obtem UPDATE:\n"+ obtemUpdate.toString());
		
//		List obtemDelete = em.createNamedQuery("obtemDELETE").getResultList();   
//		System.out.println("obtem DELETE:\n"+ obtemDelete.toString());
		
		
		List obtemOrder = em.createNamedQuery("obtemOrder").getResultList();   
		System.out.println("obtem order:\n"+ obtemOrder.toString());

		List obtemAvg = em.createNamedQuery("obtemAvg").getResultList();   
		System.out.println("obtem avg:\n"+ obtemAvg.toString());
		
		List obtemCount = em.createNamedQuery("obtemCount").getResultList();   
		System.out.println("obtem count:\n"+ obtemCount.toString());
		
		List obtemMin = em.createNamedQuery("obtemMin").getResultList();   
		System.out.println("obtem min:\n"+ obtemMin.toString());
		
		List obtemMax = em.createNamedQuery("obtemMax").getResultList();   
		System.out.println("obtem max:\n"+ obtemMax.toString());

		List alunoPorMatricula = em.createNamedQuery("obtemMatriculaAluno").setParameter("alunomatricula", "Aluno 5").getResultList();
		System.out.println("O Aluno 5 tem matricula (caso haja mais de uma matricula, mais de um aluno tem o mesmo nome): \n");
		Iterator i = alunoPorMatricula.iterator(); //cria um objeto Iterator da sua LinkedList  
		while (i.hasNext()) { //percorrer toda a lista até o ultimo elemento  
		  System.out.println(((Aluno)i.next()).getMatricula()); //Mostra o valor da Lista  
		}  
		


		em.close();
	}
}
