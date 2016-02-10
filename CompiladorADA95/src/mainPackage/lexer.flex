package mainPackage;
import java_cup.runtime.*;
%%
%class lexer
%int
%unicode
//%cup
%line
%column
/*operadores comparación*/
operAsignacion=":="
operMenorQue="<"
operMayorQue=">"
operIgual="="
operDistinto="/="
operMayorIgual=">="
operMenorIgual="<="
/*operadores aritmeticos*/
operSuma="+"
operResta="-"
operMultiplicacion="*"
operDivision="/"
operExponencial="**"
/*operadores Agrupacion*/
inicioParentesis="("
finParentesis=")"
/*operadores Logicos*/
and="and"
not="not"
or="or"
/*%{
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}*/
%%
<YYINITIAL> "declare" {System.out.println("declare"); return 1;}
<YYINITIAL> "do" {System.out.println("do"); return 1;}
<YYINITIAL> "else" {System.out.println("else"); return 1;}
<YYINITIAL> "end" {System.out.println("end"); return 1;}
<YYINITIAL> "exit" {System.out.println("exit"); return 1;}
<YYINITIAL> "for" {System.out.println("for"); return 1;}
<YYINITIAL> "function" {System.out.println("function"); return 1;}
<YYINITIAL> "goto" {System.out.println("goto"); return 1;}
<YYINITIAL> "if" {System.out.println("if"); return 1;}
<YYINITIAL> "new" {System.out.println("new"); return 1;}
<YYINITIAL> "null" {System.out.println("null"); return 1;}
<YYINITIAL> "out" {System.out.println("out"); return 1;}
<YYINITIAL> "procedure" {System.out.println("procedure"); return 1;}
<YYINITIAL> "return" {System.out.println("return"); return 1;}
<YYINITIAL> "then" {System.out.println("then"); return 1;}
<YYINITIAL> "when" {System.out.println("when"); return 1;}
<YYINITIAL> "in" {System.out.println("in"); return 1;}
<YYINITIAL> "while" {System.out.println("while"); return 1;}
<YYINITIAL> "loop" {System.out.println("loop"); return 1;}
<YYINITIAL> "in out" {System.out.println("in out"); return 1;}
<YYINITIAL> "integer" {System.out.println("integer"); return 1;}
<YYINITIAL> "boolean" {System.out.println("boolean"); return 1;}
<YYINITIAL> "float" {System.out.println("float"); return 1;}
/*operadores*/
<YYINITIAL> ":=" {System.out.println("Operador Asignacion"); return 1;}
<YYINITIAL> "<" {System.out.println("Operador Menor que"); return 1;}
<YYINITIAL> ">" {System.out.println("Operador Mayor que"); return 1;}
<YYINITIAL> "=" {System.out.println("Operador Igual que"); return 1;}
<YYINITIAL> "/=" {System.out.println("Operador Distinto que"); return 1;}
<YYINITIAL> ">=" {System.out.println("Operador Mayor o igual que"); return 1;}
<YYINITIAL> "<=" {System.out.println("Operador Menor o igual que"); return 1;}
<YYINITIAL> "+" {System.out.println("Operador Suma"); return 1;}
<YYINITIAL> "-" {System.out.println("Operador Resta"); return 1;}
<YYINITIAL> "*" {System.out.println("Operador Multiplicacion"); return 1;}
<YYINITIAL> "/" {System.out.println("Operador Division"); return 1;}
<YYINITIAL> "**" {System.out.println("Operador Potencia"); return 1;}
<YYINITIAL> "(" {System.out.println("Inicio Parentesis"); return 1;}
<YYINITIAL> ")" {System.out.println("Fin Parentesis"); return 1;}
<YYINITIAL> "and" {System.out.println("and"); return 1;}
<YYINITIAL> "not" {System.out.println("not"); return 1;}
<YYINITIAL> "or" {System.out.println("or"); return 1;}
<YYINITIAL>{
    . {System.out.println("No se encuentra token "+yytext());}
}