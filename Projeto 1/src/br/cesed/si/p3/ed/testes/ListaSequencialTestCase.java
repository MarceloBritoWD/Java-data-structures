package br.cesed.si.p3.ed.testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.cesed.si.p3.ed.exceptions.operacaoInvalidaException;
import br.cesed.si.p3.ed.lista.ListaSequencial;

import org.junit.Assert;

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
	public void testAdicionarNoInicio() {
		minhaLista.adicionarNoFim("Marcelo");
		minhaLista.adicionarNoFim("Davi");
		minhaLista.adicionarNoFim("Rafael");
		minhaLista.adicionarNoInicio("Abella");
		
		Assert.assertEquals("[Abella, Marcelo, Davi, Rafael]", minhaLista.imprimirItens());
	}
	
	@Test
	public void testAdicionarNoFim() {
		minhaLista.adicionarNoFim("Marcelo");
		minhaLista.adicionarNoFim("Davi");
		minhaLista.adicionarNoFim("Rafael");
		
		Assert.assertEquals("[Marcelo, Davi, Rafael]", minhaLista.imprimirItens());
	}
	
	@Test
	public void testExcluirPorIndice() {
		minhaLista.adicionarNoFim("Marcelo");
		minhaLista.adicionarNoFim("Davi");
		minhaLista.adicionarNoFim("Rafael");
		minhaLista.excluirPorIndice(1);

		Assert.assertEquals("[Marcelo, Rafael]", minhaLista.imprimirItens());
	}
	
	@Test
	public void testExcluirPorValor() {
		minhaLista.adicionarNoFim("Marcelo");
		minhaLista.adicionarNoFim("Davi");
		minhaLista.adicionarNoFim("Rafael");
		minhaLista.adicionarNoInicio("Abella");
		minhaLista.adicionarNoInicio("David");
		
		minhaLista.excluirPorValor("David");
		minhaLista.excluirPorValor("Rafael");
		
		Assert.assertEquals("[Abella, Marcelo, Davi]", minhaLista.imprimirItens());
	}
	
	@Test
	public void testInformarTamanho() {
		minhaLista.adicionarNoFim("Marcelo");
		minhaLista.adicionarNoFim("Davi");
		minhaLista.adicionarNoFim("Rafael");
		minhaLista.adicionarNoInicio("Abella");
		minhaLista.adicionarNoInicio("David");
		minhaLista.excluirPorValor("David");
		
		Assert.assertEquals(4, minhaLista.informarTamanho());
	}
	
	@Test
	public void testItemDePosicao() throws operacaoInvalidaException {
		minhaLista.adicionarNoFim("Marcelo");
		minhaLista.adicionarNoFim("Davi");
		minhaLista.adicionarNoFim("Rafael");
		minhaLista.adicionarNoInicio("Abella");
		minhaLista.adicionarNoInicio("David");
		
		Assert.assertEquals("Abella", minhaLista.itemDePosicao(1));	
	}
	
	@Test(expected=operacaoInvalidaException.class)
	public void testItemDePosicaoComException() throws operacaoInvalidaException {
		minhaLista.adicionarNoFim("Marcelo");
		
		Assert.assertEquals("Abella", minhaLista.itemDePosicao(8));	
	}
	
	@Test
	public void testPosicaoDeItem() throws operacaoInvalidaException {
		minhaLista.adicionarNoFim("Marcelo");
		minhaLista.adicionarNoFim("Davi");
		minhaLista.adicionarNoFim("Rafael");
		minhaLista.adicionarNoInicio("Abella");
		minhaLista.adicionarNoInicio("David");
		
		Assert.assertEquals(2, minhaLista.posicaoDeItem("Marcelo"));
	}
	
	@Test(expected=operacaoInvalidaException.class)
	public void testPosicaoDeItemComException() throws operacaoInvalidaException {
		minhaLista.adicionarNoFim("Davi");
		minhaLista.adicionarNoFim("Rafael");
		
		Assert.assertEquals(0, minhaLista.posicaoDeItem("Marcelo"));
	}
	
	@Test
	public void testInserirElementoEmPosicao(){
		minhaLista.adicionarNoFim("Davi");
		minhaLista.adicionarNoFim("Rafael");
		minhaLista.inserirElementoEmPosicao("Marcelo", 1);
		minhaLista.inserirElementoEmPosicao("Abella", 2);
		
		Assert.assertEquals("[Davi, Marcelo, Abella, Rafael]", minhaLista.imprimirItens());
	}
	
	@Test
	public void testConcatenarListas(){
		minhaLista.adicionarNoFim("Davi");
		minhaLista.adicionarNoFim("Marcelo");
		
		Object[] listaASomar = new Object[2];
		listaASomar[0] = "Abella";
		listaASomar[1] = "Rafael";
		
		minhaLista.concatenarListas(listaASomar);
		
		Assert.assertEquals("[Davi, Marcelo, Abella, Rafael]", minhaLista.imprimirItens());
	}

}
