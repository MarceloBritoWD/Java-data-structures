package br.cesed.si.p3.poo;

public class Materia {
	private int id;
	private int vagas;
	private String nome;
	
	public void cadastrarMateria(){
	}
	
	public int obterQuantidadeVagas(){
		return vagas;
	}

	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
