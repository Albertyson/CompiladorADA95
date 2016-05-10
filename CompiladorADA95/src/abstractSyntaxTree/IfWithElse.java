package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class IfWithElse extends If {
    
    public Expression exp;
    public Statements s1;
    public Statements s2;

    public IfWithElse(Expression exp, Statements s1, Statements s2) {
        this.exp = exp;
        this.s1 = s1;
        this.s2 = s2;
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
