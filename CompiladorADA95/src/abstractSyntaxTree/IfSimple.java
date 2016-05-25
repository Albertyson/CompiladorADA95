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
    public int line, column;


    public IfSimple(Expression exp, Statements statements, int l, int c) {
        this.exp = exp;
        this.statements = statements;
        this.line = l;
        this.column = c;
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
