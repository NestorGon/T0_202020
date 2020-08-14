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
	     * Imprime el menú del programa en consola
	     */
		public void printMenu()
		{
			System.out.println("1. Crear Arreglo Dinamico de Strings");
			System.out.println("2. Agregar String");
			System.out.println("3. Buscar String");
			System.out.println("4. Eliminar String");
			System.out.println("5. Imprimir el Arreglo");
			System.out.println("6. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		/**
		 * Imprime en consola el mensaje ingresado por parámetro
		 * @param mensaje - el mensaje que se va a imprimir
		 */
		public void printMessage(String mensaje) 
		{

			System.out.println(mensaje);
		}		
		
		/**
		 * Imprime el arreglo del modelo
		 * @param modelo - el modelo con la información a imprimir
		 */
		public void printModelo(Modelo modelo)
		{
			IArregloDinamico arreglo = modelo.darArreglo();
			int tamano = modelo.darTamano();
			for (int i = 0; i < tamano; i++)
			{
				System.out.println( "   " + arreglo.darElemento( i ) );
			}
		}
}
