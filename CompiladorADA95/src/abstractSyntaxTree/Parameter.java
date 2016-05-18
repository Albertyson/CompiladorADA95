
package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;

/**
 *
 * @author Albertyson
 */
public class Parameter {
    
    public VariableIDs vars;
    public Mode mode;
    public VariableType type;
    public Expression exp;

    public Parameter(VariableIDs vars, VariableType type) {
        this.vars = vars;
        this.type = type;
    }

    public Parameter(VariableIDs vars, Mode mode, VariableType type) {
        this.vars = vars;
        this.mode = mode;
        this.type = type;
    }

    public Parameter(VariableIDs vars, VariableType type, Expression exp) {
        this.vars = vars;
        this.type = type;
        this.exp = exp;
    }

    public Parameter(VariableIDs vars, Mode mode, VariableType type, Expression exp) {
        this.vars = vars;
        this.mode = mode;
        this.type = type;
        this.exp = exp;
    }
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
