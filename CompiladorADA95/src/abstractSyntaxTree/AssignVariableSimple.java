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
    
    public AssignVariableSimple(Identifier id, Expression exp) {
        this.id = id;
        this.exp = exp;
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
