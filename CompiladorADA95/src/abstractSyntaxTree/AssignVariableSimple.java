package abstractSyntaxTree;

import AST_Path.ParentPath;

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

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
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
