package br.cesed.si.p3.ed.fila;

import br.cesed.si.p3.ed.exceptions.filaVaziaException;

public class FilaSequencial {
	private static final int TAMANHO_INICIAL = 5;
	private static final int DOBRO = 2;
	Object[] fila = new Object[TAMANHO_INICIAL];
	int fimFila;
	
	/**
	 * Metodo responsavel por informar se a fila esta vazia ou nao.
	 * @return
	 */
	public boolean filaIsVazia(){
		if (fila[0] == null)
			return true;
		return false;
	}
	
	/**
	 * Metodo responsavel por informar o primeiro item da fila.
	 * Caso nao exista nenhum item na fila sera lansaca uma excecao.
	 * @return
	 * @throws filaVaziaException
	 */
	public Object getPrimeiroItem() throws filaVaziaException{
		if (fila[0] != null)
			return fila[0];
		else {
			throw new filaVaziaException();
		}
	}
	
	/**
	 * Metodo responsavel por inserir um item na fila.
	 * @param item
	 */
	public void inserirItem(Object item){
		if (fila.length == fimFila) {
			Object[] novaFila = new Object[fimFila * DOBRO];
			
			for (int i = 0; i < fila.length; i++) {
				novaFila[i] = fila[i];
			}
			
			fila = novaFila;
		}
		
		fila[fimFila] = item;
		fimFila++;
	}
	
	/**
	 * Metodo responsavel por remover um item da fila.
	 * @return
	 */
	public Object removerItem(){
		Object retornar = fila[0];
		fila[0] = null;
		reorganizarFila();
		fimFila--;
		return retornar;
		
	}
	
	/**
	 * Metodo responsavel por organizar a fila apos a remocao de um item.
	 */
	public void reorganizarFila(){
		Object[] novaFila = new Object[fimFila-1];
		for (int i = 1; i < fimFila; i++) {
			novaFila[i-1] = fila[i];
		}
		fila = novaFila;
	}	
	
}
