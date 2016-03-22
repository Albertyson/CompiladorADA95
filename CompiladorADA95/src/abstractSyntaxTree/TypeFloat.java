package abstractSyntaxTree;

import AST_Path.ParentPath;


public class TypeFloat extends VariableType {
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
