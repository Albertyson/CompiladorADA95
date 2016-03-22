package abstractSyntaxTree;

import AST_Path.ParentPath;


public class PutValue extends Statement {
    
    public Expression exp;

    public PutValue(Expression exp) {
        this.exp = exp;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
