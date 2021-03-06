package abstractSyntaxTree;

import AST_Path.ParentPath;
import intermediateCode.IntermediateGenerable;
import visitor.TypeVisitor;


public abstract class LogicalExpression extends Expression {
    
    @Override
    public abstract void accept(ParentPath PP);
    
    @Override
    public abstract VariableType accept(TypeVisitor PP);
    
    @Override
    public abstract String generate(IntermediateGenerable IG);
    
}