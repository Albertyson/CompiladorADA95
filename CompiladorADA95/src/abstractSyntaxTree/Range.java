package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class Range {
    
    public Expression exp1, exp2;

    public Range(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    

    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
