package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;


public abstract class LiteralExpression extends Expression {

    @Override
    public abstract void accept(ParentPath PP);
    
    @Override
    public abstract VariableType accept(TypeVisitor PP);
    
}
