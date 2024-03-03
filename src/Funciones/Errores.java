
package Funciones;


public class Errores {
    public static int contador1 = 0; // Variable estática para contar las instancias
    private int numero;
    private String tipo;
    private String descripcion;
    private int linea;
    private int columna;

    // Constructor
    public Errores (String tipo, String descripcion, int linea, int columna) {
        this.numero = ++contador1; // Incrementar el contador y asignarlo a numero
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    } 
}
