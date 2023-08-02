package funciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class UtildadesTest {

private static Utilidades utils;
	
	

	@Test
	void testDevuelveNota() {
		assertThrows(ArithmeticException.class,
				()->utils.devuelveNota(-2));
		assertThrows(ArithmeticException.class,
				()->utils.devuelveNota(12));
		//límite
		assertEquals("Suspenso",
				utils.devuelveNota(0));
		assertEquals("Suspenso",
				utils.devuelveNota(4));
		//límite
		assertEquals("Bien",
				utils.devuelveNota(5));
		assertEquals("Bien",
				utils.devuelveNota(6));
		// límite
		assertEquals("Notable",
				utils.devuelveNota(6.5));
		assertEquals("Notable",
				utils.devuelveNota(8.4));
		//límite
		assertEquals("Sobresaliente",
				utils.devuelveNota(8.5));
		assertEquals("Sobresaliente",
				utils.devuelveNota(9.9));
		assertEquals("Matrícula",
				utils.devuelveNota(10));
	}

	@Test
	void testCalculaSalario() {
		// Como al método al que se llama no es 'static' es necesario instanciar la clase para poder llamarlo
		utils = new Utilidades();

		
		// Test con horas extras
		assertEquals(utils.HORASJORNADA*20+(40-utils.HORASJORNADA)*35,
				utils.calculaSalario(40,20,35));
		
		//Test sin horas extras
		assertEquals(20*20,utils.calculaSalario(20,20,35));
		
		//Test límite, con las hora a 38
		assertEquals(38*20,utils.calculaSalario(38,20,35));
		
		//Test de errores con valores negativos y 0
		assertThrows(ArithmeticException.class,()->utils.calculaSalario(0, 20, 35));
		assertThrows(ArithmeticException.class,()->utils.calculaSalario(40, 0, 35));
		assertThrows(ArithmeticException.class,()->utils.calculaSalario(40, 20, 0));
		assertThrows(ArithmeticException.class,()->utils.calculaSalario(-10, 20, 35));
		assertThrows(ArithmeticException.class,()->utils.calculaSalario(40, -10, 35));
		assertThrows(ArithmeticException.class,()->utils.calculaSalario(35, 20, -10));

	}

	@Test
	void testCuentaDivisores() {
		//Test con 10
		assertEquals(4,utils.cuentaDivisores(10));
		//Test con 0
		assertEquals(0,utils.cuentaDivisores(0));
		//Test con negativos
		assertEquals(0,utils.cuentaDivisores(-10));
		

	}

	@Test
	void testDevuelveMenor() {
		int v[] = { 2,3,8,1,7 };
		assertEquals(1, utils.devuelveMenor(v));
		
		int v2[] = { 2,3,-8,1,7 };
		assertEquals(-8, utils.devuelveMenor(v2));
	}

	@Test
	void testBurbuja() {
		int v[] = {3,5,1,4,2};
		int ordenado[] = {1,2,3,4,5};
		
		// Para comparar vectores se tiene que usar este método.
		// Es posible que Eclipse no lo importe bien y tengas que ir a la parte superior
		// a ponerlo a mano.
		assertArrayEquals(ordenado,utils.burbuja(v));
		
		// Test con negativos
		int v2[] = {3,-5,1,4,2};
		int ordenado2[] = {-5, 1,2,3,4};
		assertArrayEquals(ordenado2,utils.burbuja(v2));
	}

}
