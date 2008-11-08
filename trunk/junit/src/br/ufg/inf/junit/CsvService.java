package br.ufg.inf.junit;

import java.util.List;

/**
 * Oferece serviços para a manipulação do formato CSV. Detalhes sobre este
 * formato podem ser obtidas em <a
 * href="http://pt.wikipedia.org/wiki/Comma-separated_values">CSV</a>. Uma
 * linha ou registro neste formato é, por exemplo, "1,teste,-5" (sem as aspas).
 * Neste caso, três campos foram separados por vírgula. Quando um campo fizer
 * uso de vírgula, então será necessário fornecê-lo entre aspas duplas. Por
 * exemplo,
 * <p>
 * <b>1,"Silva, João",teste,10</b>
 * 
 * <p>
 * No exemplo acima são fornecidos quatro (4) campos, todos separados por
 * vírgula. Observe que o segundo campo está entre aspas duplas, o que permite
 * empregar o separador (,) sem que esta demarque um campo (conforme ilustrado).
 * 
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 * 
 */
public interface CsvService {
	/**
	 * Define separador empregado para demarcar campos de uma linha no formato
	 * CSV. O argumento fornecido será utilizado pelo objeto como separador até
	 * que uma nova chamada a este método altere o separador para este objeto. O
	 * valor padrão é ';', ou seja, caso este método não seja explicitamente
	 * chamado após a criação de um objeto, o separador empregado será ';'.
	 * 
	 * @param separador
	 *            Demarca a separação entre campos de uma String no formato CSV.
	 *            <b>Importante:</b> quando um campo é fornecido entre aspas duplas, a ocorrência do
	 *            separador no campo não irá demarcar separação de campos.
	 */
	public void defineSeparador(char separador);

	/**
	 * Monta linha (String) no formato CSV usando como separador o que for
	 * definido pelo metodo {@link #defineSeparador(char)}.
	 * 
	 * @param lista
	 *            Lista de objetos que deverão dar origem à linha no formato CSV. Os
	 *            valores dos campos seguirão na mesma ordem em que estão presentes na
	 *            lista.
	 * @return Linha CSV contendo os objetos fornecidos na lista separados pelo
	 *         separador definido.
	 */
	public String toCsv(List<Object> lista);

	/**
	 * Obtém campos de linha no formato CSV. Monta lista de Strings
	 * correspondentes a cada um dos campos fornecidos pela entrada. Os campos
	 * são separados por ';' (situação padrão) ou outro separador definido por
	 * {@link #defineSeparador(char)}.
	 * 
	 * @param csv
	 *            Linha contendo campos separados por ';' (padrão).
	 * @return Lista de Strings correspondentes aos campos, na ordem em que
	 *         aparecem na String fornecida.
	 * @see #obtemArrayCampos(String)
	 */
	public List<String> obtemListaCampos(String csv);

	/**
	 * Obtém campos de linha no formato CSV. Campos são fornecidos na mesma
	 * ordem em que aparecem na String fornecida. Por padrão o separador adotado
	 * é ';', embora outro separador possa ser definido por meio de
	 * {@link CsvService#defineSeparador(char)}.
	 * 
	 * @param csv
	 *            Linha no formato CSV cujos campos devem ser retornados.
	 * @return Array de Strings contendo campos da linha fornecida.
	 * @see #obtemListaCampos(String)
	 */
	public String[] obtemArrayCampos(String csv);
}
