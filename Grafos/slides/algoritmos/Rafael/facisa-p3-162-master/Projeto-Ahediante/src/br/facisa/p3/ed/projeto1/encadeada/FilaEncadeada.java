package br.facisa.p3.ed.projeto1.encadeada;
/**
 * Classe de estrutura de dados, tipo fila
 * @author rafael
 *
 */
public class FilaEncadeada {
	private Element head;
	private int index;
	/**
	 * verifica se a fila esta vazia
	 * @return
	 */
	public boolean isEmpty(){
		if(index == 0){
			return true;
		}return false;
	}
	/**
	 * pega o elemento da vez
	 * @return
	 */
	public Object peek(){
		return head.getElement();
	}
	/**
	 * adiciona um elemento
	 * @param element
	 */
	public void enqueue(Object element){
		if (head == null){
			head = new Element(element);
		}else{
			Element temp = head;
			for (int i = 0; i < this.index-1; i++){
				temp = temp.getNext();
			}
			temp.setNext(new Element(element));
		}
		index++;
	}
	/**
	 * remove um elemento da fila
	 * @return
	 */
	public Object dequeue(){
		Element temp = head;
		head = head.getNext();
		index--;
		return temp.getElement();
	}
}
