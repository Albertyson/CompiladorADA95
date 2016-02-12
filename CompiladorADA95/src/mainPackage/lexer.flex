package mainPackage;
import java_cup.runtime.*;

%%

%class lexer
%int
%unicode
%line
%column
//%cup

%{
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}

FinLinea = \r|\n|\r\n
InputCaracter = [^\r\n]
EspacioBlanco = {FinLinea} | [ \t\f]
Identificador = [:jletter:] [:jletterdigit:]*
NumeroDecimal = 0 | [1-9][0-9]*
NumeroFloat = 0 | [0-9]+.[0-9]+
Boolean = true|false

/* comments */
Comentario = "--" {InputCaracter}* {FinLinea}?

%state STRING


%%


/* Palabras Reservadas */
<YYINITIAL> "declare"   { System.out.println("<DECLARE>"); return 1; }
<YYINITIAL> "do"        { System.out.println("<DO>"); return 1; }
<YYINITIAL> "else"      { System.out.println("<ELSE>"); return 1; }
<YYINITIAL> "end"       { System.out.println("<END>"); return 1; }
<YYINITIAL> "exit"      { System.out.println("<EXIT>"); return 1; }
<YYINITIAL> "for"       { System.out.println("<FOR>"); return 1; }
<YYINITIAL> "function"  { System.out.println("<FUNCTION>"); return 1; }
<YYINITIAL> "goto"      { System.out.println("<GOTO>"); return 1; }
<YYINITIAL> "if"        { System.out.println("<IF>"); return 1; }
<YYINITIAL> "new"       { System.out.println("<NEW>"); return 1; }
<YYINITIAL> "null"      { System.out.println("<NULL>"); return 1; }
<YYINITIAL> "out"       { System.out.println("<OUT>"); return 1; }
<YYINITIAL> "procedure" { System.out.println("<PROCEDURE>"); return 1; }
<YYINITIAL> "return"    { System.out.println("<RETURN>"); return 1; }
<YYINITIAL> "then"      { System.out.println("<THEN>"); return 1; }
<YYINITIAL> "when"      { System.out.println("<WHEN>"); return 1; }
<YYINITIAL> "in"        { System.out.println("<IN>"); return 1; }
<YYINITIAL> "while"     { System.out.println("<WHILE>"); return 1; }
<YYINITIAL> "loop"      { System.out.println("<LOOP>"); return 1; }
<YYINITIAL> "in out"    { System.out.println("<IN_OUT>"); return 1; }
<YYINITIAL> "integer"   { System.out.println("<INTEGER>"); return 1; }
<YYINITIAL> "boolean"   { System.out.println("<BOOLEAN>"); return 1; }
<YYINITIAL> "float"     { System.out.println("<FLOAT>"); return 1; }
<YYINITIAL> "put"       { System.out.println("<PUT>"); return 1; }
<YYINITIAL> "get"       { System.out.println("<GET>"); return 1; }
<YYINITIAL> "with"      { System.out.println("<WITH>"); return 1; }
<YYINITIAL> "use"       { System.out.println("<USE>"); return 1; }
<YYINITIAL> "is"        { System.out.println("<IS>"); return 1; }
<YYINITIAL> "begin"     { System.out.println("<BEGIN>"); return 1; }

/* Operadores */
<YYINITIAL> ":="        { System.out.println("<ASIG, \":=\">"); return 1; }

<YYINITIAL> "<"         { System.out.println("<OPREL, \"<\">"); return 1; }
<YYINITIAL> ">"         { System.out.println("<OPREL, \">\">"); return 1; }
<YYINITIAL> "="         { System.out.println("<OPREL, \"=\">"); return 1; }
<YYINITIAL> "/="        { System.out.println("<OPREL, \"/=\">"); return 1; }
<YYINITIAL> ">="        { System.out.println("<OPREL, \">=\">"); return 1; }
<YYINITIAL> "<="        { System.out.println("<OPREL, \"<=\">"); return 1; }

<YYINITIAL> "+"         { System.out.println("<OPSUMA, \"+\">"); return 1; }
<YYINITIAL> "-"         { System.out.println("<OPRESTA, \"-\">"); return 1; }
<YYINITIAL> "*"         { System.out.println("<OPMULT, \"*\">"); return 1; }
<YYINITIAL> "/"         { System.out.println("<OPDIV, \"/\">"); return 1; }
<YYINITIAL> "**"        { System.out.println("<OPEXP, \"**\">"); return 1; }

<YYINITIAL> "and"       { System.out.println("<OPBOOL, \"and\">"); return 1; }
<YYINITIAL> "not"       { System.out.println("<OPBOOL, \"not\">"); return 1; }
<YYINITIAL> "or"        { System.out.println("<OPBOOL, \"or\">"); return 1; }

/* Otros */
<YYINITIAL> "("         { System.out.println("<ABRIRPARENTESIS>"); return 1; }
<YYINITIAL> ")"         { System.out.println("<CERRARPARENTESIS>"); return 1; }
<YYINITIAL> ";"         { System.out.println("<PUNTOCOMA>"); return 1; }

<YYINITIAL> {
    {Identificador}     { System.out.println("<ID, \"" + yytext() + "\">"); return 1; }
    \"                      { string.setLength(0); yybegin(STRING); }
    {NumeroDecimal}     { System.out.println("<NUM, \"" + yytext() + "\">"); return 1; }
    {NumeroFloat}       { System.out.println("<FLOAT, \"" + yytext() + "\">"); return 1; }
    {Boolean}           { System.out.println("<BOOL, \"" + yytext() + "\">"); return 1; }
    {EspacioBlanco}     {}
    {Comentario}        {}
}

<STRING> {
    \"                  { yybegin(YYINITIAL); System.out.println("<STRING, \"" + string.toString() + "\">"); return 1; }
    [^\n\r\"\\]+        { string.append( yytext() ); }
    \\t                 { string.append('\t'); }
    \\n                 { string.append('\n'); }
    \\r                 { string.append('\r'); }
    \\\"                { string.append('\"'); }
    \\                  { string.append('\\'); }
}

[^]                     { System.out.println("No se encuentra token: " + yytext()); return 0; }