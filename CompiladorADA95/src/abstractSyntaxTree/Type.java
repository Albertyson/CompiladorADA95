package abstractSyntaxTree;

import intermediateCode.Cuadruplo;
import intermediateCode.IntermediateGenerable;
import visitor.*;

public abstract class Type {
    public abstract void accept();
    public abstract VariableType accept(TypeVisitor PP);
    public abstract Cuadruplo generate(IntermediateGenerable IG);
}
