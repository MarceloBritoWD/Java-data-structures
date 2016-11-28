package br.facisa.p3.ed.main;

import br.facisa.p3.ed.graph.Graph;

public class Main {

	public static void main(String[] args) {
		Graph g = new Graph(3);
		g.add(0 , 1, 5);
		g.add(0, 2, 3);
		g.add(1, 0, 1);
		System.out.println(g.getGraph());

	}

}
