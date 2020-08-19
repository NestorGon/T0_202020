package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico 
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
        private String elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = new String[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( String dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    String [ ] copia = elementos;
                    elementos = new String[tamanoMax];
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
		public String darElemento(int i) 
		{
			return elementos[i];
		}

		/**
		 * Buscar un dato en el arreglo.
		 * @param dato Objeto de busqueda en el arreglo
		 * @return elemento encontrado en el arreglo (si existe). null si no se encontro el dato.
		 */
		public String buscar(String dato)
		{
			for (String actual: elementos)
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
		public String eliminar(String dato) 
		{
			String eliminado = null;
			for (int i = 0; i < tamanoAct; i++)
			{
				if ( elementos[i].compareTo( dato ) == 0 && eliminado == null)
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
