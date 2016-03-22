package abstractSyntaxTree;

import AST_Path.ParentPath;


public class FunctionCall extends Expression {
    
    public Identifier id;
    public FunctionParameters fp;

    public FunctionCall(Identifier id, FunctionParameters fp) {
        this.id = id;
        this.fp = fp;
    }
    
    public FunctionCall(Identifier id) {
        this.id = id;
    }
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
