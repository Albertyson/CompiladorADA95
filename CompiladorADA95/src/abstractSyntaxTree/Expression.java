package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */

public abstract class Expression extends Statement {
    
    @Override
    public abstract void accept(ParentPath PP);
    
    @Override
    public abstract VariableType accept(TypeVisitor PP);
    
    @Override
    public abstract Cuadruplo generate(IntermediateGenerable IG);
    
}
