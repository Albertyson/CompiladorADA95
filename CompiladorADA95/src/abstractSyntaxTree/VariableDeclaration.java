package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;


public class VariableDeclaration extends Declaration {
    
    public VariableIDs variables;
    public VariableType type;
    public int line, colunm;

    public VariableDeclaration(VariableIDs variables, VariableType type, int l, int c) {
        this.variables = variables;
        this.type = type;
        this.line = l;
        this.colunm = c;
    }

    public VariableIDs getVariables() {
        return variables;
    }

    public VariableType getType() {
        return type;
    }
    
    @Override
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    @Override
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
