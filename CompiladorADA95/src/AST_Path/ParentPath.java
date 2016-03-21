package AST_Path;

import abstractSyntaxTree.FloatNumber;
import abstractSyntaxTree.IntegerNumber;
import abstractSyntaxTree.True;
import abstractSyntaxTree.False;
import abstractSyntaxTree.Identifier;
import abstractSyntaxTree.Minus;
import abstractSyntaxTree.StringLiteral;
import abstractSyntaxTree.Add;
import abstractSyntaxTree.And;
import abstractSyntaxTree.Division;
import abstractSyntaxTree.Equal;
import abstractSyntaxTree.FunctionCall;
import abstractSyntaxTree.FunctionParameters;
import abstractSyntaxTree.Greater;
import abstractSyntaxTree.GreaterOrEqual;
import abstractSyntaxTree.Less;
import abstractSyntaxTree.LessOrEqual;
import abstractSyntaxTree.Module;
import abstractSyntaxTree.Multiplication;
import abstractSyntaxTree.Negative;
import abstractSyntaxTree.Not;
import abstractSyntaxTree.NotEqual;
import abstractSyntaxTree.Or;
import abstractSyntaxTree.Pow;


public interface ParentPath {
    
    public void path(IntegerNumber h);
    public void path(FloatNumber h);
    public void path(True h);
    public void path(False h);
    public void path(StringLiteral h);
    public void path(Identifier h);
    public void path(Add h);
    public void path(Minus h);
    
    // Agregar clases abstractas, tienen que estar todas

    public void path(Division h);
    public void path(Multiplication h);
    public void path(Pow h);
    public void path(Negative h);
    public void path(Module h);
    public void path(Equal h);
    public void path(NotEqual h);
    public void path(Greater h);
    public void path(Less h);
    public void path(GreaterOrEqual h);
    public void path(LessOrEqual h);
    public void path(And h);
    public void path(Or h);
    public void path(Not h);
    public void path(FunctionCall h);
    public void path(FunctionParameters h);
    
}
