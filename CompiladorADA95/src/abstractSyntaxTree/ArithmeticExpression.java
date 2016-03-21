package abstractSyntaxTree;

import AST_Path.ParentPath;


public abstract class ArithmeticExpression extends Expression {
    @Override
    public abstract void callPath(ParentPath PP);
}
