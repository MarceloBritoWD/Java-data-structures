package principal;

public class FilaContaEncadeada {
	private Conta primeiraConta;
	
	
	public boolean filaIsVazia(){
		if (primeiraConta == null)
			return true;
		return false;
	}
	
	public String getPrimeiraConta() {
		return primeiraConta.getTitular();
	}
		
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
	
	public String removerConta() {
		String retornar = primeiraConta.getTitular(); 
		primeiraConta = primeiraConta.getProximaConta();
		return retornar;
	}		
	
	public void imprimirContas() {	
		Conta temp = primeiraConta;
		
		while (temp != null) {
			System.out.println(temp);
			temp = temp.getProximaConta();
		}
	}
	
}
