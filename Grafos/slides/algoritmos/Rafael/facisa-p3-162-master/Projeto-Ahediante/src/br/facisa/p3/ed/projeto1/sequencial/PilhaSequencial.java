package br.facisa.p3.ed.projeto1.sequencial;
/**
 * Classe de estrutura de dados, tipo pilha
 * @author rafael
 *
 */
public class PilhaSequencial { 
	private final static int LIST_SIZE = 5; 
	private static final int DOUBLE = 2;
	private Object[] stack = new Object[LIST_SIZE];
	private int index;
	
	/**
	 * verifica tamanho da pilha
	 * @return
	 */
	public int size(){
		return this.index;
	}
	/**
	 * adiciona elemento na pilha
	 * @param element
	 */
	public void push(Object element){
		if (this.index == this.stack.length){
			expandList();
		}
		this.stack[this.index] = element;
		this.index++;
	}
	/**
	 * tira elemento da vez
	 */
	public void pop(){
		this.stack[index] = null;
		this.index --;
	}
	/**
	 * pega o elemento da vez
	 * @return
	 */
	public Object peek(){
		return (stack[index-1]);
	}
	/**
	 * verifica se a pilha esta vazia
	 * @return
	 */
	public boolean isEmpty(){
		if (index == 0){
			return true;
		}
		return false;
	}
	
	
	private void expandList(){
		Object[] newList = new Object[this.index*DOUBLE];
		for (int i = 0; i< this.index; i++){
			newList[i] = this.stack[i];
		}
		this.stack = newList;
	}
	
}
