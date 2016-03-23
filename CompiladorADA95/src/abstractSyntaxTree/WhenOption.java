package abstractSyntaxTree;

import AST_Path.ParentPath;


public class WhenOption {
    
    public Expression exp;
    public Range range;

    public WhenOption(Expression exp) {
        this.exp = exp;
    }

    public WhenOption(Range range) {
        this.range = range;
    }

    public Expression getExp() {
        return exp;
    }

    public void setExp(Expression exp) {
        this.exp = exp;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }
    

    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
