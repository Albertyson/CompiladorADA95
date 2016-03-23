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
import abstractSyntaxTree.CaseNotOthers;
import abstractSyntaxTree.CaseOthers;
import abstractSyntaxTree.Division;
import abstractSyntaxTree.Equal;
import abstractSyntaxTree.Exit;
import abstractSyntaxTree.For;
import abstractSyntaxTree.FunctionCall;
import abstractSyntaxTree.FunctionParameters;
import abstractSyntaxTree.GetValue;
import abstractSyntaxTree.Greater;
import abstractSyntaxTree.GreaterOrEqual;
import abstractSyntaxTree.Less;
import abstractSyntaxTree.LessOrEqual;
import abstractSyntaxTree.Loop;
import abstractSyntaxTree.Module;
import abstractSyntaxTree.Multiplication;
import abstractSyntaxTree.Negative;
import abstractSyntaxTree.Not;
import abstractSyntaxTree.NotEqual;
import abstractSyntaxTree.Or;
import abstractSyntaxTree.Pow;
import abstractSyntaxTree.PutValue;
import abstractSyntaxTree.Range;
import abstractSyntaxTree.Return;
import abstractSyntaxTree.Statements;
import abstractSyntaxTree.TypeBoolean;
import abstractSyntaxTree.TypeFloat;
import abstractSyntaxTree.TypeInteger;
import abstractSyntaxTree.TypeString;
import abstractSyntaxTree.VariableIDs;
import abstractSyntaxTree.WhenOption;
import abstractSyntaxTree.WhenOptions;
import abstractSyntaxTree.While;


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
    public void path(VariableIDs h);
    public void path(TypeInteger h); 
    public void path(TypeBoolean h);
    public void path(TypeFloat h);
    public void path(TypeString h);
    public void path(GetValue h);
    public void path(PutValue h);
    public void path(While h);
    public void path(Statements h);
    public void path(Range h);
    public void path(For h);
    public void path(Exit h);
    public void path(Loop h);
    public void path(Return h);
    public void path(WhenOption h);
    public void path(WhenOptions h);
    public void path(CaseOthers h);
    public void path(CaseNotOthers h);
    
}
