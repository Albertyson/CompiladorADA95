package abstractSyntaxTree;

import AST_Path.ParentPath;


public abstract class Expression extends Statement{
    
    @Override
    public abstract void callPath(ParentPath PP);
    
}
