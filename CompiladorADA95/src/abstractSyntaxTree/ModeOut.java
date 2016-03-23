package abstractSyntaxTree;

import AST_Path.ParentPath;

public class ModeOut extends Mode{

    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
