
package FuncionTokens;

import java.util.HashMap;
import java.util.LinkedList;


public class Instruccion {
    //Esta es donde se alamcenan los simbolos
    public static HashMap<String, Object> tablaDeSimbolos = new HashMap<>();
    
    
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
            FuncionTokens.TextoConsola.consola += elemento.toString();
        });
        FuncionTokens.TextoConsola.consola +="\n";
    }
}
