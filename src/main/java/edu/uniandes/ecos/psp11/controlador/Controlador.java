/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp11.controlador;

import java.util.List;

import edu.uniandes.ecos.psp11.modelo.CalculatorRelativeSizeRanges;

/**
 *Clase que sirve de controlador en el patron MVC 
 * @author Aleja Chica
 */
public class Controlador {
    
    public String realizarCalculos(List<Double> numeros){
        
    String resultado = "";
    
        CalculatorRelativeSizeRanges calc = new CalculatorRelativeSizeRanges(numeros);
        
        resultado = "VS = " + calc.calcularVS() + "\n";
        resultado += "S = " + calc.calcularS()+ "\n";
        resultado += "M = " + calc.calcularM()+ "\n";
        resultado += "L = " + calc.calcularL()+ "\n";
        resultado += "VL = " + calc.calcularVL()+ "\n";
        
        return resultado;
    }
    
     
}
