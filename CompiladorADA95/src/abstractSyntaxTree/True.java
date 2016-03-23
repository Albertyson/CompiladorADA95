package abstractSyntaxTree;

import AST_Path.ParentPath;

/**
 *
 * @author JosuéNoel
 */


public class True extends LiteralExpression {

    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
