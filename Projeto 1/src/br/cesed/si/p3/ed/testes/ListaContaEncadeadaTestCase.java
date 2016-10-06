package br.cesed.si.p3.ed.testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.cesed.si.p3.ed.Conta;
import br.cesed.si.p3.ed.exceptions.operacaoInvalidaException;
import br.cesed.si.p3.ed.lista.ListaContaEncadeada;

public class ListaContaEncadeadaTestCase {
	
	ListaContaEncadeada testeLista;

	@Before
	public void setUp() throws Exception {
		testeLista = new ListaContaEncadeada();
	}

	@After
	public void tearDown() throws Exception {
		testeLista = null;
	}
	
	@Test
	public void testInserirContaNoInicio() throws operacaoInvalidaException {
		testeLista.inserirContaNoFim("Marcelo", 072, 1234);
		testeLista.inserirContaNoFim("Rafael", 072, 1234);
		testeLista.inserirContaNoFim("Davi", 072, 1234);
		testeLista.inserirContaNoInicio("Abella", 072, 1234);
		testeLista.inserirContaNoInicio("Ayrton", 072, 1234);
		
		Assert.assertEquals("Ayrton", testeLista.informarElementoDePosicao(0));
	}
	
	@Test
	public void testInserirContaNoFim() throws operacaoInvalidaException {
		testeLista.inserirContaNoFim("Marcelo", 072, 1234);
		testeLista.inserirContaNoFim("Marcio", 072, 1234);
		testeLista.inserirContaNoFim("Rafael", 072, 1234);
		testeLista.inserirContaNoFim("David", 072, 1234);
		
		Assert.assertEquals("David", testeLista.informarElementoDePosicao(3));
	}
	
	@Test
	public void testExcluirContaPorNome() throws operacaoInvalidaException {
		testeLista.inserirContaNoFim("Rafael", 072, 1234);
		testeLista.inserirContaNoFim("Davi", 072, 1234);
		testeLista.inserirContaNoInicio("Abella", 072, 1234);
		testeLista.inserirContaNoInicio("Ayrton", 072, 1234);
		
		testeLista.excluirContaPorNome("abella");
		Assert.assertEquals("Davi", testeLista.informarElementoDePosicao(2));
		
	}

	@Test
	public void testInformarTamanho() {
		testeLista.inserirContaNoFim("Rafael", 072, 1234);
		testeLista.inserirContaNoFim("Davi", 072, 1234);
		testeLista.inserirContaNoInicio("Abella", 072, 1234);
		testeLista.inserirContaNoInicio("Ayrton", 072, 1234);
		
		Assert.assertEquals(4, testeLista.informarTamanho());
	}
	
	
	@Test
	public void testInformarElementoDePosicao() throws operacaoInvalidaException {
		testeLista.inserirContaNoFim("Rafael", 072, 1234);
		testeLista.inserirContaNoFim("Davi", 072, 1234);
		testeLista.inserirContaNoFim("Abella", 072, 1234);
		testeLista.inserirContaNoFim("Ayrton", 072, 1234);
		
		Assert.assertEquals("Rafael",testeLista.informarElementoDePosicao(0));
		Assert.assertEquals("Abella",testeLista.informarElementoDePosicao(2));
	}
	
	@Test(expected=operacaoInvalidaException.class)
	public void testInformarElementoDePosicaoComException() throws operacaoInvalidaException {
		testeLista.inserirContaNoFim("Rafael", 072, 1234);
		testeLista.inserirContaNoFim("Davi", 072, 1234);
		testeLista.inserirContaNoFim("Abella", 072, 1234);
		testeLista.inserirContaNoFim("Ayrton", 072, 1234);
				
		Assert.assertEquals("Abella", testeLista.informarElementoDePosicao(8));
	}
	
	
	@Test
	public void testInformarPosicaoDeElementoPorNome() throws operacaoInvalidaException {
		testeLista.inserirContaNoFim("Rafael", 072, 1234);
		testeLista.inserirContaNoFim("Davi", 072, 1234);
		testeLista.inserirContaNoFim("Abella", 072, 1234);
		testeLista.inserirContaNoFim("Ayrton", 072, 1234);

		Assert.assertEquals(3,testeLista.informarPosicaoDeElementoPorNome("Ayrton"));
	}
	
	@Test(expected=operacaoInvalidaException.class)
	public void testInformarPosicaoDeElementoPorNomeComException() throws operacaoInvalidaException {
		testeLista.inserirContaNoFim("Rafael", 072, 1234);
		testeLista.inserirContaNoFim("Davi", 072, 1234);
		testeLista.inserirContaNoFim("Abella", 072, 1234);
		testeLista.inserirContaNoFim("Ayrton", 072, 1234);
		
		
		Assert.assertEquals(2,testeLista.informarPosicaoDeElementoPorNome("Marcelo"));
	}
	
	@Test
	public void testExcluirContaNoIndice() {
		testeLista.inserirContaNoFim("Rafael", 072, 1234);
		testeLista.inserirContaNoFim("Davi", 072, 1234);
		testeLista.inserirContaNoFim("Abella", 072, 1234);
		testeLista.inserirContaNoFim("Ayrton", 072, 1234);
		
		testeLista.excluirContaNoIndice(2);
		testeLista.excluirContaNoIndice(1);
		
		Assert.assertEquals(2, testeLista.informarTamanho());
	}
	
	
	@Test
	public void testInserirElementoEmPosicao() throws operacaoInvalidaException {
		testeLista.inserirContaNoFim("Abella", 072, 1234);
		testeLista.inserirContaNoFim("Davi", 072, 1234);
		testeLista.inserirContaNoFim("Ayrton", 072, 1234);		
		testeLista.inserirContaNoFim("Marcelo", 072, 1234);
		testeLista.inserirContaNoFim("Danielle", 072, 1234);
		
		Conta contaAnderson = new Conta("Anderson", 072, 1234);  
		
		testeLista.inserirContaEmPosicao(contaAnderson, 3);
		
		Assert.assertEquals("Anderson", testeLista.informarElementoDePosicao(3));
	}	
	
	
	@Test
	public void testConcatenarListasDeConta() throws operacaoInvalidaException {
		testeLista.inserirContaNoFim("Abella", 072, 1234);
		testeLista.inserirContaNoFim("Ayrton", 072, 1234);
		
		ListaContaEncadeada listaASomar = new ListaContaEncadeada();
		listaASomar.inserirContaNoFim("Marcelo", 014, 1523);
		listaASomar.inserirContaNoFim("Davi", 014, 1523);
		
		testeLista.concatenarListasDeConta(listaASomar);
		
		Assert.assertEquals("Abella", testeLista.informarElementoDePosicao(0));
		Assert.assertEquals("Davi", testeLista.informarElementoDePosicao(3));
	}	
}
