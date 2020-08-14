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
        
		/**
		 * Agregar un dato de forma compacta (en la primera casilla disponible) 
		 * Caso Especial: Si el arreglo esta lleno debe aumentarse su capacidad, agregar el nuevo dato y deben quedar multiples casillas disponibles para futuros nuevos datos.
		 * @param dato nuevo elemento
		 */
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

		/**
		 * Retornar el numero de elementos maximo en el arreglo
		 * @return tamanoMax
		 */
		public int darCapacidad() 
		{
			return tamanoMax;
		}

		/**
		 * Retornar el numero de elementos presentes en el arreglo
		 * @return tamanoAct
		 */
		public int darTamano() 
		{
			return tamanoAct;
		}

		/**
		 * Retornar el elemento en la posicion i
		 * @param i posicion de consulta
		 * @return elemento de consulta. null si no hay elemento en posicion.
		 */
		public T darElemento(int i)
		{
			return elementos[i];
		}

		/**
		 * Buscar un dato en el arreglo.
		 * @param dato Objeto de busqueda en el arreglo
		 * @return elemento encontrado en el arreglo (si existe). null si no se encontro el dato.
		 */
		public T buscar(T dato) 
		{
			for (T actual: elementos)
			{
				if ( actual != null && actual.compareTo( dato ) == 0 )
					return actual;
			}
			return null;
		}

		/**
		 * Eliminar un dato del arreglo.
		 * Los datos restantes deben quedar "compactos" desde la posicion 0.
		 * @param dato Objeto de eliminacion en el arreglo
		 * @return dato eliminado
		 */
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
