package br.ufg.inf.junit;

import java.util.List;

/**
 * Oferece vários serviços para manipulação do formato CSV. Por padrão, uma
 * linha neste formato é formado por vários campos separados por ';'. Outro
 * separador, diferente de ';' pode ser definido.
 * 
 * @author Fábio Nogueira de Lucena
 * @version 0.1
 * 
 */
public interface Formato {
	/**
	 * Define separador empregado na montagem de Strings (linhas de um arquivo
	 * no formato CSV.
	 * 
	 * @param separador
	 *            Separador a ser empregado entre campos de uma String no
	 *            formato CSV.
	 */
	public void defineSeparador(char separador);

	/**
	 * Monta linha (String) no formato CSV usando como separador o que for
	 * definido pelo metodo {@link #defineSeparador(char)}.
	 * 
	 * @param lista
	 *            Objetos que deverão dar origem a linha no formato CSV na ordem
	 *            em que são fornecidos na lista.
	 * @return Linha CSV contendo os objetos fornecidos na lista separados pelo
	 *         separador definido.
	 */
	public String toString(List<Object> lista);

	/**
	 * Obtém campos de linha no formato CSV. Monta lista de Strings
	 * correspondentes a cada um dos campos fornecidos pela entrada. Os campos
	 * são separados por ';' (situação padrão) ou outro separador definido por
	 * {@link #defineSeparador(char)}.
	 * 
	 * @param linha
	 *            Linha contendo campos separados por ';' (padrão).
	 * @return Lista de Strings correspondentes aos campos, na ordem em que
	 *         aparecem na String fornecida.
	 * @see #obtemArrayCampos(String)
	 */
	public List<String> obtemListaCampos(String linha);

	/**
	 * Obtém campos de linha no formato CSV. Campos são fornecidos
	 * na mesma ordem em que aparecem na String fornecida. Por padrão
	 * o separador adotado é ';', embora outro separador possa ser
	 * definido por meio de {@link Formato#defineSeparador(char)}.
	 * 
	 * @param linha Linha no formato CSV cujos campos devem ser retornados.
	 * @return
	 * @see #obtemListaCampos(String)
	 */
	public String[] obtemArrayCampos(String linha);
}
