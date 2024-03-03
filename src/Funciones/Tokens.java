
package Funciones;

public class Tokens {
    public static int contador = 0; // Variable estática para contar las instancias
    private int numero;
    private String lexema;
    private String tipo;
    private int linea;
    private int columna;

    // Constructor
    public Tokens(String lexema, String tipo, int linea, int columna) {
        this.numero = ++contador; // Incrementar el contador y asignarlo a numero
        this.lexema = lexema;
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
}
