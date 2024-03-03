// ------------  Paquete e importaciones ------------
package Analizadores; 

import java_cup.runtime.*;
import Funciones.Tokens;
import Funciones.Errores;

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
Tokens token;
Errores error; 
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
":"       {token = new Tokens(":", "Simbolo", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.DOSPUNTOS, yycolumn, yyline, yytext());}
"::"      {token = new Tokens("::", "Simbolo", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.DOBLEDOSPUNTOS, yycolumn, yyline, yytext());}
","       {token = new Tokens(",", "Simbolo", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
"("       {token = new Tokens("(", "Simbolo", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());}
")"       {token = new Tokens(")", "Simbolo", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());}
";"       {token = new Tokens(";", "Simbolo", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.PUNTOYCOMA, yycolumn, yyline, yytext());}
"="       {token = new Tokens("=", "Simbolo", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}
"<"       {token = new Tokens("<", "Simbolo", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.MENOR, yycolumn, yyline, yytext());}
">"       {token = new Tokens(">", "Simbolo", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.MAYOR, yycolumn, yyline, yytext());}
"["       {token = new Tokens("[", "Simbolo", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.CORCHETE_A, yycolumn, yyline, yytext());}
"]"       {token = new Tokens("]", "Simbolo", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.CORCHETE_C, yycolumn, yyline, yytext());}
"-"       {token = new Tokens("-", "Simbolo", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.GUION, yycolumn, yyline, yytext());}
//------> Instrucciones
"PROGRAM"           { token = new Tokens("PROGRAM", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.PROGRAM, yycolumn, yyline, yytext());}
"END PROGRAM"       {token = new Tokens("END PROGRAM", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.END_PROGRAM, yycolumn, yyline, yytext());}
"console"           {token = new Tokens("console", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.CONSOLE, yycolumn, yyline, yytext());}
"print"             {token = new Tokens("print", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.PRINT, yycolumn, yyline, yytext());}
"end"               {token = new Tokens("end", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.END, yycolumn, yyline, yytext());}
"char"              {token = new Tokens("char", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.CHAR, yycolumn, yyline, yytext());}
"double"            {token = new Tokens("double", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.DOUBLE, yycolumn, yyline, yytext());}
"var"               {token = new Tokens("var", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.VAR, yycolumn, yyline, yytext());}
"arr"               {token = new Tokens("arr", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.ARR, yycolumn, yyline, yytext());}
"SUM"               {token = new Tokens("SUM", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.SUM, yycolumn, yyline, yytext());}
"RES"               {token = new Tokens("RES", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.RES, yycolumn, yyline, yytext());}
"MUL"               {token = new Tokens("MUL", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.MUL, yycolumn, yyline, yytext());}
"DIV"               {token = new Tokens("DIV", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.DIV, yycolumn, yyline, yytext());}
"MOD"               {token = new Tokens("MOD", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.MOD, yycolumn, yyline, yytext());}
"Media"             {token = new Tokens("Media", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.MEDIA, yycolumn, yyline, yytext());}
"Mediana"           {token = new Tokens("Mediana", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.MEDIANA, yycolumn, yyline, yytext());}
"Moda"              {token = new Tokens("Moda", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.MODA, yycolumn, yyline, yytext());}
"Varianza"          {token = new Tokens("Varianza", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.VARIANZA, yycolumn, yyline, yytext());}
"Max"               {token = new Tokens("Max", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.MAX, yycolumn, yyline, yytext());}
"Min"               {token = new Tokens("Min", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.MIN, yycolumn, yyline, yytext());}
"column"            {token = new Tokens("column", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.COLUMN, yycolumn, yyline, yytext());}
//Grafica de barras
"graphBar"          {token = new Tokens("graphBar", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.GRAPHBAR, yycolumn, yyline, yytext());}
"titulo"            {token = new Tokens("titulo", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.TITULO, yycolumn, yyline, yytext());}
"ejeX"              {token = new Tokens("ejeX", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.EJEX, yycolumn, yyline, yytext());}
"ejeY"              {token = new Tokens("ejeY", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.EJEY, yycolumn, yyline, yytext());}
"tituloX"           {token = new Tokens("tituloX", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.TITULOX, yycolumn, yyline, yytext());}
"tituloY"           {token = new Tokens("tituloY", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.TITULOY, yycolumn, yyline, yytext());}
"EXEC"              {token = new Tokens("EXEC", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.EXEC, yycolumn, yyline, yytext());}
//Grafica de Pie
"graphPie"          {token = new Tokens("graphPie", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.GRAPHPIE, yycolumn, yyline, yytext());}
"label"             {token = new Tokens("label", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.LABEL, yycolumn, yyline, yytext());}
"values"            {token = new Tokens("values", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.VALUES, yycolumn, yyline, yytext());}
//Grafica de Linea
"graphLine"         {token = new Tokens("graphLine", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.GRAPHLINE, yycolumn, yyline, yytext());}
//Grafica de Histograma
"Histogram"         {token = new Tokens("Histogram", "Instruccion", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.HISTOGRAM, yycolumn, yyline, yytext());}


//------> Operadores


//------> Expresiones
{espacio}           {}
{entero}            {token = new Tokens(yytext(), "Int", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }
{numero_decimal}    {token = new Tokens(yytext(), "Double", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.NUMERODECIMAL, yycolumn, yyline, yytext()); }
{id}                {token = new Tokens(yytext(), "Id", yyline, yycolumn); Funciones.Instruccion.agregarTokens(token); return new Symbol(sym.ID, yycolumn, yyline, yytext()); }
{comentario}        {}



//------> Ignorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
.           	{ error = new Errores("Lexico","El caracter "+ yytext() + " no pertenece al lenguaje.", yyline, yycolumn); Funciones.Instruccion.agregarError(error); 
                    //System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); 
                }
