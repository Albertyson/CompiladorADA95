package abstractSyntaxTree;

import AST_Path.ParentPath;


public class Identifier extends Expression {
    
    public String id;

    public Identifier(String id) {
        this.id = id;
    }
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
