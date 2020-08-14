package view;

import model.data_structures.IArregloDinamico;
import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
	    /**
	     * Imprime el men� del programa en consola
	     */
		public void printMenu()
		{
			System.out.println("1. Crear Arreglo Dinamico de enteros");
			System.out.println("2. Agregar entero");
			System.out.println("3. Buscar entero");
			System.out.println("4. Eliminar entero");
			System.out.println("5. Imprimir el Arreglo");
			System.out.println("6. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		/**
		 * Imprime en consola el mensaje ingresado por par�metro
		 * @param mensaje - el mensaje que se va a imprimir
		 */
		public void printMessage(String mensaje) 
		{
			System.out.println(mensaje);
		}		
		
		/**
		 * Imprime el arreglo del modelo
		 * @param modelo - el modelo con la informaci�n a imprimir
		 */
		public void printModelo(Modelo modelo)
		{
			IArregloDinamico<Integer> arreglo = modelo.darArreglo();
			int tamano = modelo.darTamano();
			for (int i = 0; i < tamano; i++)
			{
				System.out.println( "   " + arreglo.darElemento( i ) );
			}
		}
}
