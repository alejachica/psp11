/**
 * 
 */
package edu.uniandes.ecos.psp11.modelo;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Aleja Chica
 *
 */
public class CalculatorRelativeSizeRanges {

	private List<Double> numeros;
	private List<Double> numerosLN;
	private double average;
	private double sd;
	private LogarithmicRanges logarithmicRanges;
	private ConverterLN converterLN;

	public CalculatorRelativeSizeRanges(List<Double> numeros) {

		this.numeros = numeros;
		numerosLN = new LinkedList<Double>();
		calcularLnxi();
		logarithmicRanges = new LogarithmicRanges();
		converterLN = new ConverterLN();
		calcularAverage();
		calcularStandardDeviation();
	}

	private List<Double> calcularLnxi() {

		double log;
		for (Double num : numeros) {

			log = Math.log(num);
			numerosLN.add(log);
		}

		return numerosLN;
	}

	public double calcularAverage() {

		Mean mean = new Mean();
		average = mean.calcularPromedio((LinkedList<Double>) numerosLN);

		return average;
	}

	public double calcularStandardDeviation() {

		StandardDeviation standardDeviation = new StandardDeviation();
		sd = standardDeviation.calcularDesviacionEstandar(average, (LinkedList<Double>) numerosLN);

		return sd;
	}

	public double calcularVS() {

		double lnvs = logarithmicRanges.calcularLnVerySmall(average, sd);
		return converterLN.calcularAntiLnVerySmall(lnvs);
	}

	public double calcularS() {

		double lnS = logarithmicRanges.calcularLnSmall(average, sd);
		return converterLN.calcularAntiLnSmall(lnS);
	}

	public double calcularM() {

		double lnM = logarithmicRanges.calcularLnMedium(average);
		return converterLN.calcularAntiLnMedium(lnM);
	}

	public double calcularL() {

		double lnL = logarithmicRanges.calcularLnLarge(average, sd);
		return converterLN.calcularAntiLnLarge(lnL);
	}

	public double calcularVL() {

		double lnVL = logarithmicRanges.calcularLnVeryLarge(average, sd);
		return converterLN.calcularAntiLnVeryLarge(lnVL);
	}

}
