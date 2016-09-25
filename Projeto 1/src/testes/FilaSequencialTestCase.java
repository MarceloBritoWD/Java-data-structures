package testes;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import principal.FilaSequencial;
import principal.filaVaziaException;

public class FilaSequencialTestCase {
	
	FilaSequencial minhaFila = new FilaSequencial();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	

	@Test
	public void testFilaIsVazia() {		
		Assert.assertEquals(true, minhaFila.filaIsVazia());
	}
	
	@Test
	public void testGetPrimeiroElemento() throws filaVaziaException {
		minhaFila.inserirItem("Marcelo");
		minhaFila.inserirItem("Brito");
		Assert.assertEquals("Marcelo", minhaFila.getPrimeiroElemento());
	}
	
	@Test(expected=filaVaziaException.class)
	public void testGetPrimeiroElementoComErro() throws filaVaziaException {
		Assert.assertEquals("Marcelo", minhaFila.getPrimeiroElemento());
	}
	
	@Test
	public void testInserirItem() {
		minhaFila.inserirItem("Marcelo");		
		Assert.assertEquals(false, minhaFila.filaIsVazia());
	}
	
	@Test
	public void testRemoverItem() throws filaVaziaException{
		minhaFila.inserirItem("Ayrton");
		minhaFila.inserirItem("Anderson");
		minhaFila.inserirItem("Danielle");
		minhaFila.inserirItem("Marcelo");
		minhaFila.inserirItem("Davi");
	
		minhaFila.removerItem();
		minhaFila.removerItem();
		minhaFila.removerItem();
		minhaFila.removerItem();

		Assert.assertEquals("Davi", minhaFila.getPrimeiroElemento());		
	}
	
	
}
