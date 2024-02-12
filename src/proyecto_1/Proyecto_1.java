
package proyecto_1;

//Importaciones
import java.io.StringReader;

//Ruta en donde se enceuntra nuestra clase principal Main
// es:  src/proyecto_1/Main.java
public class Proyecto_1 {


    public static void main(String[] args) {
        //ejemplo de utilizacion de la funcion analizadores
        // primer atributo: ruta donde se encuentran los archivos flex y cup
        //Segundo paramentro el nombre del jflex al igual que el tercer parametro
        //Comente la llamada a la funcion ya que solo se debe de ejecutar una ves, para que genere los archivos .java en 
        //el paquete analizador
        
        //analizadores("src/analizador/", "Lexer.jflex", "Parser.cup");
        
        //Llamada a la funcion analizar:
        String entrada = ("""
                          PROGRAM
                                !
                          	console::print = 34 end; 
                                console::print = 25 end;
                                console::print = 25.4 end;
                                !
                          END PROGRAM
                          """);
        analizar(entrada); 
        
        //FuncionTokens.FuncionDeTokens.listaTokens.add("!"); esto se coloca en Lexer.jflex
        //Con este se recorre la lista de Tokens
        //Se deve de generar un nuevo objeto en el cual se colocque la fila, columna lexema... 
        //y eso se debe de guardar en la listaTokens
        FuncionTokens.FuncionDeTokens.listaTokens.forEach((elemento)-> {
            
           // System.out.println(elemento.toString());
        });
    }
    
    
    //Generador de Analizadores, la cual se encutra en el repo
    public static void analizadores(String ruta, String jflexFile, String cupFile){
        try {
            String opcionesJflex[] =  {ruta+jflexFile,"-d",ruta};
            jflex.Main.generate(opcionesJflex);

            String opcionesCup[] =  {"-destdir", ruta,"-parser","Parser",ruta+cupFile};
            java_cup.Main.main(opcionesCup);
            
        } catch (Exception e) {
            System.out.println("No se ha podido generar los analizadores");
            System.out.println(e);
        }
    }
    
    //Funcion analizar, la cual se encutra en el repo
        // Realizar Analisis
    //Esta funcion recibe un estring u la analiza 
    public static void analizar (String entrada){
        try {
            analizador.Lexer lexer = new analizador.Lexer(new StringReader(entrada));//este es el analizaro lexico 
            analizador.Parser parser = new analizador.Parser(lexer);//lugo lo pasa al parser
            parser.parse();//aqui ya lo traduce
        } catch (Exception e) {//esta son esepciones por si hay errores
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println(e);
        } 
    } 
}
