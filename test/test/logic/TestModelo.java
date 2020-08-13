package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo 
{
	/**
	 * Representa el modelo
	 */
	private Modelo modelo;
	
	/**
	 * Cantidad entera que representa la capacidad del arreglo
	 */
	private static int CAPACIDAD=100;
	
	/**
	 * Crea un modelo con un arreglo vacío de la capacidad dada 
	 */
	@Before
	public void setUp1() 
	{
		modelo= new Modelo(CAPACIDAD);
	}

	/**
	 * Llena el arreglo del modelo
	 */
	public void setUp2() 
	{
		for(int i =0; i< CAPACIDAD;i++)
		{
			modelo.agregar(i);
		}
	}

	/**
	 * Prueba que el modelo se cree correctamente y que no tenga elementos presentes
	 */
	@Test
	public void testModelo() 
	{
		assertTrue( modelo != null );
		assertEquals( 0, modelo.darTamano() );  // Modelo con 0 elementos presentes.
	}

	/**
	 * Prueba que la funcionalidad de tamaño funcione correctamente. <br>
	 * Escenario con arreglo vacío: <br>
	 * 1. Se pide el tamaño y retorna 0. <br>
	 * Escenario lleno: <br>
	 * 2. Se pide el tamaño y retorna CAPACIDAD. <br>
	 */
	@Test
	public void testDarTamano() 
	{
		assertTrue( modelo.darTamano() == 0 );
		
		setUp2();
		assertTrue( modelo.darTamano() == CAPACIDAD );
	}

	/**
	 * Prueba que la funcionalidad de agregar funcione correctamente. <br>
	 * Escenario con arreglo vacío: <br>
	 * Se agrega un elemento. <br>
	 * 1. Aumenta el tamaño del arreglo en 1. <br>
	 * 2. El elemento es encontrado cuando se busca. <br>
	 */
	@Test
	public void testAgregar() 
	{
		int tamano = modelo.darTamano();
		
		modelo.agregar( 322 );
		
		assertTrue( modelo.darTamano() == tamano + 1 );
		assertTrue( modelo.buscar( 322 ) == 322 );
	}

	/**
	 * Prueba que la funcionalidad de buscar funcione correctamente. <br>
	 * Escenario con arreglo vacío: <br>
	 * 1. Se busca un elemento y retorna null. <br>
	 * Escenario con arreglo lleno: <br>
	 * 1. Se busca un elemento que existe en el arreglo y lo retorna. <br>
	 * 2. Se busca un elemento que no existe en el arreglo y retorna null. <br>
	 */
	@Test
	public void testBuscar() 
	{
		assertTrue( modelo.buscar( 1 ) == null);
		
		setUp2();
		
		assertTrue( modelo.buscar( 55 ) == 55);
		assertTrue( modelo.buscar( 1 ) == 1);
		assertTrue( modelo.buscar( -1 ) == null);
		
	}

	/**
	 * Prueba que la funcionalidad de eliminar funcione correctamente. <br>
	 * Escenario con arreglo vacío: <br>
	 * 1. Se intenta eliminar un elemento que no existe en el arreglo y retorna null. <br>
	 * Escenario con arreglo lleno: <br>
	 * 1. Se intenta eliminar un elemento que no existe en el arreglo y retorna null. <br>
	 * 2. Se intenta eliminar un elemento que existe en el arreglo y retorna el elemento. <br>
	 * (Al buscar el elemento correctamente eliminado retorna null porque no existe) <br>
	 */
	@Test
	public void testEliminar() 
	{
		assertTrue( modelo.eliminar( 25 ) == null);
		
		setUp2();
		
		assertTrue( modelo.buscar( 108 ) == null );
		assertTrue( modelo.eliminar( 108 ) == null );
		
		assertTrue( modelo.eliminar( 28 ) == 28 );
		assertTrue( modelo.buscar( 28 ) == null );
		
	}

}
