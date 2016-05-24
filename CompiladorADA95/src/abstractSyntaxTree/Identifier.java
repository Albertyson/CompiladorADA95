                   package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public class Identifier extends Expression {
    
    public String id;
    public int line, colunm;
    
    public Identifier(String id, int l, int c) {
        this.id = id;
        this.line = l;
        this.colunm = c;
    }
    
    public boolean equals(Identifier id2){
        return id.equals(id2.id);
    }
    
    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
