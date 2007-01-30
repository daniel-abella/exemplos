package progjava.misc;

// Voc� pode contar, exaustivamente todas as possibilidades da
// megasena, conforme o programa abaixo (felizmente existem computadores)
// para trabalhos insalubres como este, ou ent�o calcular uma combina��o
// de 60 n�meros tomados em grupos de 6, sem repeti��es, claro. Algo como
// 60! dividido por 54! * 6!, que resulta em 50063860.

public class MegaSena {

    public static void main(String[] a) {
        byte n1 = 1;
        byte n2 = 0;
        byte n3 = 0;
        byte n4 = 0;
        byte n5 = 0;
        byte n6 = 0;
        int lotal = 0;
        int pares = 0;
        int impares = 0;

        long inicio = System.currentTimeMillis();

        while (n1 <= 60) {
            n2 = (byte) (n1 + (byte) 1);
            while (n2 <= 60) {
                n3 = (byte) (n2 + 1);
                while (n3 <= 60) {
                    n4 = (byte) (n3 + 1);
                    while (n4 <= 60) {
                        n5 = (byte) (n4 + 1);
                        while (n5 <= 60) {
                            n6 = (byte) (n5 + 1);
                            while (n6 <= 60) {
                                // Procurar um pattern no qual os numeros gerados neste ponto
                                // sao transferidos para um objeto que ira considerar ou
                                // nao o numero como "valido". Esta decisao devera ser baseada
                                // na resposta positiva de toda uma colecao de objetos cadas
                                // trados para tratar o numero.Talvez o chain of responsibility
                                // onde o ultimo objeto registra o jogo como valido. Se nao
                                // chegar no ultimo e porque o numero nao deve ser considerado.

                                lotal++;
                                if ((n6 % 2 + n5 % 2 + n4 % 2 + n3 % 2 + n2 % 2 + n1 % 2) == 0)
                                    pares++;
                                if (n6 % 2 != 0 && n5 % 2 != 0 && n4 % 2 != 0 && n3 % 2 != 0 &&
                                        n2 % 2 != 0 && n1 % 2 != 0) {
                                    impares++;
                                }
                                n6++;

                            }
                            n6 = 0;
                            n5++;
                        }
                        n5 = 0;
                        n4++;
                    }
                    n4 = 0;
                    n3++;
                }
                n3 = 0;
                n2++;
            }
            n2 = 0;
            n1++;
        }

        inicio = System.currentTimeMillis() - inicio;
        System.out.println("Time elapsed (seconds): " + (inicio/1000.0));
        System.out.println("Total de jogos: " + lotal);
        System.out.println("Total de todos (todos os n�meros pares): " + pares);
        System.out.println("Total de todos (todos os n�meros impares): " + impares);
    }
}
