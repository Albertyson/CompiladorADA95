package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class AssignVariableWithDeclaration extends AssignVariable {
    
    public VariableDeclaration vd;
    public Expression exp;
    
    public AssignVariableWithDeclaration() {}

    public AssignVariableWithDeclaration(VariableDeclaration vd, Expression exp) {
        this.vd = vd;
        this.exp = exp;
    }

    public VariableDeclaration getVd() {
        return vd;
    }

    public void setVd(VariableDeclaration vd) {
        this.vd = vd;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
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
