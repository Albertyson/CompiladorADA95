package abstractSyntaxTree;

import AST_Path.ParentPath;


public class TypeBoolean extends VariableType {
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
