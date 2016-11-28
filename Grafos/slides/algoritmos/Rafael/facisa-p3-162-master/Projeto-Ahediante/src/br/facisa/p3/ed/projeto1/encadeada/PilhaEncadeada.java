package br.facisa.p3.ed.projeto1.encadeada;
/**
 * Classe de estrutura de dados, tipo pilha
 * @author rafael
 *
 */
public class PilhaEncadeada {
	private Element head;
	private int index;
	/**
	 * adiciona um elemento na pilha
	 * @param elem
	 */
	public void push(Object elem){
		if (head == null){
			head = new Element(elem);
		}else{
			Element temp = head;
			Element aux = new Element(elem);
			for (int i = 0; i < this.index; i ++){
				temp.getNext();
			}
			temp.setNext(aux);
		}
		index++;
	}
	/**
	 * remove um elemento da pilha
	 */
	public void pop(){
		if (index == 1){
			head = null;
		}else{
			Element temp = head;
			for (int i = 0; i < this.index-1; i++){
				temp = temp.getNext();
			}
			temp.setNext(null);
		}
		index --;
	}
	/**
	 * pega o elemento da vez
	 * @return
	 */
	public Object peek(){
		Element temp = head;
		for (int i = 0; i < this.index-1; i++){
			temp = temp.getNext();
		}
		return temp.getElement();
	}
	/**
	 * retorna o tamanho da pilha
	 * @return
	 */
	public int size(){
		return index;
	}
	/**
	 * verifica se a pilha esta vazia
	 * @return
	 */
	public boolean isEmpty(){
		if(index == 0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * verifica se a pilha esta cheia
	 * @return
	 */
	public boolean isFull(){
		return !isEmpty();
	}
}
