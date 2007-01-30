package progjava.lista;

public class Fila {
    private int nElementos = 0;
    private No primeiro = null;
    private No ultimo = null;
    
    private class No {
        Object valor;
        No prox;
        
        public void setValor(Object obj) {
            valor = obj;
        }
        
        public Object getValor() {
            return valor;
        }
        
        public No getProx() {
            return prox;
        }

        public void setProx(No prox) {
            this.prox = prox;
        }
    }
    
    public void adiciona(Object obj) {
        if (nElementos == 0) {
            primeiro = ultimo = new No();
        } else {
            ultimo.setProx(new No());
            ultimo = ultimo.getProx();           
        }
        ultimo.setValor(obj);
        nElementos++;
    }
    
    public Object remove() {
        Object retorno = null;
        
        if (nElementos > 0) {
            retorno = primeiro.getValor();
            primeiro = primeiro.getProx();
            nElementos--;
        }        
        return retorno;
    }

    public int tamanho() {
        return nElementos;
    }
}