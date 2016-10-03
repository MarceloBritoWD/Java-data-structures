package principal;

public class DequeContaEncadeada {
	private Conta primeiraConta;
	
	public boolean dequeIsVazio(){
		if (primeiraConta == null)
			return true;
		return false;
	}
	
	public String getPrimeiraConta() {
		return primeiraConta.getTitular();
	}
	
	public String getUltimaConta(){
		Conta cabeca = primeiraConta;		
		while (cabeca.getProximaConta() != null) {
			cabeca = cabeca.getProximaConta();
		}
		return cabeca.getTitular();
	}
	
	public void adicionarContaNoInicio(String titular, int agencia, int numeroConta){
		if (primeiraConta == null) {
			primeiraConta = new Conta(titular, agencia, numeroConta);			
		} else {		
			Conta contaNoInicio = new Conta(titular, agencia, numeroConta);
			contaNoInicio.setProximaConta(primeiraConta);
			
			primeiraConta = contaNoInicio;
		}
	}
	
	
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
	
	public void removerPrimeiraConta() {
		primeiraConta = primeiraConta.getProximaConta();
	}
	
	
	public void removerUltimaConta() {
		Conta temp = primeiraConta;
		Conta anterior = null;
		
		while (temp.getProximaConta() != null) {
			anterior = temp;					
			temp = temp.getProximaConta();
		}
		anterior.setProximaConta(null);
	}	
	
	
	public void concatenarDequesDeConta(DequeContaEncadeada dequeASomar) {
		Conta temp = primeiraConta;
		
		while (temp.getProximaConta() != null) {
			Conta proximaConta = temp.getProximaConta();
			temp = proximaConta;
		}		
		temp.setProximaConta(dequeASomar.primeiraConta);		
	}	
	

	public void imprimirContas() {	
		Conta temp = primeiraConta;
		
		while (temp != null) {
			System.out.println(temp);
			temp = temp.getProximaConta();
		}
	}
}
