
package Funciones;

import java.util.HashMap;
import java.util.LinkedList;


public class Instruccion {
    //Texto que se muestra en consola
    public static String consola = "";
    
    //Esta es donde se alamcenan los simbolos
    public static HashMap<String, Object> tablaDeSimbolos = new HashMap<>();
    
    //Metodo para agregar el texto a consola
    public static void agregarTexto(String texto){
        consola += texto;
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
     

    public static void mostrarLista(LinkedList<String> lista){
        lista.forEach((elemento) -> {
            Funciones.Instruccion.agregarTexto(elemento.toString());
        });
        Funciones.Instruccion.agregarTexto("\n");
    }
}
