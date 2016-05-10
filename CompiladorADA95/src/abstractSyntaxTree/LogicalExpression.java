package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public abstract class LogicalExpression extends Expression {
    
    @Override
    public abstract void accept(ParentPath PP);
    
    @Override
    public abstract VariableType accept(TypeVisitor PP);
    
}