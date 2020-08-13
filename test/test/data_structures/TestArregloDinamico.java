package test.data_structures;

import model.data_structures.ArregloDinamico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico 
{

	/**
	 * Representa el arreglo dinámico de números enteros
	 */
	private ArregloDinamico<Integer> arreglo;
	
	/**
	 * Cantidad entera que representa el tamaño inicial del arreglo
	 */
	private static int TAMANO = 100;
	
	/**
	 * Se inicializa el arreglo vacío con tamaño = TAMANO
	 */
	@Before
	public void setUp1() 
	{
		arreglo= new ArregloDinamico<Integer>(TAMANO);
	}

	/**
	 * Se agregan los valores del 0 al 199 al arreglo
	 */
	public void setUp2()
	{
		for(int i =0; i< TAMANO*2; i++){
			arreglo.agregar(i);
		}
	}

	/**
	 * Prueba las funcionalidades del arreglo. <br>
	 * Escenario con arreglo vacío: <br>
	 * 1. Se busca un elemento que no existe en el arreglo y debe retornar null. <br>
	 * 2. Se pide la capacidad del arreglo y debe retornar TAMANO. <br>
	 * 3. Se pide el tamaño del arreglo y debe retornar 0 porque no hay elementos. <br>
	 * 4. Se intenta eliminar un elemento que no existe y debe retornar null. <br>
	 * Escenario con arreglo lleno: <br>
	 * 1. Se busca un elemento que existe en el arreglo y debe retornar el elemento. <br>
	 * 2. Se pide la capacidad del arreglo y debe retornar TAMANO * 2. <br>
	 * 3. Se pide el tamaño del arreglo y debe retornar TAMANO * 2. <br>
	 * 4. Se intenta eliminar un elemento que existe y debe retornar el elemento. <br>
	 * 5. Se busca el elemento eliminado y debe retornar null. <br>
	 * 6. Se pide el elemento en la posición que ocupaba el elemento eliminado y no debe retornar null. <br
	 */
	@Test
	public void testArregloDinamico() 
	{
		assertTrue( arreglo.buscar( 3 ) == null );
		assertTrue( arreglo.darCapacidad() == TAMANO );
		assertTrue( arreglo.darTamano() == 0 );
		assertTrue( arreglo.eliminar( 3 ) == null );
		
		setUp2();
		
		assertTrue( arreglo.buscar( 3 ) == 3 );
		assertTrue( arreglo.darCapacidad() == TAMANO * 2 );
		assertTrue( arreglo.darTamano() == TAMANO * 2 );
		assertTrue( arreglo.eliminar( 3 ) == 3 );
		assertTrue( arreglo.buscar( 3 ) == null );
		assertTrue( arreglo.darElemento( 3 ) != null );
	}

	/**
	 * Prueba que la funcionalidad de dar elemento funcione correctamente. <br>
	 * Escenario con arreglo vacío: <br>
	 * 1. Se pide un elemento y debe retornar null. <br>
	 * Escenario con arreglo lleno: <br>
	 * 1. Se piden dos elementos separadamente y retorna el elemento correspondiente <br>
	 */
	@Test
	public void testDarElemento() 
	{
		assertTrue( arreglo.darElemento( 2 ) == null );
		
		setUp2();
		
		assertTrue( arreglo.darElemento( 2 ) == 2);
		assertTrue( arreglo.darElemento( 33 ) == 33);
	}

}
