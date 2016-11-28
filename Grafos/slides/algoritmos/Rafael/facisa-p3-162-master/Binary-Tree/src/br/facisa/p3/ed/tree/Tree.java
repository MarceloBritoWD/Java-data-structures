package br.facisa.p3.ed.tree;

import java.util.ArrayList;

public class Tree {
	private Node head;
	
	public void add(int value){
		Node node = new Node(value);
		Node aux = head;
		if (head == null){
			this.head = node;
		}else{
			add(node, aux);
		}
		
	}
	
	private void add(Node node, Node aux){
		
		if (node.getValue() < aux.getValue()){
			if(aux.getLeft() == null){
				aux.setLeft(node);
			} else {
				aux = aux.getLeft();
				add(node, aux);
			}
		} else if(node.getValue() > aux.getValue()){
			if (aux.getRight() == null){
				aux.setRight(node);
			} else {
				aux = aux.getRight();
				add(node,aux);
			}
		}
	}
	
	public ArrayList<Integer> preOrder(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Node aux = this.head;
		preOrder(aux, list);
		return list;
		
	}
	
	private void preOrder(Node aux, ArrayList<Integer> list ){
		
		if (aux != null){
			//System.out.println(aux.getValue());
			list.add(aux.getValue());
			preOrder(aux.getLeft(),list);
			preOrder(aux.getRight(),list);
		}	
	}
	
	public ArrayList<Integer> inOrder(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Node aux = this.head;
		inOrder(aux, list);
		return list;
	}
	
	private void inOrder(Node aux, ArrayList<Integer> list ){
		
		if (aux != null){
			inOrder(aux.getLeft(),list);
			list.add(aux.getValue());
			inOrder(aux.getRight(),list);
		}	
	}
	
	public ArrayList<Integer> postOrder(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Node aux = this.head;
		postOrder(aux, list);
		return list;
	}
	
	private void postOrder(Node aux, ArrayList<Integer> list ){
		
		if (aux != null){
			postOrder(aux.getLeft(),list);
			postOrder(aux.getRight(),list);
			list.add(aux.getValue());
		}	
	}
}
