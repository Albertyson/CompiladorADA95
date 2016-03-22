package abstractSyntaxTree;

import AST_Path.ParentPath;


public class Negative extends ArithmeticExpression {
    
    public Expression exp;

    public Negative(Expression exp) {
        this.exp = exp;
    }
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }
    
}
