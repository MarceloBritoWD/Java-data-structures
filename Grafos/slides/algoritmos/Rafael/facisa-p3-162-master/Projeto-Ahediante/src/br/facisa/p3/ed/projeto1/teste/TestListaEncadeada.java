package br.facisa.p3.ed.projeto1.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.facisa.p3.ed.projeto1.encadeada.ListaEncadeada;

public class TestListaEncadeada {
	
	ListaEncadeada list;
	
	@Before
	public void setUp(){
		list = new ListaEncadeada();
	}

	@After
	public void tearDown(){
		list = null;
	}
	
	@Test
	public void testAppend(){
		list.append("item1");
		list.append("item2");
		list.append("item3");
		list.append("item4");
		Assert.assertEquals("item3", list.getElement(2));
		list.append("item5");
		Assert.assertEquals("item4", list.getElement(3));
		Assert.assertEquals("item5", list.getElement(4));
	}
	
	@Test
	public void testAppednLeft(){
		list.append("2");
		list.append("3");
		list.append("4");
		list.appendLeft("1");
		Assert.assertEquals("1", list.getElement(0));
		Assert.assertEquals("2", list.getElement(1));
		Assert.assertEquals("4", list.getElement(3));
	}
	
	@Test
	public void testInsert(){
		list.append("2");
		list.append("4");
		list.append("5");
		list.insert("1", 0);
		list.insert("3", 2);
		Assert.assertEquals("1", list.getElement(0));
		Assert.assertEquals("2", list.getElement(1));
		Assert.assertEquals("3", list.getElement(2));
		Assert.assertEquals("4", list.getElement(3));
		Assert.assertEquals("5", list.getElement(4));
	}
	
	@Test
	public void testRemove(){
		list.append("item1");
		list.append("item2");
		list.append("item3");
		list.append("item4");
		//for (int i = 0; i < 4; i++){
		//	System.out.println(list.getElement(i));
		//}
		list.remove("item1");
		Assert.assertEquals("item2", list.getElement(0));
		list.remove("item4");
		Assert.assertEquals("item3", list.getElement(1));
		
	}
	
	@Test
	public void TestIndexRemove(){
		list.append("item1");
		list.append("item2");
		list.append("item3");
		list.append("item4");
		list.IndexRemove(0);
		Assert.assertEquals("item2", list.getElement(0));
		Assert.assertEquals("item3", list.getElement(1));
		list.IndexRemove(2);
		Assert.assertEquals("item3", list.getElement(1));
		
	}
	
	public void TestSize(){
		list.append("item1");
		list.append("item2");
		list.append("item3");
		list.append("item4");
		Assert.assertEquals(4, list.size());
		list.appendLeft("item0");
		list.insert("item5", 5);
		Assert.assertEquals(6, list.size());
	}
	
	@Test
	public void TestJoinList(){
		list.append("item1");
		list.append("item2");
		list.append("item3");
		list.append("item4");
		ListaEncadeada list2 = new ListaEncadeada();
		list2.append("item5");
		list2.append("item6");
		list.joinList(list2);
		//for (int i = 0; i < 6; i++){
		//	System.out.println(list.getElement(i)");
		//}
		Assert.assertEquals("item4", list.getElement(3));
		Assert.assertEquals("item6", list.getElement(5));
		
	}
	
	@Test
	public void TestGetIndesElement(){
		list.append("item1");
		list.append("item2");
		list.append("item3");
		list.append("item4");
		Assert.assertEquals(0, list.getIndexElement("item1"));
		Assert.assertEquals(3, list.getIndexElement("item4"));
	}
	

}
