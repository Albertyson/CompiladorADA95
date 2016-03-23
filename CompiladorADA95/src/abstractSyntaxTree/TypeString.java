package abstractSyntaxTree;

import AST_Path.ParentPath;

/**
 *
 * @author JosuéNoel
 */


public class TypeString extends VariableType{
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
