
package FuncionTokens;


public class Expresion {
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
}
