
package abstractSyntaxTree;

import AST_Path.ParentPath;
import visitor.TypeVisitor;


public class Parameter {
    
    public VariableIDs vars;
    public Mode mode;
    public VariableType type;
    public Expression exp;
    public int line, column;

    public Parameter(VariableIDs vars, VariableType type, int l, int c) {
        this.vars = vars;
        this.type = type;
        this.line = l;
        this.column = c;
    }

    public Parameter(VariableIDs vars, Mode mode, VariableType type, int l, int c) {
        this.vars = vars;
        this.mode = mode;
        this.type = type;
        this.line = l;
        this.column = c;
    }

    public Parameter(VariableIDs vars, VariableType type, Expression exp, int l, int c) {
        this.vars = vars;
        this.type = type;
        this.exp = exp;
        this.line = l;
        this.column = c;
    }

    public Parameter(VariableIDs vars, Mode mode, VariableType type, Expression exp, int l, int c) {
        this.vars = vars;
        this.mode = mode;
        this.type = type;
        this.exp = exp;
        this.line = l;
        this.column = c;
    }
    
    public void accept(ParentPath PP) {
        PP.path(this);
    }
    
    public VariableType accept(TypeVisitor PP) {
        return PP.path(this);
    }

    
}
