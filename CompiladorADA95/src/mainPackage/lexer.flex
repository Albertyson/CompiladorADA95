package mainPackage;
import java_cup.runtime.*;

%%

%class lexer
%int
%unicode
%line
%column
%caseless
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
NumeroDecimal = 0 | [1-9](_?[0-9])*
NumeroFloat = 0 | [0-9]+.[0-9](_?[0-9])*
Boolean = true|false
Caracter = \'.\'

/* comments */
Comentario = "--" {InputCaracter}* {FinLinea}?

%state STRING


%%


/* Palabras Reservadas */
<YYINITIAL> "declare"   { System.out.println("<DECLARE "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "do"        { System.out.println("<DO "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "else"      { System.out.println("<ELSE "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "end"       { System.out.println("<END "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "exit"      { System.out.println("<EXIT "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "for"       { System.out.println("<FOR "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "function"  { System.out.println("<FUNCTION "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "goto"      { System.out.println("<GOTO "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "if"        { System.out.println("<IF "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "new"       { System.out.println("<NEW "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "null"      { System.out.println("<NULL "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "out"       { System.out.println("<OUT "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "procedure" { System.out.println("<PROCEDURE "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "return"    { System.out.println("<RETURN "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "then"      { System.out.println("<THEN "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "when"      { System.out.println("<WHEN "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "in"        { System.out.println("<IN "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "while"     { System.out.println("<WHILE "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "loop"      { System.out.println("<LOOP "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "in out"    { System.out.println("<IN_OUT "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "integer"   { System.out.println("<INTEGER "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "boolean"   { System.out.println("<BOOLEAN "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "float"     { System.out.println("<FLOAT "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "put"       { System.out.println("<PUT "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "get"       { System.out.println("<GET "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "with"      { System.out.println("<WITH "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "use"       { System.out.println("<USE "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "is"        { System.out.println("<IS "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "begin"     { System.out.println("<BEGIN "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "mod"       { System.out.println("<MOD "+yyline+":"+yycolumn+">"); return 1; }

/* Operadores */
<YYINITIAL> ":="        { System.out.println("<ASIG, \":=\" "+yyline+":"+yycolumn+">"); return 1; }
//comparacion
<YYINITIAL> "<"         { System.out.println("<OPREL, \"<\" "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> ">"         { System.out.println("<OPREL, \">\" "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "="         { System.out.println("<OPREL, \"=\" "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "/="        { System.out.println("<OPREL, \"/=\" "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> ">="        { System.out.println("<OPREL, \">=\" "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "<="        { System.out.println("<OPREL, \"<=\" "+yyline+":"+yycolumn+">"); return 1; }
//aritmeticos
<YYINITIAL> "+"         { System.out.println("<OPSUMA, \"+\" "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "-"         { System.out.println("<OPRESTA, \"-\" "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "*"         { System.out.println("<OPMULT, \"*\" "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "/"         { System.out.println("<OPDIV, \"/\" "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "**"        { System.out.println("<OPEXP, \"**\" "+yyline+":"+yycolumn+">"); return 1; }
//booleanos
<YYINITIAL> "and"       { System.out.println("<OPBOOL, \"and\" "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "not"       { System.out.println("<OPBOOL, \"not\" "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "or"        { System.out.println("<OPBOOL, \"or\" "+yyline+":"+yycolumn+">"); return 1; }

/* Otros */
<YYINITIAL> "("         { System.out.println("<ABRIRPARENTESIS "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> ")"         { System.out.println("<CERRARPARENTESIS "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> ";"         { System.out.println("<PUNTOCOMA "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "."         { System.out.println("<PUNTO "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> ","         { System.out.println("<COMA "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> ":"         { System.out.println("<DOS PUNTOS "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "#"         { System.out.println("<NUMERAL "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "&"         { System.out.println("<OPCONCAT "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> "'"         { System.out.println("<APOSTROFE "+yyline+":"+yycolumn+">"); return 1; }
<YYINITIAL> ".."         { System.out.println("<RANGO "+yyline+":"+yycolumn+">"); return 1; }

<YYINITIAL> {
    {Identificador}     { System.out.println("<ID, \"" + yytext() + "\" "+yyline+":"+yycolumn+">"); return 1; }
    \"                  { string.setLength(0); yybegin(STRING); }
    {NumeroDecimal}     { System.out.println("<NUM, \"" + yytext() + "\" "+yyline+":"+yycolumn+">"); return 1; }
    {NumeroFloat}       { System.out.println("<FLOAT, \"" + yytext() + "\" "+yyline+":"+yycolumn+">"); return 1; }
    {Boolean}           { System.out.println("<BOOL, \"" + yytext() + "\" "+yyline+":"+yycolumn+">"); return 1; }
    {EspacioBlanco}     {}
    {Comentario}        { System.out.println("<COMENTARIO "+yyline+":"+yycolumn+">");}
    {Caracter}          { System.out.println("<CARACTER, \""+yytext()+"\" "+yyline+":"+yycolumn+">"); }
}

<STRING> {
    \"                  { yybegin(YYINITIAL); System.out.println("<STRING, \"" + string.toString() + "\" "+yyline+":"+yycolumn+">"); return 1; }
    [^\n\r\"\\]+        { string.append( yytext() ); }
    \\t                 { string.append('\t'); }
    \\n                 { string.append('\n'); }
    \\r                 { string.append('\r'); }
    \\\"                { string.append('\"'); }
    \\                  { string.append('\\'); }
}

[^]                     { System.out.println(yyline+":"+yycolumn+"\tNo se encuentra token: " + yytext()); return 1; }