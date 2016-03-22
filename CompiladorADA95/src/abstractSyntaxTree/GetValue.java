package abstractSyntaxTree;

import AST_Path.ParentPath;


public class GetValue extends Statement{
    
    public Identifier id;

    public GetValue(Identifier id) {
        this.id = id;
    }

    public Identifier getId() {
        return id;
    }

    public void setId(Identifier id) {
        this.id = id;
    }
    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
