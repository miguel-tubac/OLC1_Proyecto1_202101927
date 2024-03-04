
package Funciones;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Expresion {
    // Lista donde se elamcenaran los valores
    public static LinkedList<Double> listaValor = new LinkedList<>();
    // Lista donde se elamcenaran las frecuancias
    public static LinkedList<Double> listaFrecuencia = new LinkedList<>();
    
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
    
    public static void reinicioDeDatosParaEstadisticas(){
        listaFrecuencia.clear();
        listaValor.clear();
    }
    
    public static void calcularEstadisticas(LinkedList<String> valores, String Titulo) {
        try{
            reinicioDeDatosParaEstadisticas();
            // Convertir la lista de Strings a una lista de Doubles
            LinkedList<Double> valoresDoubles = new LinkedList<>();
            for (String str : valores) {
                try {
                    double valor = Double.parseDouble(str);
                    valoresDoubles.add(valor);
                } catch (NumberFormatException e) {
                    // Manejar el error 
                    e.printStackTrace();
                }
            }

            // Ordenar la lista de valores
            Collections.sort(valoresDoubles);

            // Calcular frecuencia de cada valor
            LinkedHashMap<Double, Integer> frecuenciaValores = new LinkedHashMap<>();
            for (Double valor : valoresDoubles) {
                frecuenciaValores.put(valor, frecuenciaValores.getOrDefault(valor, 0) + 1);
            }

            // Calcular frecuencia acumulada y frecuencia relativa
            int totalValores = valoresDoubles.size();
            int frecuenciaAcumulada = 0;
            StringBuilder resultado = new StringBuilder();
            resultado.append(String.format("%-10s %-10s %-10s %-10s\n", "Valor", "Fb", "Fa", "Fr"));
            resultado.append("---------------------------------------------\n");
            for (Map.Entry<Double, Integer> entry : frecuenciaValores.entrySet()) {
                double valor = entry.getKey();
                int frecuencia = entry.getValue();
                double frecuenciaRelativa = (double) frecuencia / totalValores * 100;
                frecuenciaAcumulada += frecuencia;
                resultado.append(String.format("%-10s %-10s %-10s %-10.2f%%\n", valor, frecuencia, frecuenciaAcumulada, frecuenciaRelativa));
                listaFrecuencia.add((double)frecuencia);
                listaValor.add(valor);
            }
            resultado.append("---------------------------------------------\n");
            resultado.append(String.format("%-10s %-10s %-10s %-10s\n", "Totales:", totalValores, totalValores, "100%"));
            resultado.append("---------------------------------------------\n");

            // Agregar el título
            resultado.insert(0,Titulo + "\n");
            resultado.insert(Titulo.length() + 1, "-".repeat(45) + "\n");

            Funciones.Instruccion.agregarTexto(resultado.toString());
            InterfasGrafica.FrameInicio.barrasHistogram(Titulo, listaFrecuencia, listaValor);
        } catch (Exception e) {
            // Manejar cualquier excepción que ocurra 
            e.printStackTrace();
            //Funciones.Instruccion.agregarError("Error: al calcular estadísticas: " + e.getMessage());
        }        
    }
    
    //Generacion de la tabla de Tokens
    public static void imprecionLexemas() {
        Funciones.Tokens.contador = 0;
        // Construir la tabla en formato HTML
        StringBuilder htmlTable = new StringBuilder();
        htmlTable.append("<html>");
        htmlTable.append("<head>");
        htmlTable.append("<title>Tabla de Tokens</title>");
        htmlTable.append("</head>");
        htmlTable.append("<body>");
        htmlTable.append("<h1>Tabla de Tokens</h1>");
        htmlTable.append("<table border=\"1\">");
        htmlTable.append("<tr>");
        htmlTable.append("<th>Número</th>");
        htmlTable.append("<th>Lexema</th>");
        htmlTable.append("<th>Tipo</th>");
        htmlTable.append("<th>Línea</th>");
        htmlTable.append("<th>Columna</th>");
        htmlTable.append("</tr>");

        // Iterar sobre la lista de tokens
        for (Object obj : Instruccion.listaTokens) {
            // Verificar si el objeto es una instancia de Token
            if (obj instanceof Tokens) {
                // Convertir el objeto a Token
                Tokens token = (Tokens) obj;

                // Acceder a los valores del token
                int numero = token.getNumero();
                String lexema = token.getLexema();
                String tipo = token.getTipo();
                int linea = token.getLinea();
                int columna = token.getColumna();

                // Agregar una fila a la tabla con los valores del token
                htmlTable.append("<tr>");
                htmlTable.append("<td>").append(numero).append("</td>");
                htmlTable.append("<td>").append(lexema).append("</td>");
                htmlTable.append("<td>").append(tipo).append("</td>");
                htmlTable.append("<td>").append(linea).append("</td>");
                htmlTable.append("<td>").append(columna).append("</td>");
                htmlTable.append("</tr>");
            }
        }

        // Cerrar la tabla y el documento HTML
        htmlTable.append("</table>");
        htmlTable.append("</body>");
        htmlTable.append("</html>");

        // Guardar la tabla en un archivo HTML
        String rutaArchivo = "src/Tablas(Reportes)/TablaTokens.html";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(htmlTable.toString());
            
            System.out.println("Tabla de Tokens generada y guardada en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar la tabla de Tokens en el archivo: " + e.getMessage());
        }
    }
    
    
    //Generacion de la tabla de Errores
    public static void imprecionErrores() {
        Funciones.Errores.contador1 = 0;
        // Construir la tabla en formato HTML
        StringBuilder htmlTable = new StringBuilder();
        htmlTable.append("<html>");
        htmlTable.append("<head>");
        htmlTable.append("<title>Tabla de Errores</title>");
        htmlTable.append("</head>");
        htmlTable.append("<body>");
        htmlTable.append("<h1>Tabla de Errores</h1>");
        htmlTable.append("<table border=\"1\">");
        htmlTable.append("<tr>");
        htmlTable.append("<th>Número</th>");
        htmlTable.append("<th>Tipo</th>");
        htmlTable.append("<th>Descripcion</th>");
        htmlTable.append("<th>Línea</th>");
        htmlTable.append("<th>Columna</th>");
        htmlTable.append("</tr>");

        // Iterar sobre la lista de tokens
        for (Object obj : Instruccion.listaErrores) {
            // Verificar si el objeto es una instancia de Token
            if (obj instanceof Errores) {
                // Convertir el objeto a Token
                Errores error = (Errores) obj;

                // Acceder a los valores del token
                int numero = error.getNumero();
                String tipo = error.getTipo();
                String descripcion = error.getDescripcion();
                int linea = error.getLinea();
                int columna = error.getColumna();

                // Agregar una fila a la tabla con los valores del token
                htmlTable.append("<tr>");
                htmlTable.append("<td>").append(numero).append("</td>");
                htmlTable.append("<td>").append(tipo).append("</td>");
                htmlTable.append("<td>").append(descripcion).append("</td>");
                htmlTable.append("<td>").append(linea).append("</td>");
                htmlTable.append("<td>").append(columna).append("</td>");
                htmlTable.append("</tr>");
            }
        }

        // Cerrar la tabla y el documento HTML
        htmlTable.append("</table>");
        htmlTable.append("</body>");
        htmlTable.append("</html>");

        // Guardar la tabla en un archivo HTML
        String rutaArchivo = "src/Tablas(Reportes)/TablaErrores.html";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(htmlTable.toString());
            
            System.out.println("Tabla de Errores generada y guardada en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar la tabla de Errores en el archivo: " + e.getMessage());
        }
    }
    
    
    //Generacion de la tabla de Simbolos
    public static void imprecionSimbolos() {
        Funciones.Simbolos.contador2 = 0;
        // Construir la tabla en formato HTML
        StringBuilder htmlTable = new StringBuilder();
        htmlTable.append("<html>");
        htmlTable.append("<head>");
        htmlTable.append("<title>Tabla de Simbolos</title>");
        htmlTable.append("</head>");
        htmlTable.append("<body>");
        htmlTable.append("<h1>Tabla de Simbolos</h1>");
        htmlTable.append("<table border=\"1\">");
        htmlTable.append("<tr>");
        htmlTable.append("<th>número</th>");
        htmlTable.append("<th>Nombre</th>");
        htmlTable.append("<th>Tipo</th>");
        htmlTable.append("<th>Valor</th>");
        htmlTable.append("<th>Línea</th>");
        htmlTable.append("<th>Columna</th>");
        htmlTable.append("</tr>");

        // Iterar sobre la lista de tokens
        for (Object obj : Instruccion.simbolos) {
            // Verificar si el objeto es una instancia de Token
            if (obj instanceof Simbolos) {
                // Convertir el objeto a Token
                Simbolos sim = (Simbolos) obj;

                // Acceder a los valores del token
                int numero = sim.getNumero();
                String nombre = sim.getNombre();
                String tipo = sim.getTipo();
                String valor = sim.getValor();
                int linea = sim.getLinea();
                int columna = sim.getColumna();

                // Agregar una fila a la tabla con los valores del token
                htmlTable.append("<tr>");
                htmlTable.append("<td>").append(numero).append("</td>");
                htmlTable.append("<td>").append(nombre).append("</td>");
                htmlTable.append("<td>").append(tipo).append("</td>");
                htmlTable.append("<td>").append(valor).append("</td>");
                htmlTable.append("<td>").append(linea).append("</td>");
                htmlTable.append("<td>").append(columna).append("</td>");
                htmlTable.append("</tr>");
            }
        }

        // Cerrar la tabla y el documento HTML
        htmlTable.append("</table>");
        htmlTable.append("</body>");
        htmlTable.append("</html>");

        // Guardar la tabla en un archivo HTML
        String rutaArchivo = "src/Tablas(Reportes)/TablaSimbolos.html";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(htmlTable.toString());
            
            System.out.println("Tabla de Simbolos generada y guardada en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar la tabla de Simbolos en el archivo: " + e.getMessage());
        }
    }

}
