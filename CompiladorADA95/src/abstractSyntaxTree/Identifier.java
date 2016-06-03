                   package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public class Identifier extends Expression {
    
    public String id;
    public int line, column;
    
    public Identifier(String id, int l, int c) {
        this.id = id;
        this.line = l;
        this.column = c;
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

    @Override
    public String generate(IntermediateGenerable IG) {
        return IG.visit(this);
    }
}
