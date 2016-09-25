package principal;

public class TesteListaSequencial {
	public static void main(String[] args) {
		ListaSequencial lista = new ListaSequencial();
		
		lista.adicionaNoFim("Marcelo");
		lista.adicionaNoFim("Brito");
		lista.adicionaNoFim("Santos");
//		lista.adicionaNoFim("Brito");
		
		System.out.println(lista.imprime());
		System.out.println(lista.informaTamanho());
		
		lista.excluirPorIndice(0);		
		
		System.out.println(lista.imprime());
		
	}
}
