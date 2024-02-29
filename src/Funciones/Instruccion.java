
package Funciones;

import java.util.HashMap;
import java.util.LinkedList;


public class Instruccion {
    //Texto que se muestra en consola
    public static String consola = "";
    
    // Lista donde se elamcenaran los tokens
    public static LinkedList<Object> listaTokens = new LinkedList<>();
    
    //Esta es donde se alamcenan los simbolos
    public static HashMap<String, Object> tablaDeSimbolos = new HashMap<>();
    
    // Lista donde se elamcenaran los tokens
    public static LinkedList<Object> listaErrores = new LinkedList<>();
    
    //Metodo para agregar el texto a consola
    public static void agregarTexto(String texto){
        consola += texto;
    }
    
    //Metodo para reiniciar el texto en consola
    public static void reiniciarTexto(){
        consola = "";
    }
    
    // Método para agregar los tokens
    public static void agregarTokens(Object valor) {
        if ( valor != null) {
            listaTokens.add(valor);
        } else {
            System.err.println("Error: No se puede agregar un valor nulo a la tabla de Tokens.");
        }
    }
    
    // Método para reiniciar los tokens
    public static void reiniciarTokens() {
        listaTokens.clear();
    }
    
    // Método para agregar un valor a la tabla de símbolos
    public static void agregarValor(String clave, Object valor) {
        if (clave != null && valor != null) {
            tablaDeSimbolos.put(clave, valor);
        } else {
            System.err.println("Error: No se puede agregar un valor nulo a la tabla de símbolos.");
        }
    }

    
    // Método para obtener un valor de la tabla de símbolos
    public static <T> T obtenerValor(String clave) {
        Object valor = tablaDeSimbolos.get(clave);
        try {
            return (T) valor;
        } catch (ClassCastException e) {
            return null; // Caso en que el valor no sea del tipo esperado
        }
    }
    
    // Método para reiniciar la tabla de simbolos
    public static void reiniciarTablaDeSimbolos() {
        tablaDeSimbolos.clear();
    }
    
    // Método para agregar los Errores
    public static void agregarError(Object valor) {
        if ( valor != null) {
            listaErrores.add(valor);
        } else {
            System.err.println("Error: No se puede agregar un valor nulo a la tabla de Errores.");
        }
    }
    
    // Método para reiniciar los Errores
    public static void reiniciarErrores() {
        listaErrores.clear();
    }
}
