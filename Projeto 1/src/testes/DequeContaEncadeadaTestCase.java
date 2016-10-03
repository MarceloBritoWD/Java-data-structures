package testes;

import static org.junit.Assert.fail;

import org.junit.After;
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
	public void test() {
		fail("Not yet implemented");
	}

}
