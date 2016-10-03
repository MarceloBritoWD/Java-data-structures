package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import principal.DequeSequencial;
import principal.dequeVazioException;

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
		testeDeque.adicionaNoInicio("Marcelo");
		
		Assert.assertEquals(false, testeDeque.dequeIsVazio());		
	}
	
	@Test
	public void testGetPrimeiroElemento() throws dequeVazioException {
		testeDeque.adicionaNoInicio("Marcelo");
		testeDeque.adicionaNoInicio("Davi");
		testeDeque.adicionaNoInicio("Rafael");
		
		Assert.assertEquals("Rafael", testeDeque.getPrimeiroElemento());		
	}
	
	@Test
	public void testGetUltimoElemento() throws dequeVazioException {
		testeDeque.adicionaNoInicio("Marcelo");
		testeDeque.adicionaNoInicio("Davi");
		testeDeque.adicionaNoInicio("Rafael");
		
		Assert.assertEquals("Marcelo", testeDeque.getUltimoElemento());
	}
	
	@Test
	public void testAdicionaNoInicio() throws dequeVazioException {
		testeDeque.adicionaNoFim("Marcelo");
		testeDeque.adicionaNoFim("Davi");
		testeDeque.adicionaNoFim("Rafael");
		testeDeque.adicionaNoInicio("Abella");
		
		Assert.assertEquals("Abella", testeDeque.getPrimeiroElemento());
	}
	
	@Test
	public void testAdicionaNoFim() throws dequeVazioException {
		testeDeque.adicionaNoFim("Marcelo");
		testeDeque.adicionaNoFim("Davi");
		testeDeque.adicionaNoFim("Rafael");
		testeDeque.adicionaNoInicio("Abella");
		
		Assert.assertEquals("Rafael", testeDeque.getUltimoElemento());
	}
		
	@Test
	public void testRemoverPrimeiroElemento(){
		testeDeque.adicionaNoFim("Marcelo");
		testeDeque.adicionaNoFim("Davi");
		testeDeque.adicionaNoFim("Rafael");
		
		testeDeque.removerPrimeiroElemento();
//		System.out.println(testeDeque.imprime());
		
		Assert.assertEquals("[Davi, Rafael]", testeDeque.imprime());
	}	
	
	@Test
	public void testRemoverUltimoElemento(){
		testeDeque.adicionaNoFim("Marcelo");
		testeDeque.adicionaNoFim("Davi");
		testeDeque.adicionaNoFim("Rafael");
		testeDeque.adicionaNoInicio("Abella");
		testeDeque.adicionaNoInicio("Ayrton");
		
		testeDeque.removerUltimoElemento();
//		System.out.println(testeDeque.imprime());
		
		Assert.assertEquals("[Ayrton, Abella, Marcelo, Davi]", testeDeque.imprime());
	}	
	
	
	@Test
	public void testConcatenarDeques(){
		testeDeque.adicionaNoFim("Anderson");
		testeDeque.adicionaNoFim("Ayrton");
		
		Object[] dequeASomar = new Object[2];
		dequeASomar[0] = "Danielle";
		dequeASomar[1] = "Abella";
		
		testeDeque.concatenarDeques(dequeASomar);
//		System.out.println(testeDeque.imprime());
		
		Assert.assertEquals("[Anderson, Ayrton, Danielle, Abella]", testeDeque.imprime());
	}
}
