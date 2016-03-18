package mainPackage;
import java_cup.runtime.*;

%%

%class Lexer
%unicode
%line
%column
%caseless
%cup

%{
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}

%eofval{ 
    return symbol(sym.EOF);
%eofval}


FinLinea = \r|\n|\r\n
InputCaracter = [^\r\n]
EspacioBlanco = {FinLinea} | [ \t\f]
Identificador = [:jletter:] [:jletterdigit:]*
NumeroEntero = 0 | [1-9](_?[0-9])*
NumeroFloat = 0 | [0-9]+.[0-9](_?[0-9])*

/* comments */
Comentario = "--" {InputCaracter}* {FinLinea}?

%state STRING


%%


/* Palabras Reservadas */
<YYINITIAL> "declare"   { System.out.println("<DECLARE " + (yyline+1) + ":" + yycolumn + ">"); return symbol(sym.DECLARE); }
<YYINITIAL> "else"      { System.out.println("<ELSE " + (yyline + 1) + ":" + yycolumn + ">"); return symbol(sym.ELSE); }
<YYINITIAL> "elsif"      { System.out.println("<ELSE " + (yyline + 1) + ":" + yycolumn + ">"); return symbol(sym.ELSIF); }
<YYINITIAL> "end"       { System.out.println("<END " + (yyline + 1) + ":" + yycolumn + ">"); return symbol(sym.END); }
<YYINITIAL> "exit"      { System.out.println("<EXIT " + (yyline+1)+":"+yycolumn+">"); return symbol(sym.EXIT); }
<YYINITIAL> "for"       { System.out.println("<FOR " + (yyline + 1) + ":" + yycolumn + ">"); return symbol(sym.FOR); }
<YYINITIAL> "function"  { System.out.println("<FUNCTION "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.FUNCTION); }
<YYINITIAL> "if"        { System.out.println("<IF "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.IF); }
<YYINITIAL> "new"       { System.out.println("<NEW "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.NEW); }
<YYINITIAL> "null"      { System.out.println("<NULL "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.NULL); }
<YYINITIAL> "out"       { System.out.println("<OUT "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OUT); }
<YYINITIAL> "procedure" { System.out.println("<PROCEDURE "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.PROCEDURE); }
<YYINITIAL> "return"    { System.out.println("<RETURN "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.RETURN); }
<YYINITIAL> "then"      { System.out.println("<THEN "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.THEN); }
<YYINITIAL> "when"      { System.out.println("<WHEN "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.WHEN); }
<YYINITIAL> "in"        { System.out.println("<IN "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.IN); }
<YYINITIAL> "while"     { System.out.println("<WHILE "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.WHILE); }
<YYINITIAL> "loop"      { System.out.println("<LOOP "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.LOOP); }
<YYINITIAL> "in out"    { System.out.println("<IN_OUT "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.INOUT); }
<YYINITIAL> "integer"   { System.out.println("<INTEGER "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.INTEGER); }
<YYINITIAL> "boolean"   { System.out.println("<BOOLEAN "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.BOOLEAN); }
<YYINITIAL> "float"     { System.out.println("<FLOAT "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.FLOAT); }
<YYINITIAL> "put"       { System.out.println("<PUT "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.PUT); }
<YYINITIAL> "get"       { System.out.println("<GET "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.GET); }
<YYINITIAL> "is"        { System.out.println("<IS "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.IS); }
<YYINITIAL> "begin"     { System.out.println("<BEGIN "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.BEGIN); }
<YYINITIAL> "true"      { System.out.println("<TRUE "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.TRUE); }
<YYINITIAL> "false"     { System.out.println("<FALSE "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.FALSE); }

/* Operadores */
<YYINITIAL> ":="        { System.out.println("<ASIG, \":=\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OPERASIG); }

//comparacion
<YYINITIAL> "<"         { System.out.println("<OPREL, \"<\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OPERMENOR); }
<YYINITIAL> ">"         { System.out.println("<OPREL, \">\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OPERMAYOR); }
<YYINITIAL> "="         { System.out.println("<OPREL, \"=\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OPERIGUAL); }
<YYINITIAL> "/="        { System.out.println("<OPREL, \"/=\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OPERDISTINTO); }
<YYINITIAL> ">="        { System.out.println("<OPREL, \">=\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OPERMAYORIGUAL); }
<YYINITIAL> "<="        { System.out.println("<OPREL, \"<=\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OPERMENORIGUAL); }

//aritmeticos
<YYINITIAL> "+"         { System.out.println("<OPSUMA, \"+\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OPERSUMA); }
<YYINITIAL> "-"         { System.out.println("<OPRESTA, \"-\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OPERRESTA); }
<YYINITIAL> "*"         { System.out.println("<OPMULT, \"*\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OPERMULTIPLICACION); }
<YYINITIAL> "/"         { System.out.println("<OPDIV, \"/\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OPERDIVISION); }
<YYINITIAL> "**"        { System.out.println("<OPEXP, \"**\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OPERPOTENCIA); }

//booleanos
<YYINITIAL> "and"       { System.out.println("<OPBOOL, \"and\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.AND); }
<YYINITIAL> "not"       { System.out.println("<OPBOOL, \"not\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.OR); }
<YYINITIAL> "or"        { System.out.println("<OPBOOL, \"or\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.NOT); }

/* Otros */
<YYINITIAL> "("         { System.out.println("<ABRIRPARENTESIS "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.PARIZQ); }
<YYINITIAL> ")"         { System.out.println("<CERRARPARENTESIS "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.PARDER); }
<YYINITIAL> ";"         { System.out.println("<PUNTOCOMA "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.PUNTOCOMA); }
<YYINITIAL> ".."        { System.out.println("<RANGO "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.DOBLEPUNTO); }
<YYINITIAL> ","         { System.out.println("<COMA "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.COMA); }
<YYINITIAL> ":"         { System.out.println("<DOS PUNTOS "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.DOSPUNTOS); }

<YYINITIAL> {
    {Identificador}     { System.out.println("<ID, \"" + yytext() + "\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.ID, yytext()); }
    \"                  { string.setLength(0); yybegin(STRING); }
    {NumeroEntero}      { System.out.println("<INT, \"" + yytext() + "\" " + (yyline + 1) + ":" + yycolumn + ">"); return symbol(sym.NUMEROENTERO, new Integer(Integer.parseInt(yytext()))); }
    {NumeroFloat}       { System.out.println("<FLOAT, \"" + yytext() + "\" " + (yyline + 1) + ":" + yycolumn + ">"); return symbol(sym.NUMEROFLOAT, new Double(Double.parseDouble(yytext()))); }
    {EspacioBlanco}     { /* ignore */ }
    {Comentario}        { /* ignore */ }
}

<STRING> {
    \"                  { yybegin(YYINITIAL); System.out.println("<STRING, \"" + string.toString() + "\" "+(yyline+1)+":"+yycolumn+">"); return symbol(sym.CADENA, string.toString()); }
    [^\n\r\"\\]+        { string.append( yytext() ); }
    \\t                 { string.append('\t'); }
    \\n                 { string.append('\n'); }
    \\r                 { string.append('\r'); }
    \\\"                { string.append('\"'); }
    \\                  { string.append('\\'); }
}

[^]                     { throw new Error("Illegal character <" + yytext() + ">"); } //{ System.out.println((yyline+1)+":"+yycolumn+"\tNo se encuentra token: " + yytext()); return 0; }
