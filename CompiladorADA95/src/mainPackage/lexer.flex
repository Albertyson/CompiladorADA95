package mainPackage;
import java_cup.runtime.*;

%%

%class Lexer2
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
Caracter    = '\w'

/* comments */
Comentario = "--" {InputCaracter}* {FinLinea}?

%state STRING


%%


/* Palabras Reservadas */
<YYINITIAL> "declare"   {  return symbol(sym.DECLARE); }
<YYINITIAL> "else"      {  return symbol(sym.ELSE); }
<YYINITIAL> "elsif"     {  return symbol(sym.ELSIF); }
<YYINITIAL> "end"       {  return symbol(sym.END); }
<YYINITIAL> "exit"      {  return symbol(sym.EXIT); }
<YYINITIAL> "for"       {  return symbol(sym.FOR); }
<YYINITIAL> "function"  {  return symbol(sym.FUNCTION); }
<YYINITIAL> "if"        {  return symbol(sym.IF); }
<YYINITIAL> "null"      {  return symbol(sym.NULL); }
<YYINITIAL> "out"       {  return symbol(sym.OUT); }
<YYINITIAL> "procedure" {  return symbol(sym.PROCEDURE); }
<YYINITIAL> "return"    {  return symbol(sym.RETURN); }
<YYINITIAL> "then"      {  return symbol(sym.THEN); }
<YYINITIAL> "when"      {  return symbol(sym.WHEN); }
<YYINITIAL> "in"        {  return symbol(sym.IN); }
<YYINITIAL> "while"     {  return symbol(sym.WHILE); }
<YYINITIAL> "loop"      {  return symbol(sym.LOOP); }
<YYINITIAL> "in out"    {  return symbol(sym.INOUT); }
<YYINITIAL> "integer"   {  return symbol(sym.INTEGER); }
<YYINITIAL> "boolean"   {  return symbol(sym.BOOLEAN); }
<YYINITIAL> "float"     {  return symbol(sym.FLOAT); }
<YYINITIAL> "put"       {  return symbol(sym.PUT); }
<YYINITIAL> "get"       {  return symbol(sym.GET); }
<YYINITIAL> "is"        {  return symbol(sym.IS); }
<YYINITIAL> "begin"     {  return symbol(sym.BEGIN); }
<YYINITIAL> "true"      {  return symbol(sym.TRUE); }
<YYINITIAL> "false"     {  return symbol(sym.FALSE); }
<YYINITIAL> "character" {  return symbol(sym.CHARACTER); }
<YYINITIAL> "string"    {  return symbol(sym.STRING); }
<YYINITIAL> "case"      {  return symbol(sym.CASE); }
<YYINITIAL> "others"    {  return symbol(sym.OTHERS); }

/* Operadores */
<YYINITIAL> ":="        {  return symbol(sym.OPERASIG); }

//comparacion
<YYINITIAL> "<"         {  return symbol(sym.OPERMENOR); }
<YYINITIAL> ">"         {  return symbol(sym.OPERMAYOR); }
<YYINITIAL> "="         {  return symbol(sym.OPERIGUAL); }
<YYINITIAL> "/="        {  return symbol(sym.OPERDISTINTO); }
<YYINITIAL> ">="        {  return symbol(sym.OPERMAYORIGUAL); }
<YYINITIAL> "<="        {  return symbol(sym.OPERMENORIGUAL); }

//aritmeticos
<YYINITIAL> "+"         {  return symbol(sym.OPERSUMA); }
<YYINITIAL> "-"         {  return symbol(sym.OPERRESTA); }
<YYINITIAL> "*"         {  return symbol(sym.OPERMULTIPLICACION); }
<YYINITIAL> "/"         {  return symbol(sym.OPERDIVISION); }
<YYINITIAL> "**"        {  return symbol(sym.OPERPOTENCIA); }

//booleanos
<YYINITIAL> "and"       {  return symbol(sym.AND); }
<YYINITIAL> "not"       {  return symbol(sym.NOT); }
<YYINITIAL> "or"        {  return symbol(sym.OR); }

/* Otros */
<YYINITIAL> "("         {  return symbol(sym.PARIZQ); }
<YYINITIAL> ")"         {  return symbol(sym.PARDER); }
<YYINITIAL> ";"         {  return symbol(sym.PUNTOCOMA); }
<YYINITIAL> ".."        {  return symbol(sym.DOBLEPUNTO); }
<YYINITIAL> ","         {  return symbol(sym.COMA); }
<YYINITIAL> ":"         {  return symbol(sym.DOSPUNTOS); }
<YYINITIAL> "&"         {  return symbol(sym.AMPERSAND); }
<YYINITIAL> "=>"        {  return symbol(sym.OPERPUNTERO); }

<YYINITIAL> {
    {Identificador}     { return symbol(sym.ID, yytext()); }
    \"                  { string.setLength(0); yybegin(STRING); }
    {NumeroEntero}      { return symbol(sym.NUMEROENTERO, new Integer(Integer.parseInt(yytext()))); }
    {NumeroFloat}       { return symbol(sym.NUMEROFLOAT, new Double(Double.parseDouble(yytext()))); }
    {EspacioBlanco}     { /* ignore */ }
    {Comentario}        { /* ignore */ }
    {Caracter}          { return symbol(sym.CARACTER, yytext());}
}

<STRING> {
    \"                  { yybegin(YYINITIAL); return symbol(sym.CADENA, string.toString()); }
    [^\n\r\"\\]+        { string.append( yytext() ); }
    \\t                 { string.append('\t'); }
    \\n                 { string.append('\n'); }
    \\r                 { string.append('\r'); }
    \\\"                { string.append('\"'); }
    \\                  { string.append('\\'); }
}

[^]                     { System.out.println((yyline+1)+":"+yycolumn+"\tNo se encuentra token: " + yytext());}//throw new Error("Illegal character <" + yytext() + ">"); } //{ System.out.println((yyline+1)+":"+yycolumn+"\tNo se encuentra token: " + yytext()); return 0; }
