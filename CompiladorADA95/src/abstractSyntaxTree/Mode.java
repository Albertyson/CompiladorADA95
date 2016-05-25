package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;


public abstract class Mode {
    
    public abstract void accept(ParentPath PP);
    
    public abstract VariableType accept(TypeVisitor PP);
    
}
