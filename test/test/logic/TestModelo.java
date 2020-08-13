package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo 
{
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() 
	{
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() 
	{
		for(int i =0; i< CAPACIDAD;i++)
		{
			modelo.agregar(i);
		}
	}

	@Test
	public void testModelo() 
	{
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() 
	{
		setUp1();
		assertTrue( modelo.darTamano() == 0 );
		
		setUp2();
		assertTrue( modelo.darTamano() == 100 );
	}

	@Test
	public void testAgregar() 
	{
		setUp1();
		modelo.agregar( 322 );
		assertTrue( modelo.darTamano() == 1 && modelo.buscar( 322 ) == 322);
	}

	@Test
	public void testBuscar() 
	{
		setUp1();
		
		assertTrue( modelo.buscar( 1 ) == null);
		
		setUp2();
		
		assertTrue( modelo.buscar( 55 ) == 55);
		assertTrue( modelo.buscar( 1 ) == 1);
		assertTrue( modelo.buscar( -1 ) == null);
		
	}

	@Test
	public void testEliminar() 
	{
		setUp2();
		
		assertTrue( modelo.eliminar( 108 ) == null );
		assertTrue( modelo.buscar( 108 ) == null );
		
		assertTrue( modelo.eliminar( 28 ) == 28 );
		assertTrue( modelo.buscar( 28 ) == null );
		
	}

}
