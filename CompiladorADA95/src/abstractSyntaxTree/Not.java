package abstractSyntaxTree;

import AST_Path.ParentPath;


public class Not extends LogicalExpression {
    
    public Expression exp;

    public Not(Expression exp) {
        this.exp = exp;
    }
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
