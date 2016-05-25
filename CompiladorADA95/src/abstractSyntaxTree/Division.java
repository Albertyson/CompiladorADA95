package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public class Division extends ArithmeticExpression {
    
    public Expression exp1, exp2;
    public int line, colunm;

    public Division(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    
    public Division(Expression exp1, Expression exp2, int l, int c) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.line = l;
        this.colunm = c;
    }
    
    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

}