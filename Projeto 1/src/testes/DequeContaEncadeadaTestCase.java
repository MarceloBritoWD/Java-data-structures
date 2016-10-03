package testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import principal.DequeContaEncadeada;

public class DequeContaEncadeadaTestCase {
	
	DequeContaEncadeada testeDeque;
	
	@Before
	public void setUp() throws Exception {
		testeDeque = new DequeContaEncadeada();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDequeIsVazio() {
		testeDeque.adicionarContaNoInicio("Marcelo", 544, 4449);
		Assert.assertEquals(false, testeDeque.dequeIsVazio());
		
		testeDeque.removerPrimeiraConta();
		Assert.assertEquals(true, testeDeque.dequeIsVazio());
	}	
	
	@Test
	public void testGetPrimeiraConta() {
		testeDeque.adicionarContaNoInicio("Marcelo", 544, 4449);
		testeDeque.adicionarContaNoFim("Abella", 544, 4449);
		
		Assert.assertEquals("Marcelo", testeDeque.getPrimeiraConta());
	}
	
	@Test
	public void testGetUltimaConta() {
		testeDeque.adicionarContaNoInicio("Marcelo", 544, 4449);
		testeDeque.adicionarContaNoFim("Abella", 544, 4449);
		testeDeque.adicionarContaNoFim("Ayrton", 544, 4449);
		
		Assert.assertEquals("Ayrton", testeDeque.getUltimaConta());
	}
	
	
	
	@Test
	public void testAdicionarContaNoInicio() {
		testeDeque.adicionarContaNoInicio("Marcelo", 544, 4449);
		testeDeque.adicionarContaNoFim("Abella", 544, 4449);
		testeDeque.adicionarContaNoInicio("Rafael", 544, 4449);
		
		Assert.assertEquals("Rafael", testeDeque.getPrimeiraConta());
	}
	
	@Test
	public void testAdicionarContaNoFim() {
		testeDeque.adicionarContaNoInicio("Marcelo", 544, 4449);
		testeDeque.adicionarContaNoFim("Abella", 544, 4449);
		testeDeque.adicionarContaNoInicio("Rafael", 544, 4449);
		
		Assert.assertEquals("Abella", testeDeque.getUltimaConta());
	}
	
	@Test
	public void testRemoverPrimeiraConta() {
		testeDeque.adicionarContaNoInicio("Marcelo", 544, 4449);
		testeDeque.adicionarContaNoFim("Abella", 544, 4449);
		testeDeque.adicionarContaNoInicio("Rafael", 544, 4449);
		
		Assert.assertEquals("Rafael", testeDeque.getPrimeiraConta());
		testeDeque.removerPrimeiraConta();
		Assert.assertEquals("Marcelo", testeDeque.getPrimeiraConta());
	}
	
	@Test
	public void testRemoverUltimaConta() {
		testeDeque.adicionarContaNoInicio("Marcelo", 544, 4449);
		testeDeque.adicionarContaNoFim("Abella", 544, 4449);
		testeDeque.adicionarContaNoInicio("Rafael", 544, 4449);
		
		testeDeque.removerUltimaConta();
		Assert.assertEquals("Marcelo", testeDeque.getUltimaConta());
	}
	
	
	@Test
	public void testConcatenarListasDeConta() {
		testeDeque.adicionarContaNoFim("Abella", 072, 1234);
		testeDeque.adicionarContaNoFim("Ayrton", 072, 1234);
		
		DequeContaEncadeada dequeASomar = new DequeContaEncadeada();
		dequeASomar.adicionarContaNoFim("Marcelo", 014, 1523);
		dequeASomar.adicionarContaNoInicio("Davi", 014, 1523);
		
		testeDeque.concatenarDequesDeConta(dequeASomar);
		
		Assert.assertEquals("Abella", testeDeque.getPrimeiraConta());
		Assert.assertEquals("Marcelo", testeDeque.getUltimaConta());
	}
}
