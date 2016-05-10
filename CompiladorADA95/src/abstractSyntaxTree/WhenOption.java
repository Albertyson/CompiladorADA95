package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class WhenOption {
    
    public Expression exp;
    public Range range;


    public WhenOption(Expression exp) {
        this.exp = exp;
    }

    public WhenOption(Range range) {
        this.range = range;
    }
    

    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
