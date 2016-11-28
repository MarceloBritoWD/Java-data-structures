package br.facisa.p3.ed.graph;

public class Edge {
	private int value;
	private int weight;
	
	public Edge(int value, int weight){
		this.value = value;
		this.weight = weight;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
