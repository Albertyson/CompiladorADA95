
package abstractSyntaxTree;

import AST_Path.ParentPath;

public class Parameter {
    private VariableIDs vars;
    private Mode mode;
    private VariableType type;
    private Expression exp;

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

    public VariableIDs getVars() {
        return vars;
    }

    public void setVars(VariableIDs vars) {
        this.vars = vars;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }
    public void callPath(ParentPath PP) {
        PP.path(this);
    }    
    
}
