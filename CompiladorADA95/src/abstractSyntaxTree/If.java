package abstractSyntaxTree;

import AST_Path.ParentPath;

/**
 *
 * @author JosuéNoel
 */
public abstract class If extends Statement {
    
    @Override
    public abstract void callPath(ParentPath PP);
    
}
