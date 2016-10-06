package br.cesed.si.p3.ed.lista;

import br.cesed.si.p3.ed.exceptions.operacaoInvalidaException;

public class ListaSequencial {
	private static final int TAMANHO_INICIAL = 5;
	private static final int DOBRO = 2;
	Object[] lista = new Object[TAMANHO_INICIAL];
	int posicao;	
	
	/**
	 * Metodo responsavel por adicionar item no inicio da lista.
	 * @param item
	 */
	public void adicionarNoInicio(String item){
		Object[] novaLista = new Object[posicao + 1];
		novaLista[0] = item;
		
		for (int i = 0; i < posicao; i++)
			novaLista[i+1] = lista[i];
		lista = novaLista;
		
		posicao++;
	}	
	
	/**
	 * Metodo responsavel por adicionar item no fim da lista.
	 * @param item
	 */
	public void adicionarNoFim(String item){
		if (lista.length == posicao) {
			Object[] novaLista = new Object[posicao * DOBRO];
			for (int i = 0; i < lista.length; i++)
				novaLista[i] = lista[i];			
			lista = novaLista;
		}		
		lista[posicao] = item;
		posicao++;
	}
	
	/**
	 * Metodo responsavel por excluir item pelo indice da lista.
	 * @param indice
	 */	
	public void excluirPorIndice(int indice){
		for (int i = 0; i < posicao; i++) {
			if (i == indice)
				lista[i] = null;
		}	
		organizarListaAposExclusao();
		posicao--;
	}
	
	/**
	 * Metodo responsavel por excluir item por seu valor na lista.
	 * @param valor
	 */
	public void excluirPorValor(Object valor){
		for (int i = 0; i < posicao; i++) {
			if (lista[i] == valor)
				lista[i] = null;
		}
		organizarListaAposExclusao();
		posicao--;
	}
	
	/**
	 * Metodo que retorna o tamanho da lista.
	 * @return
	 */
	public int informarTamanho(){
		return posicao;
	}
	
	/**
	 * Metodo responsavel por retornar o valor do item (pelo indice) na lista.
	 * Caso o indice seja invalido sera lancada uma excecao.
	 * @param indice
	 * @return
	 * @throws operacaoInvalidaException
	 */
	public Object itemDePosicao(int indice) throws operacaoInvalidaException {
		for (int i = 0; i < posicao; i++) {
			if (i == indice)
				return lista[indice];
		}
		throw new operacaoInvalidaException();		
	}
	
	/**
	 * Metodo responsavel por retornar a posicao do item (por seu valor) na lista.
	 * Caso o valor seja invalido sera lancada uma excecao.
	 * @param item
	 * @return
	 * @throws operacaoInvalidaException
	 */
	public int posicaoDeItem(Object item) throws operacaoInvalidaException {
		for (int i = 0; i < posicao; i++) {
			if (lista[i] == item)
				return i;
		}
		throw new operacaoInvalidaException();
	}
	
	/**
	 * Metodo responsavel por inserir item em determinado local. 
	 * @param item
	 * @param local
	 */
	public void inserirElementoEmPosicao(Object item, int local){		
		Object[] novaLista = new Object[posicao+1];
		
		for (int i = 0; i < local; i++)
			novaLista[i] = lista[i];
		
		novaLista[local] = item;
		
		for (int i = local; i < posicao; i++)
			novaLista[i+1] = lista[i];
		
		lista = novaLista;		
		posicao++;		
	}
	
	
	/**
	 * Metodo responsavel por concatenar duas listas.
	 * @param listaASomar
	 */
	public void concatenarListas(Object[] listaASomar){
		Object[] novaLista = new Object[posicao + listaASomar.length];
		
		for (int i = 0; i < posicao; i++) {
			novaLista[i] = lista[i];
		}
		
		int contListaASomar = 0;
		int contLista = posicao;
		while (contListaASomar < listaASomar.length) {
			novaLista[contLista] = listaASomar[contListaASomar];
			contListaASomar++;
			contLista++;
		}
		
		lista = novaLista;
		posicao += listaASomar.length;		
	}
	
	
	/**
	 * Metodo responsavel por organizar a lista apas alguma exclusao de item.
	 */	
	public void organizarListaAposExclusao(){		
		Object[] novaLista = new Object[posicao];
		int contNovaLista = 0;
		int contLista = 0;
		while (contLista < posicao) {
			if (lista[contLista] != null) {
				novaLista[contNovaLista] = lista[contLista];
				contNovaLista++;
			}
			contLista++;
		}
		lista = novaLista;			
	}
	
	/**
	 * Metodo responsavel por imprimir os itens da lista.
	 * @return
	 */
	public String imprimirItens() {
		String stringFinal = "[";
		
		for (int i = 0; i < posicao; i++) {
			stringFinal += lista[i];
			if (i < posicao - 1)
				stringFinal += ", ";			
		}
		stringFinal += "]";
		
		return stringFinal;
	}
}
