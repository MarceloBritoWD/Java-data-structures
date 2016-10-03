package principal;

public class PilhaContaEncadeada {
	private Conta primeiraConta;
	
	
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
	
	
	public String consultarTopo(){
		Conta cabeca = primeiraConta;		
		while (cabeca.getProximaConta() != null) {
			cabeca = cabeca.getProximaConta();
		}
		return cabeca.getTitular();
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
	
	public boolean pilhaIsVazia(){
		if (primeiraConta == null)
			return true;
		return false;
	}
	
}
