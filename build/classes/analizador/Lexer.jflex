// ------------  Paquete e importaciones ------------
package analizador; 

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
id = [a-zA-Z][a-zA-Z0-9_]*
comentario = ("<!"([^><]|[^!]">"|"!"[^>]|[^<]"!"|"<"[^!])*"!>")|(\!.*)

%%
// ------------  Reglas Lexicas -------------------, es decir aqui se llaman a las expreciones regulares, se generan los tokens
//luego de cada declarion debo de ir y declararla en Parser.cup en "Declaración de terminales"


//------> Simbolos
":"       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: :"); return new Symbol(sym.DOSPUNTOS, yycolumn, yyline, yytext());}
"::"      {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: ::"); return new Symbol(sym.DOBLEDOSPUNTOS, yycolumn, yyline, yytext());}
","       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: ,"); return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
"("       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: ("); return new Symbol(sym.PARENTESIS_A, yycolumn, yyline, yytext());}
")"       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: )"); return new Symbol(sym.PARENTESIS_C, yycolumn, yyline, yytext());}
";"       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: ;"); return new Symbol(sym.PUNTOYCOMA, yycolumn, yyline, yytext());}
"="       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: ="); return new Symbol(sym.IGUAL, yycolumn, yyline, yytext());}
"<"       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: <"); return new Symbol(sym.MENOR, yycolumn, yyline, yytext());}
">"       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: >"); return new Symbol(sym.MAYOR, yycolumn, yyline, yytext());}
"["       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: ["); return new Symbol(sym.CORCHETE_A, yycolumn, yyline, yytext());}
"]"       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: ]"); return new Symbol(sym.CORCHETE_C, yycolumn, yyline, yytext());}
"-"       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: -"); return new Symbol(sym.GUION, yycolumn, yyline, yytext());}
"\""       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: \""); return new Symbol(sym.COMILLAS, yycolumn, yyline, yytext());}
"PROGRAM"       { return new Symbol(sym.PROGRAM, yycolumn, yyline, yytext());}
"END PROGRAM"       { return new Symbol(sym.END_PROGRAM, yycolumn, yyline, yytext());}
"console"       { return new Symbol(sym.CONSOLE, yycolumn, yyline, yytext());}
"print"       { return new Symbol(sym.PRINT, yycolumn, yyline, yytext());}
"end"       { return new Symbol(sym.END, yycolumn, yyline, yytext());}
"char"       { return new Symbol(sym.CHAR, yycolumn, yyline, yytext());}
"double"       { return new Symbol(sym.DOUBLE, yycolumn, yyline, yytext());}
"var"       { return new Symbol(sym.VAR, yycolumn, yyline, yytext());}


//------> Operadores
"+"       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: +"); return new Symbol(sym.MAS, yycolumn, yyline, yytext());}
"*"       {FuncionTokens.FuncionDeTokens.listaTokens.add("Lexema: *"); return new Symbol(sym.POR, yycolumn, yyline, yytext());}


//------> Expresiones
{entero}            { return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }
{numero_decimal}    { return new Symbol(sym.NUMERODECIMAL, yycolumn, yyline, yytext()); }
{id}            { return new Symbol(sym.ID, yycolumn, yyline, yytext()); }
{comentario}          {}


//------> Ignorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
.           	{ System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); }
