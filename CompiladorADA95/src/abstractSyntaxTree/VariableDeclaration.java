package abstractSyntaxTree;

import AST_Path.ParentPath;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author JosuéNoel
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class VariableDeclaration extends Declaration {
    
    public VariableIDs variables;
    public VariableType type;

    public VariableDeclaration() {
    }

    public VariableDeclaration(VariableIDs variables, VariableType type) {
        this.variables = variables;
        this.type = type;
    }

    public VariableIDs getVariables() {
        return variables;
    }

    public void setVariables(VariableIDs variables) {
        this.variables = variables;
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }

    
    @Override
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
