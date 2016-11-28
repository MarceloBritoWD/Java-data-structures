package br.facisa.p3.ed.main;

import javax.swing.plaf.synth.SynthSpinnerUI;

import br.facisa.p3.ed.tree.Tree;

public class Main {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.add(7);
		tree.add(8);
		tree.add(3);
		tree.add(2);
		tree.add(4);
		tree.add(6);
		tree.add(10);
		
		System.out.println("Pre order: " + tree.preOrder());
		System.out.println("In order: " +tree.inOrder());
		System.out.println("Post order: " +tree.postOrder());
	}

}
