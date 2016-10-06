package br.cesed.si.p3.ed.testes;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.cesed.si.p3.ed.exceptions.filaVaziaException;
import br.cesed.si.p3.ed.fila.FilaSequencial;

public class FilaSequencialTestCase {
	
	FilaSequencial testeFila;

	@Before
	public void setUp() throws Exception {
		testeFila = new FilaSequencial();
	}

	@After
	public void tearDown() throws Exception {
		testeFila = null;
	}
	

	@Test
	public void testFilaIsVazia() {		
		Assert.assertEquals(true, testeFila.filaIsVazia());
	}
	
	@Test
	public void testFilaIsVaziaFalse() {		
		testeFila.inserirItem("Marcelo");
		Assert.assertEquals(false, testeFila.filaIsVazia());
	}
	
	@Test
	public void testGetPrimeiroItem() throws filaVaziaException {
		testeFila.inserirItem("Marcelo");
		testeFila.inserirItem("Brito");
		Assert.assertEquals("Marcelo", testeFila.getPrimeiroItem());
	}
	
	@Test(expected=filaVaziaException.class)
	public void testGetPrimeiroItemComErro() throws filaVaziaException {
		Assert.assertEquals("Marcelo", testeFila.getPrimeiroItem());
	}
	
	@Test
	public void testInserirItem() {
		testeFila.inserirItem("Marcelo");		
		Assert.assertEquals(false, testeFila.filaIsVazia());
	}
	
	@Test
	public void testRemoverItem() throws filaVaziaException{
		testeFila.inserirItem("Ayrton");
		testeFila.inserirItem("Anderson");
		testeFila.inserirItem("Danielle");
		testeFila.inserirItem("Marcelo");
		testeFila.inserirItem("Davi");
	
		testeFila.removerItem();
		testeFila.removerItem();
		testeFila.removerItem();

		Assert.assertEquals("Marcelo", testeFila.removerItem());
		Assert.assertEquals("Davi", testeFila.getPrimeiroItem());
		
	}
	
	
}