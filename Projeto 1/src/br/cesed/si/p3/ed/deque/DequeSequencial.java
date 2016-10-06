package br.cesed.si.p3.ed.deque;

import br.cesed.si.p3.ed.exceptions.dequeVazioException;

public class DequeSequencial {
	private static final int TAMANHO_INICIAL = 5;
	private static final int DOBRO = 2;
	Object[] deque = new Object[TAMANHO_INICIAL];
	int fimDeque;
	
	/**
	 * Metodo responsavel por retornar se o deque esta vazio ou nao.
	 * @return
	 */
	public boolean dequeIsVazio(){
		if (deque[0] == null)
			return true;
		return false;
	}	
	
	/**
	 * Metodo responsavel por retornar o primeiro elemento do deque.
	 * Caso nao exista nenhum elemento sera lancada uma excecao.
	 * @return
	 * @throws dequeVazioException
	 */
	public Object getPrimeiroItem() throws dequeVazioException{
		if (deque[0] != null)
			return deque[0];
		else {
			throw new dequeVazioException();
		}
	}
	
	/**
	 * Metodo responsavel por retornar o ultimo elemento do deque.
	 * Caso nao exista nenhum elemento sera lancada uma excecao.
	 * @return
	 * @throws dequeVazioException
	 */	
	public Object getUltimoItem() throws dequeVazioException{
		if (deque[fimDeque-1] != null)
			return deque[fimDeque-1];
		else {
			throw new dequeVazioException();
		}
	}	
	
	/**
	 * Metodo responsavel por adicionar um item no inicio do deque.
	 * @param item
	 */
	public void adicionarNoInicio(String item){
		Object[] novoDeque = new Object[fimDeque + 1];
		novoDeque[0] = item;
		
		for (int i = 0; i < fimDeque; i++)
			novoDeque[i+1] = deque[i];
		deque = novoDeque;
		
		fimDeque++;
	}	
	
	/**
	 * Metodo responsavel por adicionar um item no fim do deque.
	 * @param item
	 */
	public void adicionarNoFim(String item){
		if (deque.length == fimDeque) {
			Object[] novaLista = new Object[fimDeque * DOBRO];
			for (int i = 0; i < deque.length; i++)
				novaLista[i] = deque[i];			
			deque = novaLista;
		}		
		deque[fimDeque] = item;
		fimDeque++;
	}
	
	/**
	 * Metodo responsavel por remover o primeiro item do deque.	
	 */
	public void removerPrimeiroItem(){
		deque[0] = null;
		
		Object[] novoDeque = new Object[fimDeque-1];
		for (int i = 1; i < fimDeque; i++)
			novoDeque[i-1] = deque[i];
		deque = novoDeque;
		
		fimDeque--;
	}
		
	/**
	 * Metodo responsavel por remover o ultimo item do deque.	
	 */
	public void removerUltimoItem() {
		deque[fimDeque-1] = null;
		fimDeque--;
	}
	
	/**
	 * Metodo responsavel por concatenar dois deques.
	 * @param dequeASomar
	 */
	public void concatenarDeques(Object[] dequeASomar){
		Object[] novoDeque = new Object[fimDeque + dequeASomar.length];
		
		for (int i = 0; i < fimDeque; i++) {
			novoDeque[i] = deque[i];
		}
		
		int contDequeASomar = 0;
		int contDeque = fimDeque;
		while (contDequeASomar < dequeASomar.length) {
			novoDeque[contDeque] = dequeASomar[contDequeASomar];
			contDequeASomar++;
			contDeque++;
		}
		
		deque = novoDeque;
		fimDeque += dequeASomar.length;		
	}
	
	/**
	 * Metodo responsavel por imprimir os itens do deque.
	 * @return
	 */
	public String imprimirDeque() {
		String stringFinal = "[";
		
		for (int i = 0; i < fimDeque; i++) {
			stringFinal += deque[i];
			if (i < fimDeque - 1)
				stringFinal += ", ";			
		}
		stringFinal += "]";
		
		return stringFinal;
	}
}
