package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;


public class ModeIn extends Mode {

    public ModeIn() {}

    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
