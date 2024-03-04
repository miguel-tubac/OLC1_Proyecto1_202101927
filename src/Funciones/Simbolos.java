
package Funciones;


public class Simbolos {
    public static int contador2 = 0; // Variable estática para contar las instancias
    private int numero;
    private String nombre;
    private String tipo;
    private String valor;
    private int linea;
    private int columna;

    // Constructor
    public Simbolos (String nombre, String tipo, String valor, int linea, int columna) {
        this.numero = ++contador2; // Incrementar el contador y asignarlo a numero
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public String getValor() {
        return valor;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }     
}
