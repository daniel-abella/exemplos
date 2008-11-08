package br.ufg.inf.junit;

import java.util.List;

/**
 * Oferece v�rios servi�os para manipula��o do formato CSV. Por padr�o, uma
 * linha neste formato � formado por v�rios campos separados por ';'. Outro
 * separador, diferente de ';' pode ser definido.
 * 
 * @author F�bio Nogueira de Lucena
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
	 *            Objetos que dever�o dar origem a linha no formato CSV na ordem
	 *            em que s�o fornecidos na lista.
	 * @return Linha CSV contendo os objetos fornecidos na lista separados pelo
	 *         separador definido.
	 */
	public String toString(List<Object> lista);

	/**
	 * Obt�m campos de linha no formato CSV. Monta lista de Strings
	 * correspondentes a cada um dos campos fornecidos pela entrada. Os campos
	 * s�o separados por ';' (situa��o padr�o) ou outro separador definido por
	 * {@link #defineSeparador(char)}.
	 * 
	 * @param linha
	 *            Linha contendo campos separados por ';' (padr�o).
	 * @return Lista de Strings correspondentes aos campos, na ordem em que
	 *         aparecem na String fornecida.
	 * @see #obtemArrayCampos(String)
	 */
	public List<String> obtemListaCampos(String linha);

	/**
	 * Obt�m campos de linha no formato CSV. Campos s�o fornecidos
	 * na mesma ordem em que aparecem na String fornecida. Por padr�o
	 * o separador adotado � ';', embora outro separador possa ser
	 * definido por meio de {@link Formato#defineSeparador(char)}.
	 * 
	 * @param linha Linha no formato CSV cujos campos devem ser retornados.
	 * @return
	 * @see #obtemListaCampos(String)
	 */
	public String[] obtemArrayCampos(String linha);
}
