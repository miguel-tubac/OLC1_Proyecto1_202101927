
package FuncionTokens;

import java.util.HashMap;
import java.util.LinkedList;


public class Instruccion {
                                //este segundo estring se tiene que modificar como objeto
    public static HashMap<String,String> tablaDeSimbolos = new HashMap<>();
    public static HashMap<String, LinkedList> tablaArre = new HashMap<>();
    
    public static void print(String exp){
        //tablaDeSimbolos.put(exp, exp);
        //aqui agregarlo a la imprecion por consola
    }
    
    // Método para agregar un valor a la tabla de símbolos
    public static void agregarValor(String clave, String valor) {
        if (clave != null && valor != null) {
            tablaDeSimbolos.put(clave, valor);
        } else {
            System.err.println("Error: No se puede agregar un valor nulo a la tabla de símbolos.");
        }
    }
    public static void agregarValor(String clave, LinkedList<String> lista) {
        tablaDeSimbolos.put(clave, lista);
    }
    
    // Método para obtener un valor de la tabla de símbolos
    public static String obtenerValor(String clave) {
        if (clave != null) {
            return tablaDeSimbolos.get(clave);
        } else {
            System.err.println("Error: No se puede obtener un valor de la tabla de símbolos con clave nula.");
            return null;
        }
    }

    public static void mostrarLista(LinkedList<String> lista){
        lista.forEach((elemento) -> {
            FuncionTokens.TextoConsola.consola += elemento.toString();
        });
        FuncionTokens.TextoConsola.consola +="\n";
    }
}
