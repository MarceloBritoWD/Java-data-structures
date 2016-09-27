package testes;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import principal.ListaSequencial;



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
	public void test() {
		fail("Not yet implemented");
	}

}
