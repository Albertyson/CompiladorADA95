package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public class Identifier extends Expression {
    
    public String id;
    
    public Identifier(String id) {
        this.id = id;
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
