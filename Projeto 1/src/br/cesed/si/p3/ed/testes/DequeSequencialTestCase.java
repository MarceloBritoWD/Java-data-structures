package br.cesed.si.p3.ed.testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.cesed.si.p3.ed.deque.DequeSequencial;
import br.cesed.si.p3.ed.exceptions.dequeVazioException;

import org.junit.Assert;

public class DequeSequencialTestCase {
	DequeSequencial testeDeque;

	@Before
	public void setUp() throws Exception {
		testeDeque = new DequeSequencial();
	}

	@After
	public void tearDown() throws Exception {
		testeDeque = null;
	}

	@Test
	public void testDequeIsVazioTrue() {
		Assert.assertEquals(true, testeDeque.dequeIsVazio());		
	}
	
	@Test
	public void testDequeIsVazioFalse() {
		testeDeque.adicionarNoInicio("Marcelo");
		
		Assert.assertEquals(false, testeDeque.dequeIsVazio());		
	}
	
	@Test
	public void testGetPrimeiroItem() throws dequeVazioException {
		testeDeque.adicionarNoInicio("Marcelo");
		testeDeque.adicionarNoInicio("Davi");
		testeDeque.adicionarNoInicio("Rafael");
		
		Assert.assertEquals("Rafael", testeDeque.getPrimeiroItem());		
	}
	
	@Test
	public void testGetUltimoItem() throws dequeVazioException {
		testeDeque.adicionarNoInicio("Marcelo");
		testeDeque.adicionarNoInicio("Davi");
		testeDeque.adicionarNoInicio("Rafael");
		
		Assert.assertEquals("Marcelo", testeDeque.getUltimoItem());
	}
	
	@Test
	public void testAdicionaNoInicio() throws dequeVazioException {
		testeDeque.adicionarNoFim("Marcelo");
		testeDeque.adicionarNoFim("Davi");
		testeDeque.adicionarNoFim("Rafael");
		testeDeque.adicionarNoInicio("Abella");
		
		Assert.assertEquals("Abella", testeDeque.getPrimeiroItem());
	}
	
	@Test
	public void testAdicionaNoFim() throws dequeVazioException {
		testeDeque.adicionarNoFim("Marcelo");
		testeDeque.adicionarNoFim("Davi");
		testeDeque.adicionarNoFim("Rafael");
		testeDeque.adicionarNoInicio("Abella");
		
		Assert.assertEquals("Rafael", testeDeque.getUltimoItem());
	}
		
	@Test
	public void testRemoverPrimeiroItem(){
		testeDeque.adicionarNoFim("Marcelo");
		testeDeque.adicionarNoFim("Davi");
		testeDeque.adicionarNoFim("Rafael");
		
		testeDeque.removerPrimeiroItem();
		
		Assert.assertEquals("[Davi, Rafael]", testeDeque.imprimirDeque());
	}	
	
	@Test
	public void testRemoverUltimoItem(){
		testeDeque.adicionarNoFim("Marcelo");
		testeDeque.adicionarNoFim("Davi");
		testeDeque.adicionarNoFim("Rafael");
		testeDeque.adicionarNoInicio("Abella");
		testeDeque.adicionarNoInicio("Ayrton");
		
		testeDeque.removerUltimoItem();
		
		Assert.assertEquals("[Ayrton, Abella, Marcelo, Davi]", testeDeque.imprimirDeque());
	}	
	
	
	@Test
	public void testConcatenarDeques(){
		testeDeque.adicionarNoFim("Anderson");
		testeDeque.adicionarNoFim("Ayrton");
		
		Object[] dequeASomar = new Object[2];
		dequeASomar[0] = "Danielle";
		dequeASomar[1] = "Abella";
		
		testeDeque.concatenarDeques(dequeASomar);
		
		Assert.assertEquals("[Anderson, Ayrton, Danielle, Abella]", testeDeque.imprimirDeque());
	}
}
