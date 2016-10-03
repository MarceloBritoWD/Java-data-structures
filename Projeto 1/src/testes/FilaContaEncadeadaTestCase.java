package testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import principal.FilaContaEncadeada;

public class FilaContaEncadeadaTestCase {
	
	FilaContaEncadeada testeFila;
	
	@Before
	public void setUp() throws Exception {
		testeFila = new FilaContaEncadeada();
	}

	@After
	public void tearDown() throws Exception {
		testeFila = null;
	}

	@Test
	public void testInserirConta() {
		testeFila.inserirConta("Marcelo", 652, 8494);
		testeFila.inserirConta("Davi", 652, 8494);
		testeFila.inserirConta("Rafael", 652, 8494);
		
		Assert.assertEquals("Marcelo", testeFila.getPrimeiraConta());
	}
	
	
	@Test
	public void testRemoverConta() {
		testeFila.inserirConta("Marcelo", 652, 8494);
		testeFila.inserirConta("Davi", 652, 8494);
		testeFila.inserirConta("Rafael", 652, 8494);
				
		Assert.assertEquals("Marcelo", testeFila.removerConta());
		Assert.assertEquals("Davi", testeFila.removerConta());
	}
	
	@Test
	public void testGetPrimeiraConta() {
		testeFila.inserirConta("Abella", 652, 8494);
		testeFila.inserirConta("Rafael", 652, 8494);
		testeFila.inserirConta("Marcelo", 652, 8494);
		testeFila.inserirConta("Davi", 652, 8494);		
		
		Assert.assertEquals("Abella", testeFila.getPrimeiraConta());
	}
	
	@Test
	public void testFilaIsVazia() {
		testeFila.inserirConta("Abella", 652, 8494);
		Assert.assertEquals(false, testeFila.filaIsVazia());
		
		testeFila.removerConta();
		Assert.assertEquals(true, testeFila.filaIsVazia());		
	}

}
