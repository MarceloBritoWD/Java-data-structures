package br.facisa.p3.ed.projeto1.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.facisa.p3.ed.projeto1.sequencial.ListaSequencial;

public class TestListaSequencial {
	
	ListaSequencial list;
	
	@Before
	public void setUp(){
		list = new ListaSequencial();
	}

	@After
	public void tearDown(){
		list = null;
	}
	
	@Test
	public void testAppend() {
		list.append("Abella");
		list.append("Rohit");
		list.append("Love <3");
		Assert.assertEquals(list.getElement(1), "Rohit");
		Assert.assertEquals(list.getElement(2), "Love <3");
	}
	
	@Test
	public void testAppendLeft(){
		list.append("Leandro");
		list.append("Marcelo");
		list.append("Fim");
		list.appendLeft("Inicio");
		Assert.assertEquals(list.getElement(0), "Inicio");
		Assert.assertEquals(list.getElement(3), "Fim");
		Assert.assertEquals(list.getElement(1), "Leandro");
	}
	
	@Test
	public void testSize(){
		list.append("Abella");
		list.append("Rohit");
		list.append("Love <3");
		Assert.assertEquals(list.size(), 3);
	}
	
	@Test
	public void testInsert(){
		list.append("item1");
		list.append("item2");
		list.append("item3");
		list.insert(0, "inicio");
		list.insert(60, "fim");
		list.insert(88, "fim2");
		list.insert(1, "item0");
		Assert.assertEquals(list.getElement(0), "inicio");
		Assert.assertEquals(list.getElement(2), "item1");
		Assert.assertEquals(list.getElement(5), "fim");
		Assert.assertEquals(list.getElement(1), "item0");
	}
	
	@Test
	public void testGetIndexElement(){
		list.append("item1");
		list.appendLeft("Inicio");
		list.insert(2, "FIm");
		Assert.assertEquals(list.getIndexElement("item1"), 1);
	}
	
	@Test
	public void testRemove(){
		list.append("item1");
		list.append("item2");
		list.append("item3");
		list.insert(0, "inicio");
		list.insert(60, "fim");
		list.insert(88, "fim2");
		list.remove("inicio");
		list.remove("fim");
		list.remove("fim2");
		Assert.assertEquals(list.getElement(0), "item1");
		Assert.assertEquals(list.getIndexElement("item2"), 1);
	}
	
	@Test
	public void indexRemove(){
		list.append("item1");
		list.append("item2");
		list.append("item3");
		list.indexRemove(0);
		list.indexRemove(2);
		Assert.assertEquals(list.getElement(0), "item2");
	}
	
	@Test
	public void expandList(){
		list.append("1");
		list.append("2");
		list.append("3");
		list.append("4");
		list.append("5");
		list.append("6");
	}
	
	@Test
	public void joinList(){
		ListaSequencial list2 = new ListaSequencial();
		list.append("item1");
		list.append("item2");
		list2.append("item3");
		list2.append("item4");
		list.joinLists(list2);
		Assert.assertEquals(list.getElement(0), "item1");
		Assert.assertEquals(list.getElement(2), "item3");
		Assert.assertEquals(list.getElement(3), "item4");
	}
	
}
