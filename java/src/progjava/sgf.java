package progjava;


/**
 * Servi�os t�picos de Gest�o Financeira (SGF)
 * Conjunto de rotinas que realizam tarefas de valida��o de c�digos,
 * por exemplo, CPF/CNPJ, inscri��es estaduais e outras.
 */
public class sgf {
   private boolean error;

   public sgf() {
      error = false;
   }

   public boolean getError() {
      return error;
   }

   /**
    * Retorna true se e somente se a string fornecida representa
    * um CPF v�lido. Um CPF � v�lido se a string cont�m necessariamente
    * 11 d�gitos (cada um deles de 0 a 9) e atende o algoritmo definido
    * para valida��o dos d�gitos verificadores.
    */

   public boolean cpf2 (String num)
   {
      int j, k; /* d�gitos j e k */
      int s, p; /* soma e parcela */

      if (num.length() != 11)
         return false;

      /* CPF � uma seq��ncia abc.def.ghi-jk onde j e k s�o os d�gitos
         verificadores
      */
      s = 0;
      p = 0;
      p = p + num.charAt(8);  /* i */
      s = s + p;              /* i */

      p = p + num.charAt(7); /* h+i */
      s = s + p;             /* h+2i */

      p = p + num.charAt(6); /* g+h+i */
      s = s + p;             /* g+2h+3i */

      p = p + num.charAt(5); /* f+g+h+i */
      s = s + p;             /* f+2g+3h+4i */

      p = p + num.charAt(4); /* e+f+g+h+i */
      s = s + p;             /* e+2f+3g+4h+5i */

      p = p + num.charAt(3); /* d+e+f+g+h+i */
      s = s + p;             /* d+2e+3f+4g+5h+6i */

      p = p + num.charAt(2); /* c+d+e+f+g+h+i */
      s = s + p;             /* c+2d+3e+4f+5g+6h+7i */

      p = p + num.charAt(1); /* b+c+d+e+f+g+h+i */
      s = s + p;             /* b+2c+3d+4e+5f+6g+7h+8i */

      k = s;                 /* b+2c+3d+4e+5f+6g+7h+8i */

      p = p + num.charAt(0); /* a+b+c+d+e+f+g+h+i */
      s = s + p;             /* a+2b+3c+4d+5e+6f+7g+8h+9i */

      /* Foram usados os valores de 48 para o caractere '0',  */
      /* 49 para '1' e assim por diante (ISO-Latin)           */
      /* A subtra��o abaixo efetua a corre��o. Esta op��o �   */
      /* mais eficiente que a convers�o de cada caractere     */
      s = s - 2160;

      j = s % 11;
      if (j == 10)
         j = 0;

      /* Observe que k tamb�m deve sofrer um corre��o (veja acima) */
      k = ((k-1728) + j*9) % 11;
      if (k == 10)
         k = 0;

      if ((num.charAt(9)-48 == j) && (num.charAt(10)-48 == k))
         return true;

      return false;
   }

   public boolean cpf3 (String num)
   {
      int j, k; /* d�gitos j e k */
      int s, p; /* soma e parcela */

      if (num.length() != 11)
         return false;

      /* CPF � uma seq��ncia abc.def.ghi-jk onde j e k s�o os d�gitos
         verificadores
      */

      s = 0;
      p = 0;
      int c = 9;
      while ( --c > -1 )
      {
         p = p + num.charAt(c);
         s = s + p;
      }
      /* p = a+b+c+d+e+f+g+h+1 */
      /* s = a+2b+3c+4d+5e+6f+7g+8h+9i */

      /* Foram usados os valores de 48 para o caractere '0',  */
      /* 49 para '1' e assim por diante (ISO-Latin)           */
      /* A subtra��o abaixo efetua a corre��o. Esta op��o �   */
      /* mais eficiente que a convers�o de cada caractere     */
      s = s - 2160;

      j = s % 11;
      if (j == 10)
         j = 0;

      /* Os par�nteses mais internos englobam s - p     */
      /* Agora, s - p ==> s - (p - 432) ==> s - p + 432 */
      k = ((s - p + 432) + j*9) % 11;
      if (k == 10)
         k = 0;

      if ((num.charAt(9)-48 == j) && (num.charAt(10)-48 == k))
         return true;

      return false;
   }

   public boolean cpf (String num)
   {
      int j, k; /* d�gitos j e k */
      int s, p; /* soma e parcela */

      if (num.length() != 11)
         return false;

      /* Foram usados os valores de 48 para o caractere '0',  */
      /* 49 para '1' e assim por diante (ISO-Latin)           */
      /* A subtra��o abaixo efetua a corre��o. Esta op��o �   */
      /* mais eficiente que a convers�o de cada caractere     */
      /* O ajuste pode ser feito antes, economizando uma atribui��o */
      s = -2160;

      p = 0;
      /* Ao contr�rio da vers�o anterior, pode-se usar j ou k */
      j = 9;
      while ( --j > -1 )
      {
         p = p + num.charAt(j);
         s = s + p;
      }
      /* p = a+b+c+d+e+f+g+h+1 */
      /* s = a+2b+3c+4d+5e+6f+7g+8h+9i */

      j = s % 11;
      if (j == 10)
         j = 0;

      /* Os par�nteses mais internos englobam s - p     */
      /* Agora, s - p ==> s - (p - 432) ==> s - p + 432 */
      k = ((s - p + 432) + j*9) % 11;
      if (k == 10)
         k = 0;

      /* Nao � dif�cil provar que a-k=x e b-k=y se e somente se a-b=x-y */
      if ((num.charAt(9) - num.charAt(10)) == (j - k))
         return true;

      return false;
   }
}