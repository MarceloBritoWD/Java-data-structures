package br.facisa.p3.ed.projeto1.encadeada;

public class Element {
	private Object element;
	private Element next;
	
	public Element(Object element){
		this.element = element;
	}
	
	public void setNext(Element element){
		this.next = element;
	}
	
	public Element getNext(){
		return this.next;
	}
	
	public Object getElement(){
		return this.element;
	}
}
