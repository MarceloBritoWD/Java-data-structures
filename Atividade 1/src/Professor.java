package br.cesed.si.p3.poo;

public class Professor extends Pessoa {
	private static final int QTD_MINIMA_MATERIAS_POR_PROFESSOR = 1;
	
	private Materia[] materias = new Materia[QTD_MINIMA_MATERIAS_POR_PROFESSOR];

	
	
	public Materia[] getMaterias() {
		return materias;
	}

	public void setMaterias(Materia[] materias) {
		this.materias = materias;
	}
	
}
