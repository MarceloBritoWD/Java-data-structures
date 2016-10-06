package br.cesed.si.p3.ed.fila;

import br.cesed.si.p3.ed.Conta;

public class FilaContaEncadeada {
	private Conta primeiraConta;
	
	/**
	 * Metodo responsavel por informar se a fila de Contas esta vazia ou nao.
	 * @return
	 */
	public boolean filaIsVazia(){
		if (primeiraConta == null)
			return true;
		return false;
	}
	
	/**
	 * Metodo responsavel por informar a primeira Conta da fila.
	 * @return
	 */
	public String getPrimeiraConta() {
		return primeiraConta.getTitular();
	}
	
	/**
	 * Metodo responsavel por inserir uma Conta na fila.
	 * @param titular
	 * @param agencia
	 * @param numeroConta
	 */
	public void inserirConta(String titular, int agencia, int numeroConta) {
		if (primeiraConta == null) {
			primeiraConta = new Conta(titular, agencia, numeroConta);			
		
		} else {
			Conta cabeca = primeiraConta;
			
			while (cabeca.getProximaConta() != null) {
				cabeca = cabeca.getProximaConta();
			}
			
			Conta novaConta = new Conta(titular, agencia, numeroConta);
			cabeca.setProximaConta(novaConta);
		}	
	}	
	
	/**
	 * Metodo responsavel por remover uma Conta da fila e retorna-la.
	 * @return
	 */
	public String removerConta() {
		String retornar = primeiraConta.getTitular(); 
		primeiraConta = primeiraConta.getProximaConta();
		return retornar;
	}		
	
	/**
	 * Metodo responsavel por imprimir a fila de Contas.
	 */
	public void imprimirContas() {	
		Conta temp = primeiraConta;
		
		while (temp != null) {
			System.out.println(temp);
			temp = temp.getProximaConta();
		}
	}
	
}
