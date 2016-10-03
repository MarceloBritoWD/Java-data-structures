package principal;

public class DequeSequencial {
	private static final int TAMANHO_INICIAL = 5;
	private static final int DOBRO = 2;
	Object[] deque = new Object[TAMANHO_INICIAL];
	int fimDeque;
	
	public boolean dequeIsVazio(){
		if (deque[0] == null)
			return true;
		return false;
	}	
	
	
	public Object getPrimeiroElemento() throws dequeVazioException{
		if (deque[0] != null)
			return deque[0];
		else {
			throw new dequeVazioException();
		}
	}
	
	public Object getUltimoElemento() throws dequeVazioException{
		if (deque[fimDeque-1] != null)
			return deque[fimDeque-1];
		else {
			throw new dequeVazioException();
		}
	}	
	
	
	public void adicionaNoInicio(String item){
		Object[] novoDeque = new Object[fimDeque + 1];
		novoDeque[0] = item;
		
		for (int i = 0; i < fimDeque; i++)
			novoDeque[i+1] = deque[i];
		deque = novoDeque;
		
		fimDeque++;
	}	
	
	
	public void adicionaNoFim(String item){
		if (deque.length == fimDeque) {
			Object[] novaLista = new Object[fimDeque * DOBRO];
			for (int i = 0; i < deque.length; i++)
				novaLista[i] = deque[i];			
			deque = novaLista;
		}		
		deque[fimDeque] = item;
		fimDeque++;
	}
	
	
	
	public void removerPrimeiroElemento(){
		deque[0] = null;
		
		Object[] novoDeque = new Object[fimDeque-1];
		for (int i = 1; i < fimDeque; i++)
			novoDeque[i-1] = deque[i];
		deque = novoDeque;
		
		fimDeque--;
	}
		
	
	public void removerUltimoElemento() {
		deque[fimDeque-1] = null;
		fimDeque--;
	}
	
	
	public void concatenarDeques(Object[] dequeASomar){
		Object[] novoDeque = new Object[fimDeque + dequeASomar.length];
		
		for (int i = 0; i < fimDeque; i++) {
			novoDeque[i] = deque[i];
		}
		
		int contDequeASomar = 0;
		int contDeque = fimDeque;
		while (contDequeASomar < dequeASomar.length) {
			novoDeque[contDeque] = dequeASomar[contDequeASomar];
			contDequeASomar++;
			contDeque++;
		}
		
		deque = novoDeque;
		fimDeque += dequeASomar.length;		
	}
	
	
	public String imprime() {
		String stringFinal = "[";
		
		for (int i = 0; i < fimDeque; i++) {
			stringFinal += deque[i];
			if (i < fimDeque - 1)
				stringFinal += ", ";			
		}
		stringFinal += "]";
		
		return stringFinal;
	}
	
	
	
}
