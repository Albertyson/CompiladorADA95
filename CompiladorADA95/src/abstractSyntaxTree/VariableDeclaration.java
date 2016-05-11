package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author JosuéNoel
 */
public class VariableDeclaration extends Declaration {
    
    public VariableIDs variables;
    public VariableType type;

    public VariableDeclaration(VariableIDs variables, VariableType type) {
        this.variables = variables;
        this.type = type;
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
