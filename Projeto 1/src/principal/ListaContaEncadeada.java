package principal;

public class ListaContaEncadeada {
	private Conta primeiraConta;
	
	
	public void inserirContaNoInicio(String titular, int agencia, int numeroConta){
		if (primeiraConta == null) {
			primeiraConta = new Conta(titular, agencia, numeroConta);			
		} else {		
			Conta contaNoInicio = new Conta(titular, agencia, numeroConta);
			contaNoInicio.setProximaConta(primeiraConta);
			
			primeiraConta = contaNoInicio;
		}		
	}
	
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
	
	
	public void concatenarListasDeConta(ListaContaEncadeada listaASomar) {
		Conta temp = primeiraConta;
		
		while (temp.getProximaConta() != null) {
			Conta proximaConta = temp.getProximaConta();
			temp = proximaConta;
		}		
		temp.setProximaConta(listaASomar.primeiraConta);		
	}	
	
	
	
	public void imprimirContas() {	
		Conta temp = primeiraConta;
		
		while (temp != null) {
			System.out.println(temp);
			temp = temp.getProximaConta();
		}
	}
	

}
