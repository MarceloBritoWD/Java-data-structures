package br.facisa.p3.ed.projeto1.teste;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.facisa.p3.ed.projeto1.encadeada.PilhaEncadeada;

public class TestPilhaEncadeada {
	PilhaEncadeada stack;
	@Before
	public void setUp()  {
		stack = new PilhaEncadeada();
	}

	@After
	public void tearDown() {
		stack = null;
	}

	@Test
	public void testPush(){
		stack.push("item1");
		stack.push("item2");
		Assert.assertEquals("item2", stack.peek());
	}
	
	public void testPop(){
		stack.push(1);
		stack.push(2);
		stack.push(3);
		Assert.assertEquals(3, stack.peek());
		stack.pop();
		Assert.assertEquals(2, stack.peek());
	}
	
	public void testSize(){
		stack.push(1);
		stack.push(2);
		stack.push(3);
		Assert.assertEquals(3, stack.size());
	}
	
	public void testIsEmpty(){
		Assert.assertEquals(true, stack.isEmpty());
		stack.push(1);
		Assert.assertEquals(false, stack.isEmpty());
	}
	
	public void testIsFull(){
		Assert.assertEquals(false, stack.isFull());
		stack.push(1);
		Assert.assertEquals(true, stack.isFull());
	}
}
