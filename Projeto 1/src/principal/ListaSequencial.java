package principal;
public class ListaSequencial {
	private static final int TAMANHO_INICIAL = 5;
	Object[] lista = new Object[TAMANHO_INICIAL];
	int posicao;	
	
	
	public void adicionaNoInicio(String item){}
	
	
	
	public void adicionaNoFim(String item){
		lista[posicao] = item;
		posicao++;
	}	
	
	public void excluirPorIndice(int indice){
		for (int i = 0; i < lista.length; i++) {
			if (i == indice)
				lista[i] = null;				
		}
	}
	
	
	public void excluirPorValor(int valor){}
	
	
	public int informaTamanho(){
		return posicao;
	}
	
	
	public Object itemDePosicao(int indice){
		for (int i = 0; i < lista.length; i++) {
			if (i == indice)
				return lista[indice];
		}
		// lançar uma exception de operação inválida aqui
		return "Operação Inválida!";
		
	}
	

	public Object posicaoDeItem(int item){
		for (int i = 0; i < lista.length; i++) {
			if (i == item)
				return i;
		}
		// lançar uma exception de operação inválida aqui
		return "Operação Inválida!";
		
	}
	
	public void inserirElementoEmPosicao(Object item, int posicao){}
	
	
		

	public String imprime() {
		String stringFinal = "[";
		
		for (int i = 0; i < lista.length; i++) {
			stringFinal += lista[i];
			if (i < lista.length - 1)
				stringFinal += ", ";			
		}
		stringFinal += "]";
		
		return stringFinal;
	}
}
