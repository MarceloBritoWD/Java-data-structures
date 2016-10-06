package br.cesed.si.p3.ed.lista;

import br.cesed.si.p3.ed.Conta;
import br.cesed.si.p3.ed.exceptions.operacaoInvalidaException;

public class ListaContaEncadeada {
	private Conta primeiraConta;
	
	/**
	 * Metodo responsavel por inserir uma Conta no inicio lista.
	 * @param titular
	 * @param agencia
	 * @param numeroConta
	 */
	public void inserirContaNoInicio(String titular, int agencia, int numeroConta){
		if (primeiraConta == null) {
			primeiraConta = new Conta(titular, agencia, numeroConta);			
		} else {		
			Conta contaNoInicio = new Conta(titular, agencia, numeroConta);
			contaNoInicio.setProximaConta(primeiraConta);
			
			primeiraConta = contaNoInicio;
		}		
	}
	
	/**
	 * Metodo responsavel por inserir uma Conta no fim lista.
	 * @param titular
	 * @param agencia
	 * @param numeroConta
	 */
	public void inserirContaNoFim(String titular, int agencia, int numeroConta){
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
	 * Metodo responsavel por excluir uma Conta pelo seu indice na lista. 
	 * @param indice
	 */
	public void excluirContaNoIndice(int indice) {
		int contador = 0;		
		Conta atual = primeiraConta;
		Conta anterior = null;
		
		while (atual != null) {			
			if (contador == indice) {
				anterior.setProximaConta(atual.getProximaConta());
				anterior = atual;
				atual = null;
			} else {
				anterior = atual;
				atual = anterior.getProximaConta();
				contador++;
			}			
		}
	}
	
	/**
	 * Metodo responsavel por excluir uma Conta da lista passando
	 * o nome de seu titular.
	 * @param titular
	 */
	public void excluirContaPorNome(String titular) {
		Conta atual = primeiraConta;
		Conta anterior = null;
		
		while (atual != null) {			
			if (atual.getTitular().equalsIgnoreCase(titular)) {
				anterior.setProximaConta(atual.getProximaConta());
				anterior = atual;
				atual = null;
			} else {
				anterior = atual;
				atual = anterior.getProximaConta();
			}			
		}
	}
	
	/**
	 * Metodo que retorna o tamanho da lista.
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
	 * Metodo responsavel por retornar o titular da Conta (pelo indice) na lista.
	 * Caso o indice seja invalido sera lançada uma excecao.
	 * @param indice
	 * @return
	 * @throws operacaoInvalidaException
	 */
	public String informarElementoDePosicao(int indice) throws operacaoInvalidaException {
		int contador = 0;
		Conta temp = primeiraConta;
		
		while (temp != null){
			if (contador == indice) {
				return temp.getTitular();
			}
			Conta proximaConta = temp.getProximaConta();
			temp = proximaConta;
			contador++;
		}
		throw new operacaoInvalidaException();	
	}
	
	/**
	 * Metodo responsavel por retornar a posicao da Conta (passando seu titular) na lista.
	 * Caso o titular seja invalido sera lancada uma excecao.
	 * @param item
	 * @return
	 * @throws operacaoInvalidaException
	 */
	public int informarPosicaoDeElementoPorNome(String titular) throws operacaoInvalidaException {
		int contador = 0;
		Conta temp = primeiraConta;
		
		while (temp != null){
			if (temp.getTitular().equalsIgnoreCase(titular)) {
				return contador;
			}
			Conta proximaConta = temp.getProximaConta();
			temp = proximaConta;
			contador++;
		}
		throw new operacaoInvalidaException();		
	}
	
	/**
	 * Metodo responsavel por inserir Conta em determinada posicao. 
	 * @param item
	 * @param local
	 */
	public void inserirContaEmPosicao(Conta conta, int posicao) {		
		int contador = 0;
		Conta atual = primeiraConta;
		Conta anterior = null;
			
		while (atual != null) {		
			if (contador == posicao) {
				anterior.setProximaConta(conta);				
				anterior = atual;
				conta.setProximaConta(atual);
			} else {
				anterior = atual;
				atual = anterior.getProximaConta();
			}
			contador++;
		}
		
	}
	
	/**
	 * Metodo responsavel por concatenar duas listas de Contas.
	 * @param listaASomar
	 */
	public void concatenarListasDeConta(ListaContaEncadeada listaASomar) {
		Conta temp = primeiraConta;
		
		while (temp.getProximaConta() != null) {
			Conta proximaConta = temp.getProximaConta();
			temp = proximaConta;
		}		
		temp.setProximaConta(listaASomar.primeiraConta);		
	}	
	
	
	/**
	 * Metodo responsavel por imprimir as Contas da lista.
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
