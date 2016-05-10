package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class While extends Statement {
    
    public Expression exp;
    public Statements est;


    public While(Expression exp) {
        this.exp = exp;
    }
    
    public While(Expression exp, Statements est) {
        this.exp = exp;
        this.est = est;
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
