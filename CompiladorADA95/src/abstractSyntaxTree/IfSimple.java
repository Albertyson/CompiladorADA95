package abstractSyntaxTree;

import AST_Path.ParentPath;

/**
 *
 * @author JosuéNoel
 */
public class IfSimple extends If {
    
    public Expression exp;
    public Statements statements;

    public IfSimple(Expression exp, Statements statements) {
        this.exp = exp;
        this.statements = statements;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    public Statements getStatements() {
        return statements;
    }

    public void setStatements(Statements statements) {
        this.statements = statements;
    }
    

    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
