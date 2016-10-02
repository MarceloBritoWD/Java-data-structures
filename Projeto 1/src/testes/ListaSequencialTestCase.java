package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import principal.ListaSequencial;
import principal.operacaoInvalidaException;



@SuppressWarnings("deprecation")
public class ListaSequencialTestCase {
	
	ListaSequencial minhaLista; 

	@Before
	public void setUp() throws Exception {
		minhaLista = new ListaSequencial();
	}

	@After
	public void tearDown() throws Exception {
		minhaLista = null;
	}

	@Test
	public void testAdicionaNoInicio() {
		minhaLista.adicionaNoFim("Marcelo");
		minhaLista.adicionaNoFim("Davi");
		minhaLista.adicionaNoFim("Rafael");
		minhaLista.adicionaNoInicio("Abella");
		
//		System.out.println(minhaLista.imprime());
		Assert.assertEquals("[Abella, Marcelo, Davi, Rafael]", minhaLista.imprime());
	}
	
	@Test
	public void testAdicionaNoFim() {
		minhaLista.adicionaNoFim("Marcelo");
		minhaLista.adicionaNoFim("Davi");
		minhaLista.adicionaNoFim("Rafael");
		
		Assert.assertEquals("[Marcelo, Davi, Rafael]", minhaLista.imprime());
	}
	
	@Test
	public void testExcluirPorIndice() {
		minhaLista.adicionaNoFim("Marcelo");
		minhaLista.adicionaNoFim("Davi");
		minhaLista.adicionaNoFim("Rafael");
		minhaLista.excluirPorIndice(1);

		Assert.assertEquals("[Marcelo, Rafael]", minhaLista.imprime());
	}
	
	@Test
	public void testExcluirPorValor() {
		minhaLista.adicionaNoFim("Marcelo");
		minhaLista.adicionaNoFim("Davi");
		minhaLista.adicionaNoFim("Rafael");
		minhaLista.adicionaNoInicio("Abella");
		minhaLista.adicionaNoInicio("David");
		
		minhaLista.excluirPorValor("David");
		minhaLista.excluirPorValor("Rafael");
		
		Assert.assertEquals("[Abella, Marcelo, Davi]", minhaLista.imprime());
	}
	
	@Test
	public void testInformaTamanho() {
		minhaLista.adicionaNoFim("Marcelo");
		minhaLista.adicionaNoFim("Davi");
		minhaLista.adicionaNoFim("Rafael");
		minhaLista.adicionaNoInicio("Abella");
		minhaLista.adicionaNoInicio("David");
		minhaLista.excluirPorValor("David");
		
		Assert.assertEquals(4, minhaLista.informaTamanho());
	}
	
	@Test
	public void testItemDePosicao() throws operacaoInvalidaException {
		minhaLista.adicionaNoFim("Marcelo");
		minhaLista.adicionaNoFim("Davi");
		minhaLista.adicionaNoFim("Rafael");
		minhaLista.adicionaNoInicio("Abella");
		minhaLista.adicionaNoInicio("David");
		
		Assert.assertEquals("Abella", minhaLista.itemDePosicao(1));	
	}
	
	@Test(expected=operacaoInvalidaException.class)
	public void testItemDePosicaoComException() throws operacaoInvalidaException {
		minhaLista.adicionaNoFim("Marcelo");
		
		Assert.assertEquals("Abella", minhaLista.itemDePosicao(8));	
	}
	
	@Test
	public void testPosicaoDeItem() throws operacaoInvalidaException {
		minhaLista.adicionaNoFim("Marcelo");
		minhaLista.adicionaNoFim("Davi");
		minhaLista.adicionaNoFim("Rafael");
		minhaLista.adicionaNoInicio("Abella");
		minhaLista.adicionaNoInicio("David");
		
		Assert.assertEquals(2, minhaLista.posicaoDeItem("Marcelo"));
	}
	
	@Test(expected=operacaoInvalidaException.class)
	public void testPosicaoDeItemComException() throws operacaoInvalidaException {
		minhaLista.adicionaNoFim("Davi");
		minhaLista.adicionaNoFim("Rafael");
		
		Assert.assertEquals(0, minhaLista.posicaoDeItem("Marcelo"));
	}
	
	@Test
	public void testInserirElementoEmPosicao(){
		minhaLista.adicionaNoFim("Davi");
		minhaLista.adicionaNoFim("Rafael");
		minhaLista.inserirElementoEmPosicao("Marcelo", 1);
		minhaLista.inserirElementoEmPosicao("Abella", 2);
		
		Assert.assertEquals("[Davi, Marcelo, Abella, Rafael]", minhaLista.imprime());
	}
	
	@Test
	public void testConcatenarListas(){
		minhaLista.adicionaNoFim("Davi");
		minhaLista.adicionaNoFim("Marcelo");
		
		Object[] listaASomar = new Object[2];
		listaASomar[0] = "Abella";
		listaASomar[1] = "Rafael";
		
		minhaLista.concatenarListas(listaASomar);
		System.out.println(minhaLista.imprime());
		
		Assert.assertEquals("[Davi, Marcelo, Abella, Rafael]", minhaLista.imprime());
	}

}
