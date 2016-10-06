package br.cesed.si.p3.ed;

public class Conta {
	private String titular;
	private int agencia;
	private int numeroConta;
	
	private Conta proximaConta;
	
	public Conta(String titular, int agencia, int numeroConta){
		this.titular = titular;
		this.agencia = agencia;
		this.numeroConta = numeroConta;
	}

	
	public String getTitular() {
		return titular;
	}	

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Conta getProximaConta() {
		return proximaConta;
	}

	public void setProximaConta(Conta proximaConta) {
		this.proximaConta = proximaConta;
	}

	@Override
	public String toString() {
		return "Conta [titular=" + titular + ", agencia=" + agencia + ", numeroConta=" + numeroConta + "]";
	}
		
}
