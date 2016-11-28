package br.facisa.p3.ed.projeto1.sequencial;
/**
 * Classe de estrutura de dados, tipo fila
 * @author rafael
 *
 */
public class FilaSequencial {
	private final static int QUEUE_SIZE = 5; 
	private static final int DOUBLE = 2;
	private Object[] queue = new Object[QUEUE_SIZE];
	private int index;
	
	/**
	 * verifica se a fila esta vazia
	 * @return
	 */
	public boolean isEmpty(){
		if (index == 0){
			return true;
		}
		return false;
	}
	/**
	 * adiciona elemento na fila
	 * @param element
	 */
	public void enqueue(Object element){
		if (index == queue.length){
			expandList();
		}
		queue[index] = element;
		index ++;
	}
	/**
	 * remove elemento na fila
	 * @return
	 */
	public Object dequeue(){
		Object aux;
		aux = queue[0]; 
		queue[0] = null;
		redefineList();
		index--;
		return aux;
		
	}
	/**
	 * pega elemento da vez
	 * @return
	 */
	public Object peek(){
		return queue[0];
	}
	private void expandList(){
		Object[] newList = new Object[this.index*DOUBLE];
		for (int i = 0; i< this.index; i++){
			newList[i] = this.queue[i];
		}
		this.queue = newList;
	}
	
	private void redefineList(){
		Object [] newList = new Object[this.index];
		int j = 0;
		for (int i = 0; i < this.queue.length; i++){
			if(this.queue[i] != null){
				newList[j] = this.queue[i];
				j++;
			}
		}
		this.queue = newList;
	}
}