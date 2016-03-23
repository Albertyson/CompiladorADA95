package abstractSyntaxTree;

import AST_Path.ParentPath;

/**
 *
 * @author JosuéNoel
 */


public abstract class LogicalExpression extends Expression {
    
    @Override
    public abstract void callPath(ParentPath PP);
    
}
