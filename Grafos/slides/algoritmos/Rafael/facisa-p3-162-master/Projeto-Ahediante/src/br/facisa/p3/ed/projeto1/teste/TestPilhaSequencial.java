package br.facisa.p3.ed.projeto1.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.facisa.p3.ed.projeto1.sequencial.PilhaSequencial;

public class TestPilhaSequencial {
	
	PilhaSequencial stack;
	
	@Before
	public void setUp() throws Exception {
		stack = new PilhaSequencial();
	}

	@After
	public void tearDown() throws Exception {
		stack = null;
	}

	@Test
	public void testPush(){
		
		stack.push("item1");
		stack.push("item2");
		stack.push("item3");
		stack.push("item4");
		Assert.assertEquals("item4", stack.peek());
		stack.pop();
		stack.pop();
		Assert.assertEquals("item2", stack.peek());
	}
	
	@Test
	public void testSize(){
		stack.push("item1");
		stack.push("item2");
		stack.push("item3");
		stack.push("item4");
		Assert.assertEquals(4, stack.size());
	}
	
	@Test
	public void testEmpty(){
		Assert.assertEquals(true, stack.isEmpty());
		stack.push("davi");
		Assert.assertEquals(false, stack.isEmpty());
	}

}
