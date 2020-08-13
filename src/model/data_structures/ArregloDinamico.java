package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
@SuppressWarnings("unchecked")
public class ArregloDinamico <T extends Comparable<T>> implements IArregloDinamico<T>
{
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private T elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = (T[]) new Comparable[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( T dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    T [ ] copia = elementos;
                    elementos = (T[]) new Comparable[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darCapacidad() 
		{
			return tamanoMax;
		}

		public int darTamano() 
		{
			return tamanoAct;
		}

		public T darElemento(int i)
		{
			return elementos[i];
		}

		public T buscar(T dato) 
		{
			for (T actual: elementos)
			{
				if ( actual != null && actual.compareTo( dato ) == 0 )
					return actual;
			}
			return null;
		}

		public T eliminar(T dato) 
		{
			T eliminado = null;
			for (int i = 0; i < tamanoAct; i++)
			{
				if ( elementos[i].compareTo( dato ) == 0 )
				{
					eliminado = elementos[i];
					elementos[i] = null;
					tamanoAct--;
				}
				if( eliminado != null)
				{
					try {
						elementos[i] = elementos[ i + 1 ];
					} catch (NullPointerException e) {
						elementos[i] = null;
					}
				}
			}
			return eliminado;
		}
}
