package abstractSyntaxTree;

import visitor.*;

public abstract class Type {
    public abstract void accept();
    public abstract VariableType accept(TypeVisitor PP);
}
