
package FuncionTokens;


public class Expresion {
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
}
