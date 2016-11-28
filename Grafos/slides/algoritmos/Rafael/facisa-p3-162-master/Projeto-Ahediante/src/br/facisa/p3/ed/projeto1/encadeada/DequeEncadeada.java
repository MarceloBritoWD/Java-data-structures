package br.facisa.p3.ed.projeto1.encadeada;
/**
 * Classe de estrutura de dados, tipo deque
 * @author rafael
 *
 */
public class DequeEncadeada {
	private Element head;
	private int index;
	/**
	 * verifica se o deque esta vazio
	 * @return
	 */
	public boolean isEmpty(){
		if (index == 0){
			return true;
		}return false;
	}
	/**
	 * pega o elemento na frente
	 * @return
	 */
	public Object getFront(){
		return head.getElement();
	}
	/**
	 * pega o elemente no fim
	 * @return
	 */
	public Object getRear(){
		Element temp = head;
		for (int i = 0; i < index-1; i++){
			temp = temp.getNext();
		}
		return temp.getElement();
	}
	/**
	 * adiciona um elemento na frente
	 * @param element
	 */
	public void insertFront(Object element){
		if (head == null){
			head = new Element(element);
		}else{
			Element temp = head;
			head = new Element(element);
			head.setNext(temp);
		}
		index++;
	}
	/**
	 * adiciona um elemento no fim
	 * @param element
	 */
	public void insertRear(Object element){
		if (head == null){
			head = new Element(element);
		}else{
		Element temp = head;
		while (temp.getNext()!= null){
			temp = temp.getNext();
		}
		temp.setNext(new Element(element));
		index ++;
		}
	}
	/**
	 * remove um elemento no fim
	 */
	public void removeRear(){
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
	 * remove um elemento na frente
	 */
	public void removeFront(){
		head = head.getNext();
		index--;
	}
	/**
	 * concatena dois deques
	 * @param dqueue
	 */
	public void joinDequeue(DequeEncadeada dqueue){
		for (int i =0; i< dqueue.getIndex()/2; i++){
			insertFront(dqueue.getFront());
			insertRear(dqueue.getRear());
			dqueue.removeFront();
			dqueue.removeRear();
		}
	}
	
	protected int getIndex(){
		return this.index;
	}
	 
}
