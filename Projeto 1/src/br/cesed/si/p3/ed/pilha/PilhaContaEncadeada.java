package br.cesed.si.p3.ed.pilha;

import br.cesed.si.p3.ed.Conta;

public class PilhaContaEncadeada {
	private Conta primeiraConta;
	
	/**
	 * Metodo responsavel por empilhar uma Conta na pilha.
	 * @param titular
	 * @param agencia
	 * @param numeroConta
	 */
	public void empilharConta(String titular, int agencia, int numeroConta){
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
	 * Metodo responsavel por desempilhar uma Conta da pilha.
	 * Caso a pilha ja esteja vazia lancara uma excecao.
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void desempilharConta() throws ArrayIndexOutOfBoundsException {		
		if (pilhaIsVazia()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			if (primeiraConta.getProximaConta() == null){ 
				primeiraConta = null;
			} else {
				Conta temp = primeiraConta;
				Conta anterior = null;
				
				while (temp.getProximaConta() != null) {
					anterior = temp;					
					temp = temp.getProximaConta();
				}
				anterior.setProximaConta(null);
			}
		}
	}	
	
	/**
	 * Metodo responsavel por informar a Conta do topo da pilha.
	 * @return
	 */
	public String consultarTopo(){
		Conta cabeca = primeiraConta;		
		while (cabeca.getProximaConta() != null) {
			cabeca = cabeca.getProximaConta();
		}
		return cabeca.getTitular();
	}
	
	/**
	 * Metodo responsavel por informar o tamanho da pilha.
	 * @return
	 */
	public int informarTamanho(){
		int contador = 0;
		Conta temp = primeiraConta; 
		
		while (temp != null){
			Conta proximaConta = temp.getProximaConta();
			temp = proximaConta;
			contador++;
		}
		
		return contador;				
	}
	
	/**
	 * Metodo responsavel por informar se a pilha de Contas esta vazia ou nao.
	 * @return
	 */
	public boolean pilhaIsVazia(){
		if (primeiraConta == null)
			return true;
		return false;
	}
	
}
