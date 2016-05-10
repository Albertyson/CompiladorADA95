package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;


public class TypeChar extends VariableType{
    
    public TypeChar() {}

    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }
    
}
