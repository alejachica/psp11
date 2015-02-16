/**
 * 
 */
package edu.uniandes.ecos.psp11.modelo;

/**
 * @author Aleja Chica
 *
 */
public class LogarithmicRanges {

	public double calcularLnVerySmall(double promedio, double desviacionEstandar){

		double lnVS = promedio - (2 * desviacionEstandar);

		return lnVS;
	}

	public double calcularLnSmall(double promedio, double desviacionEstandar){

		double lnS = promedio - desviacionEstandar;

		return lnS;
	}

	public double calcularLnMedium(double promedio){

		return promedio;
	}
	
	public double calcularLnLarge(double promedio, double desviacionEstandar){

		double lnL = promedio + desviacionEstandar;

		return lnL;
	}
	
	public double calcularLnVeryLarge(double promedio, double desviacionEstandar){

		double lnVL = promedio + (2 * desviacionEstandar);

		return lnVL;
	}
}
