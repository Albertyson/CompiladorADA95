package abstractSyntaxTree;

import AST_Path.ParentPath;


public class Multiplication extends ArithmeticExpression {
    
    public Expression exp1, exp2;

    public Multiplication(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
