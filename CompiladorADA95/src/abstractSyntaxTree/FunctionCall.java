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

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }

    public FunctionParameters getFp() {
        return fp;
    }

    public void setFp(FunctionParameters fp) {
        this.fp = fp;
    }
    
}
