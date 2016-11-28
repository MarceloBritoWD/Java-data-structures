package br.facisa.p3.ed.projeto1.encadeada;
/**
 * Estrutura de dados encadeada do tipo lista
 * @author rafael
 *
 */
public class ListaEncadeada {
	
	private Element head;
	private int index;
	
	protected Element getHead(){
		return this.head;
	}
	/**
	 * retorna o tamanho da lista
	 * @return tamanho da lista
	 */
	public int size(){
		return index;
	}
	/**
	 * adiciona elemento na lista
	 * @param element
	 */
	public void append(Object element){
		if (head == null){
			head = new Element(element);
		}else{
			Element temp = head;
			while (temp.getNext()!= null){
				temp = temp.getNext();
			}
			temp.setNext(new Element(element));
		}
		index ++;
	}
	/**
	 * adiciona elemento a esquerda da lista
	 * @param element
	 */
	public void appendLeft(Object element){
		if (head == null){
			head = new Element(element);
		}else{
			Element temp = new Element(element);
			temp.setNext(head);
			head = temp;
		}
		index++;
	}
	/**
	 * insere um elemento em qualquer posicao
	 * @param element
	 * @param index
	 */
	public void insert(Object element, int index){
		if (head == null){
			head = new Element(element);
		}else{
			if (index == 0){
				appendLeft(element);
			}else if (index >= this.index){
				append(element);
			}else{
				Element temp = head;
				for(int i = 0; i < index-1; i ++){
					temp = temp.getNext();
				}
				Element newElem = new Element(element);
				Element aux = temp.getNext();
				temp.setNext(newElem);
				newElem.setNext(aux);
			}
		}
		this.index ++;
	}
	/**
	 * remove um elemento da lista
	 * @param ele
	 */
	public void remove(Object ele){
		Element temp = this.head;
		Element aux = null;
		if (temp.getElement().equals(ele)){
			this.head = head.getNext();
		}else{	
			for (int i = 0; i < this.index; i++){
				if(temp.getElement().equals(ele)){
					aux.setNext(temp.getNext());
				}else{
					aux = temp;
					temp = aux.getNext();
				}
			}
		}
		index --;
	}
	/**
	 * remove um elemento da lista pelo index
	 * @param index
	 */
	public void IndexRemove(int index){
		Element temp = this.head;
		Element aux = null;
		if (index == 0){
			this.head = temp.getNext();
		}else{
			for (int i = 0; i < index; i ++){
				aux = temp;
				temp = temp.getNext();
			}
			aux.setNext(temp.getNext());
		}
		
		index--;
	}
	/**
	 * pega um elemento da lista
	 * @param index
	 * @return
	 */
	public Object getElement(int index){
		Element temp = head;
		for (int i = 0; i < index; i++){
			temp = temp.getNext();
		}
		return temp.getElement();
	}
	/**
	 * pega o index de um elemento na lista
	 * @param Element
	 * @return
	 */
	public int getIndexElement(Object Element){
		Element temp = this.head;
		int aux = 0;
		for (int i = 0; i< this.index; i++){
			if (Element.equals(temp.getElement())){
				aux = i;
				break;
			}else{
				temp = temp.getNext();
			}
		}
		return aux;
	}
	/**
	 * concatena duas listas
	 * @param list
	 */
	public void joinList(ListaEncadeada list){
		Element temp = this.head;
		for (int i = 0; i < this.index-1; i++){
			temp = temp.getNext();
		}
		temp.setNext(list.getHead());
		index+=list.size();
	}
}
