package br.facisa.p3.ed.projeto1.teste;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.facisa.p3.ed.projeto1.encadeada.FilaEncadeada;
import br.facisa.p3.ed.projeto1.sequencial.FilaSequencial;

public class TestFilaEncadeada {
	FilaEncadeada queue;
	@Before
	public void setUp() throws Exception {
		queue = new FilaEncadeada();
	}

	@After
	public void tearDown() throws Exception {
		queue = null;
	}

	@Test
	public void testEmpty(){
		Assert.assertEquals(true, queue.isEmpty());
		queue.enqueue("item1");
		Assert.assertEquals(false, queue.isEmpty());
	}
	
	@Test
	public void testPeek(){
		queue.enqueue("item1");
		queue.enqueue("item2");
		Assert.assertEquals("item1", queue.peek());
	}
	
	@Test
	public void testDequeue(){
		queue.enqueue("item1");
		queue.enqueue("item2");
		Object a = queue.dequeue();
		Assert.assertEquals("item1", a);
		Assert.assertEquals("item2", queue.peek());
	}

}
