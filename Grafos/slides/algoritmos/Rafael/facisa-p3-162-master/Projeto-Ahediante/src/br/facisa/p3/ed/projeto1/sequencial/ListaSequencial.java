package br.facisa.p3.ed.projeto1.sequencial;
/**
 * Classe de estrutura de dados, tipo lista
 * @author rafael
 *
 */
public class ListaSequencial {
	final static int LIST_SIZE = 5; 
	private static final int DOUBLE = 2;
	private Object[] list = new Object[LIST_SIZE];
	private int index;
	
	/**
	 * 
	 * verifica o tamanho da lista
	 */
	public int size(){
		return this.index;
	}
	
	/**
	 * 
	 * adiciona um elemento na lista
	 */
	public void append(Object element){
		if (index == this.list.length){
			expandList();
		}
		this.list[index] = element;
		index++;
	}
	/**
	 * adiciona um elemento a esquerda
	 * @param element
	 */
	public void appendLeft(Object element){
		if (this.index == this.list.length){
			expandList();	
		}
		openSpaceList(0);
		this.list[0] = element;
		this.index++;
	}
	
	/**
	 * insere um elemento em qualquer posicao valida
	 * @param index
	 * @param element
	 */
	public void insert(int index, Object element){
		if (this.index == this.list.length){
			expandList();
		}
		if (index > this.index){
			append(element);
		}else{
			openSpaceList(index);
			this.list[index] = element;
		}
		this.index++;
	}
	
	/**
	 * pega um elemento
	 * @param index
	 * @return
	 */
	public Object getElement(int index){
		return this.list[index];
	}
	
	/**
	 * pega o index de um elemento
	 * @param element
	 * @return int
	 */
	
	public int getIndexElement(Object element){
		int j = 0;
		for (int i = 0; i < this.index; i++){
			if (element.equals(this.list[i])){
				j = i;
				break;
			}
		}
		return j;
	}
	
	/**
	 * remove um elemento
	 * @param element
	 */
	public void remove(Object element){
		for (int i = 0; i < this.index; i ++){
			if (element.equals(this.list[i])){
				this.list[i] = null;
			}
		}
		redefineList();
		index --;
	}
	/**
	 * remove um elemento pelo index
	 * @param index
	 */
	public void indexRemove(int index){
		this.list[index] = null;
		redefineList();
		index --;
	}
	

	/**
	 * Concatena duas listas
	 * @param list
	 */
	public void joinLists(ListaSequencial list){
		for (int i = 0; i < list.size(); i++){
			if(index == this.list.length){
				expandList();
			}
			append(list.getElement(i));
			index++;
		}
		redefineList();
	}
	
	private void openSpaceList(int index){
		Object[] newList = new Object[this.list.length+1]; 
		if (this.index+1 == this.list.length){
			expandList();
		}
		for (int i = 0; i < index; i++){
			newList[i] = list[i];
		}
		for (int i = index; i < this.list.length; i++ ){
			newList[i+1] = this.list[i];
		}
		this.list = newList;
	}
	
	private void expandList(){
		Object[] newList = new Object[this.index*DOUBLE];
		for (int i = 0; i< this.index; i++){
			newList[i] = this.list[i];
		}
		this.list = newList;
	}
	
	private void redefineList(){
		Object [] newList = new Object[this.index];
		int j = 0;
		for (int i = 0; i < this.list.length; i++){
			if(this.list[i] != null){
				newList[j] = this.list[i];
				j++;
			}
		}
		this.list = newList;
	}
	
	
	
}
