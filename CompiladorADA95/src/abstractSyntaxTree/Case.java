package abstractSyntaxTree;

import AST_Path.ParentPath;

/**
 *
 * @author JosuéNoel
 */


public abstract class Case extends Statement {
    
    @Override
    public abstract void callPath(ParentPath PP);
    
}
