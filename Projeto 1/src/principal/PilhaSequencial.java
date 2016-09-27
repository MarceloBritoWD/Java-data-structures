package principal;

import java.util.Arrays;

public class PilhaSequencial {
	private static final int TAMANHO_INICIAL = 5;
	private static final int DOBRO = 2;
	Object[] pilha = new Object[TAMANHO_INICIAL];
	int proximo;
	
	public void empilhar(Object item) {
		if (pilha.length == proximo) {
			Object[] novaPilha = new Object[proximo * DOBRO];
			
			for (int i = 0; i < pilha.length; i++) {
				novaPilha[i] = pilha[i];
			}			
			pilha = novaPilha;			
		}
		
		pilha[proximo] = item;
		proximo++;
	}
	
	
	public void desempilhar() throws ArrayIndexOutOfBoundsException {
		if (pilhaIsVazia()){
			throw new ArrayIndexOutOfBoundsException();
		} else {
			pilha[proximo] = null;
			proximo--;
		}
		
	}
	

	public Object consultarTopo() {
		return pilha[proximo-1];
	}
	
	
	public int tamanhoPilha() {
		return proximo;
	}
	
	
	public boolean pilhaIsVazia(){
		if (consultarTopo() != null)
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "PilhaSequencial [pilha=" + Arrays.toString(pilha) + ", topo=" + proximo + "]";
	}	
}
