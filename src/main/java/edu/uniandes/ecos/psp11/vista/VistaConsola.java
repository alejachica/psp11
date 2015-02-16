package edu.uniandes.ecos.psp11.vista;

import java.util.LinkedList;
import java.util.List;

import edu.uniandes.ecos.psp11.controlador.Controlador;

/**
 * Hello world!
 *
 */
public class VistaConsola {

	private static final double PROXY = 386;

	public static void main(String[] args) {

		test1();
		test2();
	}

	/**
	 * Metodo que permite ejecutar el caso de prueba 1.
	 *  Los datos de entrada son los de la tabla 
	 *  Table 1. LOC/Method Data
	 */
	public static void test1() {

		List<Double> numeros = new LinkedList<Double>();
		numeros.add(6.0000);
		numeros.add(6.0000);
		numeros.add(8.3333);
		numeros.add(10.3333);
		numeros.add(12.3333);
		numeros.add(16.4000);
		numeros.add(20.5000);
		numeros.add(21.7500);
		numeros.add(22.2500);
		numeros.add(23.0000);
		numeros.add(28.3333);
		numeros.add(29.0000);
		numeros.add(55.8000);

		Controlador c = new Controlador();
		String resultado = c.realizarCalculos(numeros);
		System.out.println(resultado);
	}

	/**
	 * Metodo que permite ejecutar el caso de prueba 2.
	 *  Los datos de entrada son los de la tabla 
	 *  Table 2. Pgs/Chapter
	 */
	public static void test2() {

		List<Double> numeros = new LinkedList<Double>();
		numeros.add(7D);
		numeros.add(12D);
		numeros.add(10D);
		numeros.add(10D);
		numeros.add(12D);
		numeros.add(12D);
		numeros.add(12D);
		numeros.add(12D);
		numeros.add(12D);
		numeros.add(8D);
		numeros.add(8D);
		numeros.add(8D);
		numeros.add(20D);
		numeros.add(14D);
		numeros.add(18D);
		numeros.add(12D);
		
		Controlador c = new Controlador();
		String resultado = c.realizarCalculos(numeros);
		System.out.println(resultado);
	}

}
