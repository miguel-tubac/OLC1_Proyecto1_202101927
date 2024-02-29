
package Funciones;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Expresion {
    //Metodo para realizar la suma
    public static String suma (String izq, String der){
        String resultado = "";
        try{
            double var1 = Double.parseDouble(izq);
            double var2 = Double.parseDouble(der);
            double resSuma = var1 + var2;
            resultado = String.valueOf(resSuma);
        } catch(NumberFormatException e){
            resultado = "Error en la Suma";
        }
        return resultado;
    }
    
    //Metodo para realizar la resta
    public static String resta (String izq, String der){
        String resultado = "";
        try{
            double var1 = Double.parseDouble(izq);
            double var2 = Double.parseDouble(der);
            double resRes = var1 - var2;
            resultado = String.valueOf(resRes);
        } catch(NumberFormatException e){
            resultado = "Error en la resta";
        }
        return resultado;
    }
    
    //Metodo para realizar la multiplicacion
    public static String multiplicacion (String izq, String der){
        String resultado = "";
        try{
            double var1 = Double.parseDouble(izq);
            double var2 = Double.parseDouble(der);
            double resMul = var1 * var2;
            resultado = String.valueOf(resMul);
        } catch(NumberFormatException e){
            resultado = "Error en la multiplicaion";
        }
        return resultado;
    }
    
    //Metodo para realizar la divicion
    public static String divicion (String izq, String der){
        String resultado = "";
        try{
            double var1 = Double.parseDouble(izq);
            double var2 = Double.parseDouble(der);
            double resDiv = var1 / var2;
            resultado = String.valueOf(resDiv);
        } catch(NumberFormatException e){
            resultado = "Error en la Divicion";
        }
        return resultado;
    }
    
    //Metodo para realizar el modulo
    public static String modulo (String izq, String der){
        String resultado = "";
        try{
            double var1 = Double.parseDouble(izq);
            double var2 = Double.parseDouble(der);
            double resMod = var1 % var2;
            resultado = String.valueOf(resMod);
        } catch(NumberFormatException e){
            resultado = "Error en el calculo del Modulo";
        }
        return resultado;
    }
    
        // Método para calcular la media
    public static String calcularMedia(LinkedList<String> datos) {
        double suma = 0;
        String resultado = "";
        try{
            for (String dato : datos) {
                suma += Double.parseDouble(dato);
            }
            resultado = String.valueOf(suma / datos.size());
        } catch(NumberFormatException e){
            resultado = "Error en el calculo de Media";
        }
        return resultado;
    }

    // Método para calcular la mediana
    public static String calcularMediana(LinkedList<String> datos) {
        LinkedList<Double> datosNumericos = new LinkedList<>();
        String resultado = "";
        try{
            for (String dato : datos) {
                datosNumericos.add(Double.parseDouble(dato));
            }
            Collections.sort(datosNumericos);
            int n = datosNumericos.size();
            if (n % 2 == 0) {
                resultado = String.valueOf((datosNumericos.get(n / 2 - 1) + datosNumericos.get(n / 2)) / 2);
            } else {
                resultado = String.valueOf( datosNumericos.get(n / 2));
            }
        } catch(NumberFormatException e){
            resultado = "Error en el calculo de Mediana";
        }
        return resultado;
    }

    // Método para calcular la moda
    public static String calcularModa(LinkedList<String> datos) {
        Map<Double, Integer> frecuencias = new HashMap<>();
        String resultado = "";
        try{
            for (String dato : datos) {
                double valor = Double.parseDouble(dato);
                frecuencias.put(valor, frecuencias.getOrDefault(valor, 0) + 1);
            }
            double moda = 0;
            int maxFrecuencia = 0;
            for (Map.Entry<Double, Integer> entry : frecuencias.entrySet()) {
                if (entry.getValue() > maxFrecuencia) {
                    moda = entry.getKey();
                    maxFrecuencia = entry.getValue();
                }
            }
            resultado = String.valueOf( moda );
        } catch(NumberFormatException e){
            resultado = "Error en el calculo de la Moda";
        }
        return resultado;
    }

    // Método para calcular la varianza
    public static String calcularVarianza(LinkedList<String> datos) {
        String resultado = "";
        try{
            double media = Double.parseDouble(calcularMedia(datos));
            double sumaCuadrados = 0;
            for (String dato : datos) {
                double valor = Double.parseDouble(dato);
                sumaCuadrados += Math.pow(valor - media, 2);
            }
            resultado = String.valueOf(sumaCuadrados / datos.size());
        } catch(NumberFormatException e){
            resultado = "Error en el calculo de la Varianza";
        }
        return resultado;
    }

    // Método para calcular el máximo
    public static String calcularMaximo(LinkedList<String> datos) {
        String resultado = "";
        try{
            double maximo = Double.MIN_VALUE;
            for (String dato : datos) {
                double valor = Double.parseDouble(dato);
                if (valor > maximo) {
                    maximo = valor;
                }
            }
            resultado = String.valueOf( maximo );
        } catch(NumberFormatException e){
            resultado = "Error en el calculo de Maximo";
        }
        return resultado;
    }

    // Método para calcular el mínimo
    public static String calcularMinimo(LinkedList<String> datos) {
        String resultado = "";
        try{
            double minimo = Double.MAX_VALUE;
            for (String dato : datos) {
                double valor = Double.parseDouble(dato);
                if (valor < minimo) {
                    minimo = valor;
                }
            }
            resultado = String.valueOf( minimo );
        } catch(NumberFormatException e){
            resultado = "Error en el calculo de Minimo";
        }
        return resultado;
    }
    
    public static void mostrarLista(String nombre, LinkedList<String> lista){
        Funciones.Instruccion.agregarTexto("------------------------------------------------------------------\n");
        Funciones.Instruccion.agregarTexto("\t"+nombre.toString()+"\n");
        Funciones.Instruccion.agregarTexto("------------------------------------------------------------------\n");
        lista.forEach((elemento) -> {
            Funciones.Instruccion.agregarTexto(elemento.toString()+"\n");
        });
        Funciones.Instruccion.agregarTexto("\n");
    }
}
