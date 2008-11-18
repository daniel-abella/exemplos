package br.ufg.inf.junit;

import java.util.List;

/**
 * Oferece serviços para a manipulação do formato CSV. Detalhes sobre este
 * formato podem ser obtidas em <a
 * href="http://pt.wikipedia.org/wiki/Comma-separated_values">CSV</a>. Uma
 * linha ou registro neste formato: <b>1,teste,-5</b>.
 * Neste caso, três campos foram separados por vírgula (separador padrão). Outros
 * separadores também podem ser empregados ({@link #defineSeparador(char)}).
 * Quando o conteúdo de um campo incluir o separador, então o campo deverá ser
 * fornecido entre aspas duplas. Por exemplo, abaixo "Silva, João" é um único
 * campo.
 * <p>
 * <b>1,"Silva, João",teste,10</b>
 * 
 * <p>
 * No exemplo acima são fornecidos quatro (4) campos, todos separados por
 * vírgula (separador padrão). Ainda convém destacar que não há espaço em branco
 * após o separador. Neste exemplo o segundo campo está entre
 * aspas duplas, o que permite empregar o separador (,) como parte do
 * conteúdo do campo.
 *
 * <p>Uma dificuldade adicional surge se o campo fizer uso
 * de aspas duplas e do separador. Neste caso,
 * além de delimitar o campo com as aspas <i>externas</i>,
 * para cada aspas duplas contida no conteúdo do campo será acrescentado 
 * o caractere
 * '\' imediatamente antes da ocorrência da aspas dupla. Por exemplo, se um campo tem como valor <b>caractere: " (aspas)</b> e
 * o separador é definido como <b>:</b>, então terá que ser reescrito como
 * <b>"caractere: \" (aspas)"</b>. Observe que, desta forma, ao executar o
 * processo inverso, ou seja, retirar as aspas <i>externas</i> e retirar o
 * caractere '\' inserido para cada aspas do conteúdo do campo,
 * teremos como resultado o conteúdo original.
 * 
 * @author Fábio Nogueira de Lucena
 * @version 0.3
 * 
 */
public interface CsvService {

    /**
     * Define separador empregado para demarcar campos de uma linha no formato
     * CSV. O argumento fornecido será utilizado como separador até
     * que uma nova chamada a este método altere para um outro separador. O
     * valor padrão é ',' (vírgula), ou seja, caso este método não seja
     * explicitamente chamado, o separador empregado será ','.
     *
     * @param separador
     *            Demarca a separação entre campos de uma String no formato CSV.
     *            <b>Importante:</b> quando um campo é fornecido entre aspas
     *            duplas, a ocorrência do separador no campo não irá demarcar
     *            separação de campos.
     */
    public void defineSeparador(char separador);

    /**
     * Monta String no formato CSV cujos campos são fornecidos como argumento.
     * Para separar os campos será empregado o separador padrão (vírgula) ou
     * aquele definido pelo metodo {@link #defineSeparador(char)}. Cabe a este
     * método detectar se o campo fornecido contém o separador empregado e,
     * neste caso, delimitar o campo com aspas duplas. Adicionalmente, neste
     * caso, o campo deverá ser investigado para detectar a ocorrência de
     * aspas duplas no próprio conteúdo do campo. Se este for o caso, então
     * para cada aspas duplas deverá ser acrescentado imediatamente antes da
     * ocorrência desta o caractere '\'.
     *
     * @param lista
     *            Lista de objetos que deverão dar origem à String no formato
     *            CSV. Os valores dos campos seguirão na mesma ordem em que
     *            estão presentes na lista.
     * @return String CSV contendo os objetos fornecidos na lista separados pelo
     *         separador definido. Se a linha não possui nenhum objeto, então o
     *         retorno deve ser "". Se o objeto contido na lista for
     * <code>null</code>, então a seqüência de caracteres a ser empregada
     * como representante do campo em questão deve ser "null" (sem as aspas).
     * Ao obter a seqüência de caracteres correspondente a cada um dos campos,
     * por meio da mensagem <i>toString()</i>, se o retorno deste método for
     * a referência null, então a String a ser empregada será "null" (sem as
     * aspas). 
     * @throws IllegalArgumentException
     *             Se o argumento fornecido (referência) fornecida
     * for <code>null</code>. Se a mensagem {@link Object#toString()}, a ser
     * enviada para cada objeto da lista para a identificação da seqüência
     * de caracteres correspondente gerar uma exceção, então
     * {@link IllegalArgumentException} também deverá ser gerada.
     */
    public String toCsv(List<Object> lista);

    /**
     * Obtém campos de uma String no formato CSV. Cada um dos campos
     * fornecidos pela String é identificado e passa a compor a lista retornada
     * na ordem em que aparece na String. Observe que mesmo que um campo contenha o
     * separador, este não será delimitado entre aspas. Ou seja, cada campo
     * identificado só conterá aspas se este fizer parte do conteúdo do
     * campo. Os campos são delimitados na String pelo separador padrão (vírgula)
     * ou por outro caractere definido por {@link #defineSeparador(char)}.
     *
     * @param csv
     *            Linha no formato CSV.
     * @return Lista de Strings correspondentes aos campos, na ordem em que
     *         aparecem na String fornecida. Se o argumento for "" (String
     * que não contém nenhum caractere), então o
     *         retorno será uma lista contendo uma única String ("").
     * @throws IllegalArgumentException
     *             Se o argumento (referência) fornecido for <code>null</code> ou
     * se a String fornecida não estiver no formato CSV.
     * @see #obtemArrayCampos(String)
     */
    public List<String> obtemListaCampos(String csv);

    /**
     * Oferece funcionalidade semelhante à
     * {@link CsvService#obtemListaCampos(String)}. A diferença está no retorno.
     * Aquele método retorna os campos em uma lista, enquanto este método
     * deposita os campos em um <i>array</i>.
     *
     * @param csv
     *            Linha no formato CSV cujos campos devem ser retornados.
     * @return Campos contidos na String CSV fornecida como argumento. Os campos
     * são fornecidos no <i>array</i> na mesma ordem em que aparecem na String
     * CSV. Se o argumento for "" (String que não contém nenhum caractere),
     * então o retorno será um <i>array</i> contendo uma única String ("").
     * @throws IllegalArgumentException
     *             Se o argumento (referência) fornecida for <code>null</code>  ou
     * se a String fornecida não estiver no formato CSV.
     * @see #obtemListaCampos(String)
     */
    public String[] obtemArrayCampos(String csv);
}
