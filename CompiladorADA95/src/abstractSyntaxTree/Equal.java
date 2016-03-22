package abstractSyntaxTree;

import AST_Path.ParentPath;


public class Equal extends BooleanExpression {
    
    public Expression exp1, exp2;

    public Equal(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }

    public Expression getExp1() {
        return exp1;
    }

    public void setExp1(Expression exp1) {
        this.exp1 = exp1;
    }

    public Expression getExp2() {
        return exp2;
    }

    public void setExp2(Expression exp2) {
        this.exp2 = exp2;
    }
    
}
