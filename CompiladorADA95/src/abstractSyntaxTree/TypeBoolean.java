package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class TypeBoolean extends VariableType {

    public TypeBoolean() {}
    
    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
