package br.cesed.si.p3.ed.pilha;

public class PilhaSequencial {
	private static final int TAMANHO_INICIAL = 5;
	private static final int DOBRO = 2;
	Object[] pilha = new Object[TAMANHO_INICIAL];
	int proximo;
	
	/**
	 * Metodo responsavel por empilhar um item na pilha.
	 * @param item
	 */
	public void empilhar(Object item) {
		if (pilha.length == proximo) {
			Object[] novaPilha = new Object[proximo * DOBRO];
			
			for (int i = 0; i < pilha.length; i++) {
				novaPilha[i] = pilha[i];
			}			
			pilha = novaPilha;			
		}
		
		pilha[proximo] = item;
		proximo++;
	}
	
	/**
	 * Metodo responsavel por desempilhar um item da pilha.
	 * Caso a pilha ja esteja vazia sera lancada uma excecao. 
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void desempilhar() throws ArrayIndexOutOfBoundsException {
		if (pilhaIsVazia()){
			throw new ArrayIndexOutOfBoundsException();
		} else {
			pilha[proximo] = null;
			proximo--;
		}
		
	}
	
	/**
	 * Metodo responsavel por informar o topo da pilha.
	 * @return
	 */
	public Object consultarTopo() {
		return pilha[proximo-1];
	}
	
	/**
	 * Metodo responsavel por informar o tamanho da pilha.
	 * @return
	 */
	public int tamanhoPilha() {
		return proximo;
	}
	
	/**
	 * Metodo responsavel por informar se a pilha esta vazia ou nao.
	 * @return
	 */
	public boolean pilhaIsVazia(){
		if (consultarTopo() != null)
			return false;
		return true;
	}
}
