// ------------  Paquete e importaciones ------------
package Analizadores; 

import java_cup.runtime.*;

%%	
//-------> Directivas (No tocar)

%public 
%class Lexer
%cup
%char
%column
%line
%unicode
%ignorecase

%{ 
%} 

// ------> Expresiones Regulares, aqui debo de definir todas las expreciones 

entero = [0-9]+
numero_decimal = ([0-9]+\.[0-9]+)
espacio = [ ]
id = [a-zA-Z@][a-zA-Z0-9_]*|[\"][^\n\"]*[\"]
comentario = ("<!"([^><]|[^!]">"|"!"[^>]|[^<]"!"|"<"[^!])*"!>")|(\!.*)

%%
// ------------  Reglas Lexicas -------------------
//Aqui se llaman a las expreciones regulares, se generan los tokens
//luego de cada declarion debo de ir y declararla en Parser.cup en "Declaración de terminales"


//------> Simbolos
":"       {Funciones.Instruccion.agregarTokens("Lexema: :"); return new Symbol(sym.DOSPUNTOS, yycolumn, yyline, yytext());}
"::"      {Funciones.Instruccion.agregarTokens("Lexema: ::"); return new Symbol(sym.DOBLEDOSPUNTOS, yycolumn, yyline, yytext());}
","       {Funciones.Instruccion.agregarTokens("Lexema: ,"); return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
"("       {Funciones.Instruccion.agregarTokens("Lexema: ("); return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());}
")"       {Funciones.Instruccion.agregarTokens("Lexema: )"); return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());}
";"       {Funciones.Instruccion.agregarTokens("Lexema: ;"); return new Symbol(sym.PUNTOYCOMA, yycolumn, yyline, yytext());}
"="       {Funciones.Instruccion.agregarTokens("Lexema: ="); return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}
"<"       {Funciones.Instruccion.agregarTokens("Lexema: <"); return new Symbol(sym.MENOR, yycolumn, yyline, yytext());}
">"       {Funciones.Instruccion.agregarTokens("Lexema: >"); return new Symbol(sym.MAYOR, yycolumn, yyline, yytext());}
"["       {Funciones.Instruccion.agregarTokens("Lexema: ["); return new Symbol(sym.CORCHETE_A, yycolumn, yyline, yytext());}
"]"       {Funciones.Instruccion.agregarTokens("Lexema: ]"); return new Symbol(sym.CORCHETE_C, yycolumn, yyline, yytext());}
"-"       {Funciones.Instruccion.agregarTokens("Lexema: -"); return new Symbol(sym.GUION, yycolumn, yyline, yytext());}
"PROGRAM"       { return new Symbol(sym.PROGRAM, yycolumn, yyline, yytext());}
"END PROGRAM"       { return new Symbol(sym.END_PROGRAM, yycolumn, yyline, yytext());}
"console"       { return new Symbol(sym.CONSOLE, yycolumn, yyline, yytext());}
"print"       { return new Symbol(sym.PRINT, yycolumn, yyline, yytext());}
"end"       { return new Symbol(sym.END, yycolumn, yyline, yytext());}
"char"       { return new Symbol(sym.CHAR, yycolumn, yyline, yytext());}
"double"       { return new Symbol(sym.DOUBLE, yycolumn, yyline, yytext());}
"var"       { return new Symbol(sym.VAR, yycolumn, yyline, yytext());}
"arr"       { return new Symbol(sym.ARR, yycolumn, yyline, yytext());}
"SUM"       { return new Symbol(sym.SUM, yycolumn, yyline, yytext());}
"RES"       { return new Symbol(sym.RES, yycolumn, yyline, yytext());}
"MUL"       { return new Symbol(sym.MUL, yycolumn, yyline, yytext());}
"DIV"       { return new Symbol(sym.DIV, yycolumn, yyline, yytext());}
"MOD"       { return new Symbol(sym.MOD, yycolumn, yyline, yytext());}
"Media"       { return new Symbol(sym.MEDIA, yycolumn, yyline, yytext());}
"Mediana"       { return new Symbol(sym.MEDIANA, yycolumn, yyline, yytext());}
"Moda"       { return new Symbol(sym.MODA, yycolumn, yyline, yytext());}
"Varianza"       { return new Symbol(sym.VARIANZA, yycolumn, yyline, yytext());}
"Max"       { return new Symbol(sym.MAX, yycolumn, yyline, yytext());}
"Min"       { return new Symbol(sym.MIN, yycolumn, yyline, yytext());}
"column"       { return new Symbol(sym.COLUMN, yycolumn, yyline, yytext());}
//Grafica de barras
"graphBar"       { return new Symbol(sym.GRAPHBAR, yycolumn, yyline, yytext());}
"titulo"       { return new Symbol(sym.TITULO, yycolumn, yyline, yytext());}
"ejeX"       { return new Symbol(sym.EJEX, yycolumn, yyline, yytext());}
"ejeY"       { return new Symbol(sym.EJEY, yycolumn, yyline, yytext());}
"tituloX"       { return new Symbol(sym.TITULOX, yycolumn, yyline, yytext());}
"tituloY"       { return new Symbol(sym.TITULOY, yycolumn, yyline, yytext());}
"EXEC"       { return new Symbol(sym.EXEC, yycolumn, yyline, yytext());}
//Grafica de Pie
"graphPie"       { return new Symbol(sym.GRAPHPIE, yycolumn, yyline, yytext());}
"label"       { return new Symbol(sym.LABEL, yycolumn, yyline, yytext());}
"values"       { return new Symbol(sym.VALUES, yycolumn, yyline, yytext());}


//------> Operadores


//------> Expresiones
{espacio} {}
{entero}            { return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }
{numero_decimal}    { return new Symbol(sym.NUMERODECIMAL, yycolumn, yyline, yytext()); }
{id}            { return new Symbol(sym.ID, yycolumn, yyline, yytext()); }
{comentario}          {}



//------> Ignorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
.           	{   Funciones.Instruccion.agregarError("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); 
                    System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); 
                }
