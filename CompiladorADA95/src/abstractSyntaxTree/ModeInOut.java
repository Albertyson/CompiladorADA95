package abstractSyntaxTree;

import AST_Path.ParentPath;

public class ModeInOut extends Mode{

    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
