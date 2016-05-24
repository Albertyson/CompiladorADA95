package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class AssignVariableSimple extends AssignVariable {
    
    public Identifier id;
    public Expression exp;
    public int line, colunm;
    
    public AssignVariableSimple(Identifier id, Expression exp) {
        this.id = id;
        this.exp = exp;
    }
    
    public AssignVariableSimple(Identifier id, Expression exp, int l, int c) {
        this.id = id;
        this.exp = exp;
        this.line = l;
        this.colunm = c;
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
