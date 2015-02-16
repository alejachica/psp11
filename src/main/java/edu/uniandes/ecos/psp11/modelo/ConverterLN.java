/**
 * 
 */
package edu.uniandes.ecos.psp11.modelo;

/**
 * @author Aleja Chica
 *
 */
public class ConverterLN {
	
	public double calcularAntiLnVerySmall(double lnvs){

		return Math.pow(Math.E, lnvs);
	}

	public double calcularAntiLnSmall(double lns){

		return Math.pow(Math.E, lns);
	}

	public double calcularAntiLnMedium(double lnM){

		return Math.pow(Math.E, lnM);
	}
	
	public double calcularAntiLnLarge(double lnL){

		return Math.pow(Math.E, lnL);
	}
	
	public double calcularAntiLnVeryLarge(double lnvl){

		return Math.pow(Math.E, lnvl);
	}

}
