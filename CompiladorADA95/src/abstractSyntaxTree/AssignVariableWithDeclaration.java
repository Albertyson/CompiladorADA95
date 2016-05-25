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
    public int line, column;
    

    public AssignVariableWithDeclaration(VariableDeclaration vd, Expression exp) {
        this.vd = vd;
        this.exp = exp;
    }
    
    public AssignVariableWithDeclaration(VariableDeclaration vd, Expression exp, int l, int c) {
        this.vd = vd;
        this.exp = exp;
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
