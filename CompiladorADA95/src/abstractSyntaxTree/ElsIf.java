package abstractSyntaxTree;

import AST_Path.ParentPath;

/**
 *
 * @author JosuéNoel
 */
public class ElsIf {
    
    public Expression exp;
    public Statements stms;

    public ElsIf(Expression exp, Statements stms) {
        this.exp = exp;
        this.stms = stms;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    public Statements getStms() {
        return stms;
    }

    public void setStms(Statements stms) {
        this.stms = stms;
    }
    
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
