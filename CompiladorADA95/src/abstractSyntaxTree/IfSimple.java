package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

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

    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
