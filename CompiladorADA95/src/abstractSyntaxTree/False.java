package abstractSyntaxTree;

import AST_Path.ParentPath;


public class False extends LiteralExpression {

    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
