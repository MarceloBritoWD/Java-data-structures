package br.facisa.p3.ed.projeto1.teste;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.facisa.p3.ed.projeto1.encadeada.DequeEncadeada;
import br.facisa.p3.ed.projeto1.sequencial.DequeSequencial;

public class TestDequeEncadeada {
	DequeEncadeada dqueue;
	@Before
	public void setUp() {
		dqueue = new DequeEncadeada();
	}

	@After
	public void tearDown() {
		dqueue = null;
	}

	@Test
	public void testIsEmpty(){
		Assert.assertEquals(true, dqueue.isEmpty());
		dqueue.insertFront("item1");
		Assert.assertEquals(false, dqueue.isEmpty());	
	}
	
	@Test
	public void testInsert(){
		dqueue.insertFront("item1");
		dqueue.insertRear("item2");
		dqueue.insertFront("item0");
		Assert.assertEquals("item0", dqueue.getFront());
		Assert.assertEquals("item2", dqueue.getRear());
	}
	
	@Test
	public void testRemove(){
		dqueue.insertFront("item1");
		dqueue.insertRear("item2");
		dqueue.insertFront("item0");
		dqueue.insertRear("item4");
		dqueue.removeFront();
		Assert.assertEquals("item1", dqueue.getFront());
		dqueue.removeRear();
		Assert.assertEquals("item2", dqueue.getRear());
	}
	
	@Test
	public void joinDequeue(){
		dqueue.insertFront("item2");
		dqueue.insertRear("item3");
		DequeEncadeada dqueue2 = new DequeEncadeada();
		dqueue2.insertFront("item1");
		dqueue2.insertRear("item4");
		dqueue.joinDequeue(dqueue2);
		Assert.assertEquals("item1", dqueue.getFront());
		Assert.assertEquals("item4", dqueue.getRear());
	}

}
