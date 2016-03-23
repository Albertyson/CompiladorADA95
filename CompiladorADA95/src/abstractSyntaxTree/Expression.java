package abstractSyntaxTree;

import AST_Path.ParentPath;

/**
 *
 * @author JosuéNoel
 */


public abstract class Expression extends Statement {
    
    @Override
    public abstract void callPath(ParentPath PP);
    
}
