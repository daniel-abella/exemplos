package p04;

public class AtualizaPessoa {
	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setNome("Pedro Cabral");
		p.setCasado(true);  
		
		// Até aqui: p é transiente
		// Persistida, mas desconectada em seguida
		HibernateUtils.persiste(p);
		
		// Exibe conteúdo da instância persistida
		System.out.println(p);
		
		// p encontra-se desconectada (detached)
		// Nenhuma ligação entre a base e p
		p.setCasado(false);
		
		HibernateUtils.startTransaction();
		// update (ou lock) torna instância persistente
		// Qualquer alteração em p é agendada pelo comando abaixo
		HibernateUtils.getSession().update(p); 
		
		// Outra operação agendada 
		// (só o commit força atualização da base de dados)
		p.setSexo('M');                        
		
		HibernateUtils.commitTransaction(); // Atualizações		
		
		System.out.println(HibernateUtils.obtem(Pessoa.class, p.getId()));
	}
}
