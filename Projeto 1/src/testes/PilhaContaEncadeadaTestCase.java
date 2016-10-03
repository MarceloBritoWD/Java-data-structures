package testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import principal.PilhaContaEncadeada;

public class PilhaContaEncadeadaTestCase {
	PilhaContaEncadeada testePilha;
	
	@Before
	public void setUp() throws Exception {
		testePilha = new PilhaContaEncadeada();
	}

	@After
	public void tearDown() throws Exception {
		testePilha = null;
	}

	@Test
	public void testEmpilharConta() {
		testePilha.empilharConta("Abella", 65465, 46484);		
		Assert.assertEquals(false, testePilha.pilhaIsVazia());
	}

	@Test
	public void testDesempilharConta() {
		testePilha.empilharConta("Abella", 65465, 46484);
		testePilha.empilharConta("Marcelo", 5414, 02202);
		testePilha.desempilharConta();
		testePilha.desempilharConta();
		Assert.assertEquals(true, testePilha.pilhaIsVazia());
	}
	
	@Test
	public void testConsultarTopo() {
		testePilha.empilharConta("Abella", 65465, 46484);
		testePilha.empilharConta("Marcelo", 5414, 02202);
		testePilha.empilharConta("Davi", 05151, 51888);
		testePilha.empilharConta("Rafael", 05152, 84681);
		
		Assert.assertEquals("Rafael", testePilha.consultarTopo());
	}
	
	@Test
	public void testInformarTamanho() {
		testePilha.empilharConta("Abella", 65465, 46484);
		testePilha.empilharConta("Marcelo", 5414, 02202);
		testePilha.empilharConta("Davi", 05151, 51888);
		
		Assert.assertEquals(3, testePilha.informarTamanho());
	}
	
	@Test
	public void testPilhaIsVazia() {
		Assert.assertEquals(true, testePilha.pilhaIsVazia());
		testePilha.empilharConta("Abella", 65465, 46484);
		Assert.assertEquals(false, testePilha.pilhaIsVazia());		
	}

}
