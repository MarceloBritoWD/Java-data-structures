
public class PilhaSequencial {

	Object[] pilha = new Object[5];
	int topo;
	
	
	public void push(Object item) {
		pilha[topo] = item;
		topo++;
	}
	
	public void pop(Object item) {
		pilha[topo] = null;
		topo--;
	}
	
	//topo da pilha sem remove-lo
	public Object peek(Object item) {
		return pilha[topo];
	}
	
	public Object tamanhoPilha(Object item) {
		return topo;
	}
	
	public boolean pilhaIsVazia(){
		if (pilha[topo] == null)
			return true;
		return false;
	}
	
}
