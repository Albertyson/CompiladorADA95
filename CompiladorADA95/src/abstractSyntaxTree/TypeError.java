package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class TypeError extends VariableType {

    public TypeError() {}

    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TypeError;
    }

    @Override
    public String generate(IntermediateGenerable IG) {
        return IG.visit(this);
    }
    
}
