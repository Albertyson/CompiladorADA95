package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;


public class Negative extends ArithmeticExpression {
    public Expression exp;
    public int line, column;

    public Negative(Expression exp, int l, int c) {
        this.exp = exp;
        this.line = l;
        this.column = c;
    }


    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }
@Override
    public String generate(IntermediateGenerable IG) {
        return IG.visit(this);
    }
    
}
