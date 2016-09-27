package principal;

public class FilaSequencial {
	private static final int TAMANHO_INICIAL = 5;
	private static final int DOBRO = 2;
	Object[] fila = new Object[TAMANHO_INICIAL];
	int fimFila;
	
	
	public boolean filaIsVazia(){
		if (fila[0] == null)
			return true;
		return false;
	}
	
	
	public Object getPrimeiroElemento() throws filaVaziaException{
		if (fila[0] != null)
			return fila[0];
		else {
			throw new filaVaziaException();
		}
	}
	
	
	public void inserirItem(Object item){
		if (fila.length == fimFila) {
			Object[] novaFila = new Object[fimFila * DOBRO];
			
			for (int i = 0; i < fila.length; i++) {
				novaFila[i] = fila[i];
			}
			
			fila = novaFila;
		}
		
		fila[fimFila] = item;
		fimFila++;
	}
	
	
	public Object removerItem(){
		Object retornar = fila[0];
		fila[0] = null;
		reorganizarFila();
		return retornar;
	}
	
	
	public void reorganizarFila(){
		Object[] novaFila = new Object[fimFila + 1];
		for (int i = 1; i < novaFila.length; i++) {
			novaFila[i-1] = fila[i];
		}		
		fila = novaFila;
	}	
	
}
