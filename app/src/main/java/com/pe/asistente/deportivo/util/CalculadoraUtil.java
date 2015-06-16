package com.pe.asistente.deportivo.util;

/**
 * Created by JorgeLuis on 13/06/2015.
 */
public class CalculadoraUtil {

    public static double calcularIndiceMasaCorporal(double estatura, double peso) {
        return peso / (Math.pow(estatura, 2));
    }
}
