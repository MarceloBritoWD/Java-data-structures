package br.cesed.si.p3.ed.deque;

import br.cesed.si.p3.ed.Conta;

public class DequeContaEncadeada {
	private Conta primeiraConta;
	
	/**
	 * Metodo responsavel por informar se o deque esta vazio ou nao.
	 * @return
	 */
	public boolean dequeIsVazio(){
		if (primeiraConta == null)
			return true;
		return false;
	}
	
	/**
	 * Metodo responsavel por retornar a primeira Conta do deque.
	 * @return
	 */
	public String getPrimeiraConta() {
		return primeiraConta.getTitular();
	}
	
	/**
	 * Metodo responsavel por retornar a ultima Conta do deque.
	 * @return
	 */
	public String getUltimaConta(){
		Conta cabeca = primeiraConta;		
		while (cabeca.getProximaConta() != null) {
			cabeca = cabeca.getProximaConta();
		}
		return cabeca.getTitular();
	}
	
	/**
	 * Metodo responsavel por adicionar uma Conta no inicio do deque.
	 * @param titular
	 * @param agencia
	 * @param numeroConta
	 */
	public void adicionarContaNoInicio(String titular, int agencia, int numeroConta){
		if (primeiraConta == null) {
			primeiraConta = new Conta(titular, agencia, numeroConta);			
		} else {		
			Conta contaNoInicio = new Conta(titular, agencia, numeroConta);
			contaNoInicio.setProximaConta(primeiraConta);
			
			primeiraConta = contaNoInicio;
		}
	}
	
	/**
	 * Metodo responsavel por adicionar uma Conta no fim do deque.
	 * @param titular
	 * @param agencia
	 * @param numeroConta
	 */
	public void adicionarContaNoFim(String titular, int agencia, int numeroConta){
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
	 * Metodo responsavel por remover a primeira Conta do deque.
	 */
	public void removerPrimeiraConta() {
		primeiraConta = primeiraConta.getProximaConta();
	}
	
	/**
	 * Metodo responsavel por remover a ultima Conta do deque.
	 */
	public void removerUltimaConta() {
		Conta temp = primeiraConta;
		Conta anterior = null;
		
		while (temp.getProximaConta() != null) {
			anterior = temp;					
			temp = temp.getProximaConta();
		}
		anterior.setProximaConta(null);
	}	
	
	/**
	 * Metodo responsavel por concatenar dois deques de Contas.
	 * @param dequeASomar
	 */
	public void concatenarDequesDeConta(DequeContaEncadeada dequeASomar) {
		Conta temp = primeiraConta;
		
		while (temp.getProximaConta() != null) {
			Conta proximaConta = temp.getProximaConta();
			temp = proximaConta;
		}		
		temp.setProximaConta(dequeASomar.primeiraConta);		
	}
	
	/**
	 * Metodo responsavel por imprimir os itens do deque de Contas.
	 * @return
	 */
	public void imprimirContas() {	
		Conta temp = primeiraConta;
		
		while (temp != null) {
			System.out.println(temp);
			temp = temp.getProximaConta();
		}
	}
}
