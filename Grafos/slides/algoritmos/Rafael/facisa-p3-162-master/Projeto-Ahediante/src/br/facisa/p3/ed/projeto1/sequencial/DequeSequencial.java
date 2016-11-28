package br.facisa.p3.ed.projeto1.sequencial;
/**
 * Classe de estrutura de dados, tipo deque
 * @author rafael
 *
 */
public class DequeSequencial {
	private final static int DEQUEUE_SIZE = 5; 
	private static final int DOUBLE = 2;
	private Object[] dequeue = new Object[DEQUEUE_SIZE];
	private int index;
	
	/**
	 * verifica se o deque esta vazio
	 * @return verificacao
	 */
	public boolean isEmpty(){
		if(index == 0){
			return true;
		}return false;
	}
	
	/**
	 * pega o primeiro elemento
	 * @return
	 */
	public Object getFront(){
		return this.dequeue[0];
	}
	/**
	 * pega o ultimo elemento
	 * @return
	 */
	public Object getRear(){
		return this.dequeue[this.index-1];
	}
	/**
	 * insere um elemento na frente
	 * @param elem
	 */
	public void insertFront(Object elem){
		if (this.index == dequeue.length){
			expandList();
		}
		openSpaceList(0);
		dequeue[0] = elem;
		index ++;
	}
	/**
	 * insere um elemento no final
	 * @param elem
	 */
	public void insertRear(Object elem){
		if (this.index == dequeue.length){
			expandList();
		}
		dequeue[index] = elem;
		index ++;
	}
	/**
	 * remove um elemento na frente
	 */
	public void removeFront(){
		dequeue[0] = null;
		redefineList();
		index --;
	}
	/**
	 * remove um elemento no final
	 */
	public void removeRear(){
		dequeue[index] = null;
		index --;
	}
	/**
	 * concatena dois deques
	 * @param temp
	 */
	public void joinDequeue(DequeSequencial temp){
		for (int i = 0; i < temp.index/2; i ++){
			insertFront(temp.getFront());
			insertRear(temp.getRear());
			temp.removeFront();
			temp.removeRear();
		}
		
		this.index+= temp.size();
	}
	
	protected int size(){
		return index;
	}
	
	private void openSpaceList(int index){
		Object[] newList = new Object[this.dequeue.length+1]; 
		if (this.index+1 == this.dequeue.length){
			expandList();
		}
		for (int i = 0; i < index; i++){
			newList[i] = dequeue[i];
		}
		for (int i = index; i < this.dequeue.length; i++ ){
			newList[i+1] = this.dequeue[i];
		}
		this.dequeue = newList;
	}
	
	private void expandList(){
		Object[] newList = new Object[this.index*DOUBLE];
		for (int i = 0; i< this.index; i++){
			newList[i] = this.dequeue[i];
		}
		this.dequeue = newList;
	}
	
	private void redefineList(){
		Object [] newList = new Object[this.index];
		int j = 0;
		for (int i = 0; i < this.dequeue.length; i++){
			if(this.dequeue[i] != null){
				newList[j] = this.dequeue[i];
				j++;
			}
		}
		this.dequeue = newList;
	}
	
}
