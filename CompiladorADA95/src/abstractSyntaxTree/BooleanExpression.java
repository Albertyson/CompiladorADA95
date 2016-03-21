package abstractSyntaxTree;

import AST_Path.ParentPath;


public abstract class BooleanExpression extends Expression {
    @Override
    public abstract void callPath(ParentPath PP);
}
