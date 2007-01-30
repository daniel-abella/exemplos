package progjava.es;

import java.util.StringTokenizer;

public class Partido {
    private String nome;
    private String sigla;
   
   public String getSigla() {
        return sigla;
    }

    public void setSigla(String idade) {
        this.sigla = idade;
    }
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Partido copia() {
        Partido novoP = new Partido();
        novoP.setNome(nome);
        novoP.setSigla(sigla);
        return novoP;
    }
    
    public Partido() {
        this("Nao fornecido, Nao fornecido");
    }
    
    public Partido(String csv) {
        StringTokenizer tkns = new StringTokenizer(csv,",");
        sigla = tkns.nextToken();
        nome = tkns.nextToken();
    }
    
    public String toString() {
        return nome + " (" + sigla + ")";
    }
}