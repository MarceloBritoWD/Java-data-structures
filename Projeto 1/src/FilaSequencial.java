
public class FilaSequencial {
	
	Object[] fila = new Object[5];
	int fimFila;
	
	public boolean filaIsVazia(){
		if (fila[fimFila] == null)
			return true;
		return false;
	}
	
	public Object getPrimeiroElemento(){
		return fila[0];
	}
	
	public void inserirItem(Object item){
		fila[fimFila] = item;
		fimFila++;
	}
	
	public Object removerItem(Object item){
		Object retornar = fila[0];
		fila[0] = null;
		reordenarFila();		
		return retornar;
	}
	
	public void reordenarFila(){
		if (fila[0] == null){
			Object[] novaFila = new Object[fimFila];
			
			for (int i = 0; i < fimFila; i++) {
				if (fila[i] != null)
					novaFila[i] = fila[i];
			}
			
			fila = novaFila;	
		}
	}
	
	
	
	
	
}
