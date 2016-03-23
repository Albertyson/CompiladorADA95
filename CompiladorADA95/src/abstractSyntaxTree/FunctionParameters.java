package abstractSyntaxTree;

import AST_Path.ParentPath;
import java.util.ArrayList;

/**
 *
 * @author JosuéNoel
 */


public class FunctionParameters {
    
    private ArrayList<Expression> exps;
    
    public FunctionParameters() {
        exps = new ArrayList();
    }
    
    public void add(Expression e) {
        exps.add(e);
    }
    
    public int size() {
        return exps.size();
    } 
    
    public Expression getAt(int pos) {
        return exps.get(pos);
    }
    
    public ArrayList<Expression> getExps() {
        return exps;
    }

    public void setExps(ArrayList<Expression> exps) {
        this.exps = exps;
    }
    
    public void callPath(ParentPath PP) {
        PP.path(this);
    }
    
}
