package abstractSyntaxTree;

import AST_Path.ParentPath;

/**
 *
 * @author JosuéNoel
 */


public class Exit extends Statement {
    
    public Expression exp;

    public Exit(Expression exp) {
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
