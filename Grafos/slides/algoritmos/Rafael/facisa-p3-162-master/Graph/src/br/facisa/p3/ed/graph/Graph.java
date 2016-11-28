package br.facisa.p3.ed.graph;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph {
	private ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
	
	public Graph(int size){
		ArrayList<Edge> list;
		for (int i = 0; i < size; i ++){
			 list = new ArrayList<Edge>();
			 graph.add(list);
		}
	}
	
	public void add(int value1,int value2, int weight){
		Edge aux = new Edge(value2, weight);
		graph.get(value1).add(aux);
	}
	
	public String getGraph(){
		StringBuilder txt = new StringBuilder();
		int i = 0;
		for (ArrayList<Edge> it: graph){
			txt.append(i + "{ ");
			for (Edge it2 : it){
				txt.append("("+it2.getValue()+" , "+it2.getWeight()+")");
			}
			i++;
			txt.append("\n");
		}
		return txt.toString();
	}
	
	
	
}
