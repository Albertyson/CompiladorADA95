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
    

    public AssignVariableWithDeclaration(VariableDeclaration vd, Expression exp) {
        this.vd = vd;
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
