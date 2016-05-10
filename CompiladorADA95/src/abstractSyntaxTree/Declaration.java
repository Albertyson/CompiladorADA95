package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public abstract class Declaration {
    
    public abstract void accept(ParentPath PP);
    
    public abstract VariableType accept(TypeVisitor PP);
    
}
