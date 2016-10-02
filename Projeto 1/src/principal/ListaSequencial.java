package principal;
public class ListaSequencial {
	private static final int TAMANHO_INICIAL = 5;
	private static final int DOBRO = 2;
	Object[] lista = new Object[TAMANHO_INICIAL];
	int posicao;	
	
	
	public void adicionaNoInicio(String item){
		Object[] novaLista = new Object[posicao + 1];
		novaLista[0] = item;
		
		for (int i = 0; i < posicao; i++)
			novaLista[i+1] = lista[i];
		lista = novaLista;
		
		posicao++;
	}	
	
	public void adicionaNoFim(String item){
		if (lista.length == posicao) {
			Object[] novaLista = new Object[posicao * DOBRO];
			for (int i = 0; i < lista.length; i++)
				novaLista[i] = lista[i];			
			lista = novaLista;
		}		
		lista[posicao] = item;
		posicao++;
	}	
	
	public void excluirPorIndice(int indice){
		for (int i = 0; i < posicao; i++) {
			if (i == indice)
				lista[i] = null;
		}	
		organizaListaAposExclusao();
		posicao--;
	}
	
	public void excluirPorValor(Object valor){
		for (int i = 0; i < posicao; i++) {
			if (lista[i] == valor)
				lista[i] = null;
		}
		organizaListaAposExclusao();
		posicao--;
	}
	
	public int informaTamanho(){
		return posicao;
	}	
	
	public Object itemDePosicao(int indice) throws operacaoInvalidaException {
		for (int i = 0; i < posicao; i++) {
			if (i == indice)
				return lista[indice];
		}
		throw new operacaoInvalidaException();		
	}
	

	public int posicaoDeItem(Object item) throws operacaoInvalidaException {
		for (int i = 0; i < posicao; i++) {
			if (lista[i] == item)
				return i;
		}
		throw new operacaoInvalidaException();
	}
	
	public void inserirElementoEmPosicao(Object item, int local){		
		Object[] novaLista = new Object[posicao+1];
		
		for (int i = 0; i < local; i++)
			novaLista[i] = lista[i];
		
		novaLista[local] = item;
		
		for (int i = local; i < posicao; i++)
			novaLista[i+1] = lista[i];
		
		lista = novaLista;		
		posicao++;		
	}
	
	public void concatenarListas(Object[] listaASomar){
		Object[] novaLista = new Object[posicao + listaASomar.length];
		
		for (int i = 0; i < posicao; i++) {
			novaLista[i] = lista[i];
		}
		
		int contListaASomar = 0;
		int contLista = posicao;
		while (contListaASomar < listaASomar.length) {
			novaLista[contLista] = listaASomar[contListaASomar];
			contListaASomar++;
			contLista++;
		}
		
		lista = novaLista;
		posicao += listaASomar.length;		
	}	
	
	public void organizaListaAposExclusao(){		
		Object[] novaLista = new Object[posicao];
		int contNovaLista = 0;
		int contLista = 0;
		while (contLista < posicao) {
			if (lista[contLista] != null) {
				novaLista[contNovaLista] = lista[contLista];
				contNovaLista++;
			}
			contLista++;
		}
		lista = novaLista;			
	}
	
	public String imprime() {
		String stringFinal = "[";
		
		for (int i = 0; i < posicao; i++) {
			stringFinal += lista[i];
			if (i < posicao - 1)
				stringFinal += ", ";			
		}
		stringFinal += "]";
		
		return stringFinal;
	}
}
