package funciones;

public class Utilidades {

	/**
	 * Constante que contiene el número de horas de una joranda normal
	 * {@value}
	 */
	public static final int HORASJORNADA = 38;
	
	/**
	 * Método de la clase que devuelve la representación textual de la nota
	 * pasada como parámetro
	 * @param nota double con la nota a comprobar
	 * @return Una cadena de tipo String con el texto resultante (Suspenso, Bien,
	 * Notable, Sobrasaliente o Matrícula)
	 * @throws ArithmeticException cuando la nota no está entre 0 y 10
	 */
	public String devuelveNota(double nota) {
		if (nota<0 || nota>10) {
			throw new ArithmeticException();
		} else if (nota<5) {
			return "Suspenso";
		} else if (nota<6.5) {
			return "Bien";
		} else if (nota<8.5) {
			return "Notable";
		} else if (nota<10) {
			return "Sobresaliente";
		} else {
			return "Matrícula";
		}
	}
	
	/**
	 * Método que calcula el salario correspondiente a las horas extras realizadas.
	 * @param numHoras int Cantidad de horas realizadas
	 * @param precioHoras double Precio al que se paga cada hora trabajada
	 * @param precioExtras double Precio al que se paga cada hora extra
	 * @return double Salario total contando las horas extras
	 * @throws ArithmeticException cuando se introducen valores negativos o 0
	 */
	public double calculaSalario(int numHoras, double precioHoras, double precioExtras) {
		int extras=0;
		int horas=numHoras;
		if (numHoras<=0 || precioHoras<=0 || precioExtras <= 0 ) {
			throw new ArithmeticException(); 
		}
		if (numHoras>HORASJORNADA) {
			extras = numHoras-HORASJORNADA;
			horas = HORASJORNADA;
		}
		return horas*precioHoras+extras*precioExtras;		
	}
	
	/**
	 * Método que cuenta cuántos divisores tiene el número introducido
	 * @param num int Número del que queremos contar sus divisores
	 * @return int Cantidad de divisores del número introducido
	 */
	public int cuentaDivisores(int num) {
		int cuenta=0;
		
		for (int i = 1; i <= num; i++) {
			if (num%i==0) {
				cuenta++;
			}
		}
		return cuenta;
	}
	
	/**
	 * Método que deveulve el menor elemento de un array dado como parámetro, 
	 * por ejemplo un vector [2,3,-1,9] devolvería -1
	 * @param v int [] vector de enteros con los números
	 * @return int con el menor número del vector.
	 */
	public double devuelveMenor(int v[]) {
		// Guardo en menor el primer valor del vector
		int menor = v[0];
		// Como está guardado el primer valor (0), empiezo el bucle desde el segundo (1)
		for (int i=1;i<v.length;i++) {
			// Uso la comparación de menores con el valor guardado y la posición del vector,
			// por lo que si la posición es menor se sustuiturá en la variable.
			menor=Math.min(menor, v[i]);
		}
		return menor;
	}
	
	/**
	 * Método que ordena los valores de un vector de menor a mayor
	 * @param v in[] vector a ordenar
	 * @return in[] con el vector ordenado
	 */
	public int [] burbuja(int[] v)
    {
      int auxiliar;
      int[] ordenado;
      for(int i = 1; i < v.length; i++)
      {
        for(int j = 0;j < v.length-i;j++)
        {
          if(v[j] > v[j+1])
          {
            auxiliar = v[j];
            v[j] = v[j+1];
            v[j+1] = auxiliar;
          }   
        }
      }
      ordenado = v;
      return ordenado;
    }
}
