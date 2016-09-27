package testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import principal.PilhaSequencial;
import principal.pilhaIsVaziaException;

public class PilhaSequencialTestCase {
	PilhaSequencial testePilha;

	@Before
	public void setUp() throws Exception {
		testePilha = new PilhaSequencial();
	}

	@After
	public void tearDown() throws Exception {
		testePilha = null;
	}

	@Test
	public void testEmpilhar() {
		testePilha.empilhar("Marcelo");
		testePilha.empilhar("Rafael");
		testePilha.empilhar("Davi");
		
		System.out.println(testePilha.toString());
		Assert.assertEquals("Davi", testePilha.consultarTopo());
	}
	
	@Test
	public void testDesempilhar() throws pilhaIsVaziaException {
		testePilha.empilhar("Marcelo");
		testePilha.empilhar("Rafael");
		testePilha.empilhar("Davi");
		testePilha.desempilhar();
		testePilha.desempilhar();
		
		Assert.assertEquals("Marcelo", testePilha.consultarTopo());
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testDesempilharComException() throws ArrayIndexOutOfBoundsException {
		testePilha.desempilhar();
	}
	
	
	
	@Test
	public void testTamanhoPilha() {
		testePilha.empilhar("Marcelo");
		testePilha.empilhar("Rafael");
		
		Assert.assertEquals(2, testePilha.tamanhoPilha());
	}	
	
	@Test
	public void testPilhaIsVazia() {
		testePilha.empilhar("Rafael");
		
		Assert.assertEquals(false, testePilha.pilhaIsVazia());
	}

}
